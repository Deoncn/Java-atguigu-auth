package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.atguigu.system.mapper.LoginLogMapper;
import com.atguigu.system.service.LoginLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ClassName:LoginLogServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/7 - 17:11
 * @ Version: v1.0
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;


    @Override
    public void recordLoginLog(String username, Integer status, String ipaddr, String message) {

        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setStatus(status);
        sysLoginLog.setIpaddr(ipaddr);
        sysLoginLog.setMsg(message);
        loginLogMapper.insert(sysLoginLog);
    }

    @Override
    public IPage<SysLoginLog> selectPage(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo) {
        //创建 page 都西昂
        Page<SysLoginLog> pageParam = new Page(page,limit);
        // 获取条件值
        String username = sysLoginLogQueryVo.getUsername();
        String createTimeBegin = sysLoginLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysLoginLogQueryVo.getCreateTimeEnd();
        // 封装条件
        QueryWrapper<SysLoginLog> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(username)){
            wrapper.like("username",username);
        }
        if(!StringUtils.isEmpty(createTimeBegin)){
            wrapper.ge("create_time",createTimeBegin);
        }

        if(!StringUtils.isEmpty(createTimeBegin)){
            wrapper.le("create_time",createTimeEnd);
        }

        //  调用mapper 方法
        IPage<SysLoginLog> pageModel = loginLogMapper.selectPage(pageParam, wrapper);

        return pageModel;
    }
}
