package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Staff;

import java.util.List;
import java.util.Map;


public interface StaffService extends IService<Staff> {

    Staff insertStaff(Staff staff);

    Staff updateStaff(Staff staff);

    Integer deleteStaff(Integer id);

    List<Map> listPage(JSONObject params);
}
