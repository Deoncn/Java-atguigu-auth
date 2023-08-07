package com.atguigu.system.test;


import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:SysRoleMapperTest
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/6/28 - 4:51
 * @ Version: v1.0
 */
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    //7 条件删除
    @Test
    public void testDelete(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","用户管理员");

        sysRoleMapper.delete(wrapper);

    }


    // 6 条件查询
    @Test
    public void testSelect(){
        // 创建条件构造器对象
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        //设置条件和值
        // wrapper.eq("role_name","用户管理员");
        wrapper.like("role_name","管理员");


        //调用方法查询
        List<SysRole> list = sysRoleMapper.selectList(wrapper);

        System.out.println(list);

    }


    @Test
    public void testBatchDelete(){
        sysRoleMapper.deleteBatchIds(Arrays.asList(8,9));
    }


    @Test
    public void deleteId(){
        int rows = sysRoleMapper.deleteById(2);
    }


    @Test
    public void update(){
        //根据id 查询出要改的数据
        SysRole sysRole = sysRoleMapper.selectById(9);

        //设置修改值
        sysRole.setDescription("系统管理员我恐龙");

        //调用实现方法
        sysRoleMapper.updateById(sysRole);

    }



    @Test //向数据库中添加一条数据
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("恐龙2");
        sysRole.setRoleCode("test2");
        sysRole.setDescription("测试角色2");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);

    }

    @Test //查询表所有记录
    public void findAll() {
        List<SysRole> list = sysRoleMapper.selectList(null);
        for(SysRole sysRole:list){
            System.out.println(sysRole);
        }
    }
}
