package com.atguigu.system.utils;

import com.atguigu.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:MenuHelper
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/8/2 - 21:55
 * @ Version: v1.0
 */
public class MenuHelper {

    // 构建树形结构
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        // 创建集合封装最终数据
        List<SysMenu> trees = new ArrayList<>();
        // 遍历所有菜单集合
        for (SysMenu sysMenu : sysMenuList) {
            // 找到递归 ,parentid=0
            if (sysMenu.getParentId().longValue() == 0) {
              trees.add(findChildren(sysMenu,sysMenuList));
            }
        }

        return trees;
    }

    // 从跟节点你进行递归查询，查询子节点
 // 判断 id = parentid 是否相同，如果相同是子节点，进行数据封装
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
    // 数据初始化
    sysMenu.setChildren(new ArrayList<SysMenu>());

     //遍历递归擦查找
     for (SysMenu it:treeNodes){
      // 获取当前菜单id
      // String id = sysMenu.getId();
      //      long cid = Long.parseLong(id);
      //获取所有菜单parentid
      //      Long parentId = it.getParentId();
      //比对
      if(Long.parseLong(sysMenu.getId()) == it.getParentId()){
         if(sysMenu.getChildren() == null){
          sysMenu.setChildren(new ArrayList<>());
         }
        sysMenu.getChildren().add(findChildren(it,treeNodes));
      }
     }
     return sysMenu;
 }
}
