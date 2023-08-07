package com.atguigu.system.enums;

/**
 * ClassName:BusinessType
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/7 - 17:59
 * @ Version: v1.0
 */
/**
 * 业务操作类型
 */
public enum BusinessType {
 /**
  * 其它
  */
 OTHER,

 /**
  * 新增
  */
 INSERT,

 /**
  * 修改
  */
 UPDATE,

 /**
  * 删除
  */
 DELETE,

 /**
  * 授权
  */
 ASSGIN,

 /**
  * 导出
  */
 EXPORT,

 /**
  * 导入
  */
 IMPORT,

 /**
  * 强退
  */
 FORCE,

 /**
  * 更新状态
  */
 STATUS,

 /**
  * 清空数据
  */
 CLEAN,
}
