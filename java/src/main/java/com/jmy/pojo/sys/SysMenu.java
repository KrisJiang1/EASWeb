package com.jmy.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("SYS_MENU")
public class SysMenu {

  @TableId(type = IdType.ID_WORKER)
  private String menuId;
  private String parentId;
  private String menuName;
  private String menuUrl;
  private String menuPerms;
  private Integer menuType;
  private String menuIcon;
  private Integer menuOrderNum;


  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  public String getMenuPerms() {
    return menuPerms;
  }

  public void setMenuPerms(String menuPerms) {
    this.menuPerms = menuPerms;
  }

  public Integer getMenuType() {
    return menuType;
  }

  public void setMenuType(Integer menuType) {
    this.menuType = menuType;
  }

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }

  public Integer getMenuOrderNum() {
    return menuOrderNum;
  }

  public void setMenuOrderNum(Integer menuOrderNum) {
    this.menuOrderNum = menuOrderNum;
  }
}
