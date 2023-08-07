package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.RouterVo;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.mapper.SysUserMapper;
import com.atguigu.system.service.SysMenuService;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-07-31
 */
@Api(tags = "角色管理接口")
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysMenuService sysMenuService;

    // 用户列表
    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(pageParam, sysUserQueryVo);
    }


    //  更改用户状态
    @Override
    public void updateStatus(String id, Integer status) {
        // 更具用户ID 查询数据
        SysUser sysUser = baseMapper.selectById(id);
        // 设置要修改的状态
        sysUser.setStatus(status);
        //调用方法修改
        baseMapper.updateById(sysUser);
    }

    @Override
    public SysUser getUserInfoByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        // 根据用户名称查询出用户的基本信息
        SysUser sysUser = this.getUserInfoByUserName(username);
        //根据 userid 查询菜单权限值
        List<RouterVo> routerVolist = sysMenuService.getUserMenuList(sysUser.getId());
        // 根据userid 查询按钮权限值
         List<String> permsList = sysMenuService.getUserButtonList(sysUser.getId());

        HashMap<String, Object> result = new HashMap<>();
        result.put("name", username);
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("roles", " [\"admin\"]");
        // 菜单权限数据
        result.put("buttons", permsList);
        // 按钮权限数据
        result.put("routers", routerVolist);


        return result;
    }


}
