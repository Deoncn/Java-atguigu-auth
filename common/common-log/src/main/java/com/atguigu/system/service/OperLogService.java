package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * ClassName:OperLogService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/7 - 18:05
 * @ Version: v1.0
 */
public interface OperLogService {

  public void saveSysLog(SysOperLog sysOperLog);

  //  操作日志分页查询
  IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);


}
