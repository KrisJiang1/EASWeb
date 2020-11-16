package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;


@Component
@TableName("EAS_STUDENT")
public class Student {

    @TableId(type = IdType.ID_WORKER_STR)
  private String studentId;
  private String studentName;
  private String studentSex;
  private String studentPhone;
  private String studentIdNum;
  private String clazzId;
  private String majorId;
  private String dormitoryId;

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentSex() {
    return studentSex;
  }

  public void setStudentSex(String studentSex) {
    this.studentSex = studentSex;
  }

  public String getStudentPhone() {
    return studentPhone;
  }

  public void setStudentPhone(String studentPhone) {
    this.studentPhone = studentPhone;
  }

  public String getStudentIdNum() {
    return studentIdNum;
  }

  public void setStudentIdNum(String studentIdNum) {
    this.studentIdNum = studentIdNum;
  }

  public String getClazzId() {
    return clazzId;
  }

  public void setClazzId(String clazzId) {
    this.clazzId = clazzId;
  }

  public String getMajorId() {
    return majorId;
  }

  public void setMajorId(String majorId) {
    this.majorId = majorId;
  }

  public String getDormitoryId() {
    return dormitoryId;
  }

  public void setDormitoryId(String dormitoryId) {
    this.dormitoryId = dormitoryId;
  }
}
