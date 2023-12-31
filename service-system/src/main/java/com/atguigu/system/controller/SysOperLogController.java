package com.atguigu.system.controller;

/**
 * ClassName:SysOperLogController
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/7 - 21:11
 * @ Version: v1.0
 */
import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysOperLog;
import com.atguigu.system.service.OperLogService;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "SysOperLog管理", tags = "SysOperLog管理")
@RestController
@RequestMapping(value="/admin/system/sysOperLog")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperLogController {

    @Autowired
    private OperLogService operLogService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "sysOperLogVo", value = "查询对象", required = false)
            SysOperLogQueryVo sysOperLogQueryVo) {
        IPage<SysOperLog> pageModel = operLogService.selectPage(page,limit,sysOperLogQueryVo);
        return Result.ok(pageModel);
    }

}
