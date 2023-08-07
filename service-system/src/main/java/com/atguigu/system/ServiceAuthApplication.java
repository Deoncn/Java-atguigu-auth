package com.atguigu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:ServiceAuthApplication
 * Package: IntelliJ IDEA
 * Description:
 * <p>
 * @ Author: Deoncn
 * @ Create: 2023/6/28 - 3:55
 * @ Version: v1.0
 */

@MapperScan(basePackages = "com.atguigu.system.mapper")
@SpringBootApplication
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
