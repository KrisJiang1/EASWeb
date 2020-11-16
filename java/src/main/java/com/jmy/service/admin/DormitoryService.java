package com.jmy.service.admin;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Dormitory;

import java.util.List;
import java.util.Map;

public interface DormitoryService extends IService<Dormitory> {

    Dormitory insertDormitory(Dormitory dormitory);

    Dormitory updateDormitory(Dormitory dormitory);

    Integer deleteDormitory(Integer id);

    List<Map> listPage(JSONObject params);

}
