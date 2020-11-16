package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.SubjectDao;
import com.jmy.pojo.admin.Subject;
import com.jmy.service.admin.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {

    @Autowired
    SubjectDao subjectDao;

    @Override
    public Subject insertSubject(Subject subject) {
        subjectDao.insert(subject);
        return subject;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        subjectDao.updateById(subject);
        return subject;
    }

    @Override
    public Integer deleteSubject(Integer id) {
        Integer delete = subjectDao.deleteById(id);
        return delete;
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String subjectName = params.getString("subjectName");
        String majorMinor = params.getString("majorMinor");
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(subjectName)){
            wrapper.eq("subject_Name",subjectName);
        }
        if (!StringUtils.isEmpty(majorMinor)){
            wrapper.eq("major_Minor",majorMinor);
        }
        List<Map> resultList;
        if (size>0 && current>0){
            Page<Subject> page = new Page<>(size,current);
            resultList = subjectDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = subjectDao.listPage(wrapper);
        }
        return resultList;
    }
}
