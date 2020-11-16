package com.jmy.service.admin;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService extends IService<Teacher> {

    Teacher insertTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    Integer deleteTeacher(Integer id);

    List<Map> listPage(JSONObject params);
}
