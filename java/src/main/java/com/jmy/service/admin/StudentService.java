package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Student;

import java.util.List;
import java.util.Map;


public interface StudentService extends IService<Student> {

    Student insertStudent(Student student);

    Student updateStudent(Student student);

    Integer deleteStudent(Integer id);

    List<Map> listPage(JSONObject params);
}
