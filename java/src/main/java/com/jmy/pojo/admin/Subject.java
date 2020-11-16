package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_SUBJECT")
public class Subject {

  @TableId(type = IdType.ID_WORKER_STR)
  private String subjectId;
  private String subjectName;
  private String majorMinor;

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getMajorMinor() {
    return majorMinor;
  }

  public void setMajorMinor(String majorMinor) {
    this.majorMinor = majorMinor;
  }
}
