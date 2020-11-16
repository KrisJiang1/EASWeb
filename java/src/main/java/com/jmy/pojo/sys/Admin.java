package com.jmy.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_ADMIN")
public class Admin {

  @TableId(type = IdType.ID_WORKER)
  private String adminId;
  private String adminAccountNum;
  private String adminPwd;
  private String adminAccessLevel;

  public String getAdminId() {
    return adminId;
  }

  public String getAdminAccountNum() {
    return adminAccountNum;
  }

  public void setAdminAccountNum(String adminAccountNum) {
    this.adminAccountNum = adminAccountNum;
  }

  public String getAdminPwd() {
    return adminPwd;
  }

  public void setAdminPwd(String adminPwd) {
    this.adminPwd = adminPwd;
  }

  public String getAdminAccessLevel() {
    return adminAccessLevel;
  }

  public void setAdminAccessLevel(String adminAccessLevel) {
    this.adminAccessLevel = adminAccessLevel;
  }
}
