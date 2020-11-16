package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.TeacherDao;
import com.jmy.pojo.admin.Student;
import com.jmy.pojo.admin.Teacher;
import com.jmy.service.admin.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {


    @Autowired
    TeacherDao teacherDao;

    @Override
    public Teacher insertTeacher(Teacher teacher) {
        teacherDao.insert(teacher);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        teacherDao.updateById(teacher);
        return teacher;
    }

    @Override
    public Integer deleteTeacher(Integer id) {
        return teacherDao.deleteById(id);
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String teacherName = params.getString("teacherName");
        String teacherSex = params.getString("teacherSex");
        String teacherPhone = params.getString("teacherPhone");
        String teacherIdNum = params.getString("teacherIdNum");
        String majorId = params.getString("majorId");
        String teacherAddress = params.getString("teacherAddress");
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty("teacherName")){
            wrapper.eq("teacher_Name",teacherName);
        }
        if (!StringUtils.isEmpty("teacherSex")){
            wrapper.eq("teacher_Sex",teacherSex);
        }
        if (!StringUtils.isEmpty("teacherPhone")){
            wrapper.eq("teacher_Phone",teacherPhone);
        }
        if (!StringUtils.isEmpty("teacherIdNum")){
            wrapper.eq("teacher_IdNum",teacherIdNum);
        }
        if (!StringUtils.isEmpty("teacherAddress")){
            wrapper.eq("teacher_Address",teacherAddress);
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
