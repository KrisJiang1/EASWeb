package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_TEACHER")
public class Teacher {

  @TableId(type = IdType.ID_WORKER_STR)
  private String teacherId;
  private String teacherName;
  private String teacherSex;
  private String teacherPhone;
  private String teacherIdNum;
  private String postId;
  private String majorId;
  private String teacherAddress;

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public String getTeacherSex() {
    return teacherSex;
  }

  public void setTeacherSex(String teacherSex) {
    this.teacherSex = teacherSex;
  }

  public String getTeacherPhone() {
    return teacherPhone;
  }

  public void setTeacherPhone(String teacherPhone) {
    this.teacherPhone = teacherPhone;
  }

  public String getTeacherIdNum() {
    return teacherIdNum;
  }

  public void setTeacherIdNum(String teacherIdNum) {
    this.teacherIdNum = teacherIdNum;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getMajorId() {
    return majorId;
  }

  public void setMajorId(String majorId) {
    this.majorId = majorId;
  }

  public String getTeacherAddress() {
    return teacherAddress;
  }

  public void setTeacherAddress(String teacherAddress) {
    this.teacherAddress = teacherAddress;
  }
}
