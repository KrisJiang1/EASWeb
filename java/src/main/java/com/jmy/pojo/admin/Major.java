package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_MAJOR")
public class Major {

  @TableId(type = IdType.ID_WORKER_STR)
  private String majorId;
  private String majorName;
  private String majorSchoolSystem;

  public String getMajorId() {
    return majorId;
  }

  public void setMajorId(String majorId) {
    this.majorId = majorId;
  }

  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }

  public String getMajorSchoolSystem() {
    return majorSchoolSystem;
  }

  public void setMajorSchoolSystem(String majorSchoolSystem) {
    this.majorSchoolSystem = majorSchoolSystem;
  }
}
