package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_DORMITORY")
public class Dormitory {

  @TableId(type = IdType.ID_WORKER_STR)
  private String dormitoryId;
  private String dormitoryName;
  private String dormitoryBuildingId;
  private String dormitoryPeoNum;


  public String getDormitoryId() {
    return dormitoryId;
  }

  public String getDormitoryName() {
    return dormitoryName;
  }

  public void setDormitoryName(String dormitoryName) {
    this.dormitoryName = dormitoryName;
  }

  public String getDormitoryBuildingId() {
    return dormitoryBuildingId;
  }

  public void setDormitoryBuildingId(String dormitoryBuildingId) {
    this.dormitoryBuildingId = dormitoryBuildingId;
  }

  public String getDormitoryPeoNum() {
    return dormitoryPeoNum;
  }

  public void setDormitoryPeoNum(String dormitoryPeoNum) {
    this.dormitoryPeoNum = dormitoryPeoNum;
  }
}
