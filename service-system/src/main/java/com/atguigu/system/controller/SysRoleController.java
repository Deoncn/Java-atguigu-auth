package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.service.SysRoleService;
import com.atguigu.system.enums.BusinessType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.atguigu.system.annotation.Log;
import java.util.List;
import java.util.Map;

/**
 * ClassName:SystemRoleController
 * Package: IntelliJ IDEA
 * Description:
 * @ Author: Deoncn
 * @ Create: 2023/6/29 - 9:01
 * @ Version: v1.0
 */

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("获取用户的角色数据")
    @GetMapping("toAssign/{userId}")
    public Result toAssign(@PathVariable String userId){
       Map<String,Object> roleMap = sysRoleService.getRolesByUserId(userId);
       return Result.ok(roleMap);
    }

    @ApiOperation("用户分配角色")
    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo){
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();

    }



    //1 查询所有的记录
    // http://localhost:8800/admin/system/sysRole/findAll
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public Result findAllRole() {
        //TODO 模拟异常效果 ArithmeticException
//        try {
//            int i = 9/0;
//        } catch (Exception e) {
//            // 手动抛出异常
//            throw new GuiguException(20001, "执行了自定义异常处理");
//        }
        // System.out.println(i);

        //调用Service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }


    //2 逻辑删除接口
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("remove/{id}")
    public Result removeRol(@PathVariable Long id) {
        //调用方法删除
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    //3 条件分页查询
    // page 代表当前页，limit 代表每页记录数
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo) {
        // 创建 page 对象
        Page<SysRole> pageParam = new Page<>(page, limit);

        // 调用service 方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);

        // 返回
        return Result.ok(pageModel);
    }

    //4 添加接口
    // @RequestBody 不能使用 get 提交方式
    // 传递 json格式数据，把json格式数据封装到对象里面 {...}'
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //5 修改-根据id 查询
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("根据id 查询")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //6 修改-最终修改
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result findRoleById(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok();

        } else {
            return Result.fail();
        }
    }

    //7 批量删除
    // 获取多个id 值 [1,2,3]
    // json 数组格式 --- 对应 java 的list 集合
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }


}
