package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-07-31
 */
public interface SysUserService extends IService<SysUser> {

    //  用户列表
    IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo);

    // 更改用户状态
    void updateStatus(String id, Integer status);

    // username 查询
    SysUser getUserInfoByUserName(String username);

    Map<String, Object> getUserInfo(String username);
}
