package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService extends IService<Subject> {

    Subject insertSubject(Subject subject);

    Subject updateSubject(Subject subject);

    Integer deleteSubject(Integer id);

    List<Map> listPage(JSONObject params);
}
