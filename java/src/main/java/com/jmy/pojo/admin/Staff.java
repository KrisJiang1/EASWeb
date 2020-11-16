package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;


@Component
@TableName("EAS_STAFF")
public class Staff {

  @TableId(type = IdType.ID_WORKER_STR)
  private String staffId;
  private String staffName;
  private String staffSex;
  private String staffPhone;
  private String staffIdNum;
  private String postId;
  private String staffAddress;

  public String getStaffId() {
    return staffId;
  }

  public void setStaffId(String staffId) {
    this.staffId = staffId;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getStaffSex() {
    return staffSex;
  }

  public void setStaffSex(String staffSex) {
    this.staffSex = staffSex;
  }

  public String getStaffPhone() {
    return staffPhone;
  }

  public void setStaffPhone(String staffPhone) {
    this.staffPhone = staffPhone;
  }

  public String getStaffIdNum() {
    return staffIdNum;
  }

  public void setStaffIdNum(String staffIdNum) {
    this.staffIdNum = staffIdNum;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getStaffAddress() {
    return staffAddress;
  }

  public void setStaffAddress(String staffAddress) {
    this.staffAddress = staffAddress;
  }
}
