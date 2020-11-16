package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Clazz;

import java.util.List;


public interface ClazzService extends IService<Clazz> {

    Clazz insertClazz(Clazz clazz);

    Clazz updateClazz(Clazz clazz);

    Integer deleteClazz(Integer clazzId);

    //查询所有（分页）
    List listPage(JSONObject params);
}
