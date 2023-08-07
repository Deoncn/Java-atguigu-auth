package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.system.custom.CustomUser;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:UserDetailsServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/4 - 12:45
 * @ Version: v1.0
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserInfoByUserName(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (sysUser.getStatus().intValue() == 0) {
            throw new RuntimeException("用户被禁用了");
        }


        // 根据userId 查询权限数据
        List<String> userPermsList = sysMenuService.getUserButtonList(sysUser.getId());
        // 转换security 要求的格式
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String perm : userPermsList) {
            authorities.add(new SimpleGrantedAuthority(perm.trim()));
        }

        return new CustomUser(sysUser, authorities);
    }
}
