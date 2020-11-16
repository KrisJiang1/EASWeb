package com.jmy.controller.sys;

import com.jmy.pojo.sys.SysMenu;
import com.jmy.service.sys.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/sysMenu")
public class SysMenuController {

//    @Autowired
//    SysMenuService sysMenuService;
//
//    @GetMapping
//    @RequestMapping("list")
//    public List list(){
//        List<SysMenu> menuList = sysMenuService.getMenuList();
//        return menuList;
//    }
}
