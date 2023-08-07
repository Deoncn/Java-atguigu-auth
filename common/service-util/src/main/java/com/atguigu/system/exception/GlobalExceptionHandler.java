package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ClassName:GlobalExceptionHandler
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/7/14 - 20:30
 * @ Version: v1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    //1 全局一场 (ResponseBody 返回JSON 数据)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        System.out.println("全局");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }


    //2 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        System.out.println("特定......");
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    //3 自定义异常处理
    @ExceptionHandler(GuiguException.class)
    @ResponseBody
    public Result error(GuiguException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

    /**
     * spring security异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result error(AccessDeniedException e) throws AccessDeniedException {
        return Result.fail().code(ResultCodeEnum.PERMISSION.getCode()).message("没有当前功能的操作权限");
    }

}
