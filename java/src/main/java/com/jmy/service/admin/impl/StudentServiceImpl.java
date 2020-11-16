package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.StudentDao;
import com.jmy.pojo.admin.Student;
import com.jmy.service.admin.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {


    @Autowired
    StudentDao studentDao;

    @Override
    public Student insertStudent(Student student) {
        studentDao.insert(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        studentDao.updateById(student);
        return student;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        Integer delete = studentDao.deleteById(id);
        return delete;
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String studentName = params.getString("studentName");
        String studentSex = params.getString("studentSex");
        String studentPhone = params.getString("studentPhone");
        String studentIdNum = params.getString("studentIdNum");
        String clazzId = params.getString("clazzId");
        String majorId = params.getString("majorId");
        String dormitoryId = params.getString("dormitoryId");
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty("studentName")){
            wrapper.eq("student_Name",studentName);
        }
        if (!StringUtils.isEmpty("studentSex")){
            wrapper.eq("student_Sex",studentSex);
        }
        if (!StringUtils.isEmpty("studentPhone")){
            wrapper.eq("student_Phone",studentPhone);
        }
        if (!StringUtils.isEmpty("studentIdNum")){
            wrapper.eq("student_IdNum",studentIdNum);
        }
        if (!StringUtils.isEmpty("clazzId")){
            wrapper.eq("clazz_Id",clazzId);
        }
        if (!StringUtils.isEmpty("majorId")){
            wrapper.eq("major_Id",majorId);
        }
        if (!StringUtils.isEmpty("dormitoryId")){
            wrapper.eq("dormitory_Id",dormitoryId);
        }
        List<Map> resultList;
        if (size > 0 && current > 0){
            Page<Student> page = new Page(size,current);
            resultList = studentDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = studentDao.listPage(wrapper);
        }
        return resultList;
    }
}
