package com.atguigu.system.service;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * ClassName:AsyncLoginLogService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/7 - 17:09
 * @ Version: v1.0
 */
public interface LoginLogService {



    //登录日志
    public void recordLoginLog(String username,Integer status,String ipaddr,String message);

    // 条件分页查询登录日志

    IPage<SysLoginLog> selectPage(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo);

}
