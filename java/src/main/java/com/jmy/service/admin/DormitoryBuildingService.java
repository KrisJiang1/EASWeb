package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.DormitoryBuilding;

import java.util.List;
import java.util.Map;

public interface DormitoryBuildingService extends IService<DormitoryBuilding> {

    DormitoryBuilding insertDormitoryBuilding(DormitoryBuilding dormitoryBuilding);

    DormitoryBuilding updateDormitoryBuilding(DormitoryBuilding dormitoryBuilding);

    Integer deleteDormitoryBuilding(Integer id);

    List<Map> listPage(JSONObject params);

}
