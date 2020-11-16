package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Major;

import java.util.List;
import java.util.Map;

public interface MajorService extends IService<Major> {


    Major insertMajor(Major major);

    Major updateMajor(Major major);

    Integer deleteMajor(Integer id);

    List<Map> listPage(JSONObject params);
}

