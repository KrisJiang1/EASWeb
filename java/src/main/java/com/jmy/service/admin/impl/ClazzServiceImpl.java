package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.ClazzDao;
import com.jmy.pojo.admin.Clazz;
import com.jmy.service.admin.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzDao,Clazz> implements ClazzService {

    @Autowired
    ClazzDao clazzDao;

    @Override
    public Clazz insertClazz(Clazz clazz) {
        clazzDao.insert(clazz);
        return clazz;
    }

    @Override
    public Clazz updateClazz(Clazz clazz) {
        clazzDao.updateById(clazz);
        return clazz;
    }

    @Override
    public Integer deleteClazz(Integer clazzId) {
        Integer result = clazzDao.deleteById(clazzId);
        return result;
    }


    @Override
    public List<Map> listPage(JSONObject params) {
        Integer current = params.getInteger("current");
        Integer size = params.getInteger("size");
        String clazzId = params.getString("clazzId");
        String clazzName = params.getString("clazzName");
        String gradeName = params.getString("gradeName");
        String majorId = params.getString("majorId");
        String instructorId = params.getString("instructorId");
        QueryWrapper<Clazz> wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(clazzId)){
            wrapper.eq("clazz_id",clazzId);
        }
        if (!StringUtils.isEmpty(clazzName)){
            wrapper.eq("clazz_name",clazzName);
        }
        if (!StringUtils.isEmpty(gradeName)){
            wrapper.eq("grade_name",gradeName);
        }
        if (!StringUtils.isEmpty(majorId)){
            wrapper.eq("major_id",majorId);
        }
        if (!StringUtils.isEmpty(instructorId)){
            wrapper.eq("instructor_id",instructorId);
        }
        Page<Clazz> page = new Page(current,size);
        List<Map> resultList;
        if (size>0 && current>0){
            resultList = clazzDao.listPage(page, wrapper).getRecords();
        }else{
            resultList = clazzDao.listPage(wrapper);
        }
        return resultList;
    }
}
