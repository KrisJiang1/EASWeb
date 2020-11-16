package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;


@Component
@TableName("EAS_DORMITORYBUILDING")
public class DormitoryBuilding {

  @TableId(type = IdType.ID_WORKER_STR)
  private String DormitoryBuildingId;
  private String DormitoryBuildingName;
  private String managerId;

  public String getDormitoryBuildingId() {
    return DormitoryBuildingId;
  }

  public void setDormitoryBuildingId(String dormitoryBuildingId) {
    DormitoryBuildingId = dormitoryBuildingId;
  }

  public String getDormitoryBuildingName() {
    return DormitoryBuildingName;
  }

  public void setDormitoryBuildingName(String dormitoryBuildingName) {
    DormitoryBuildingName = dormitoryBuildingName;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }
}
