package com.atguigu.system.mapper;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName:SysRoleMapper
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/6/28 - 4:47
 * @ Version: v1.0
 */

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    // 条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam,@Param("vo") SysRoleQueryVo sysRoleQueryVo);


}
