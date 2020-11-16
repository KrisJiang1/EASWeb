package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.MajorDao;
import com.jmy.pojo.admin.Major;
import com.jmy.service.admin.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
@Transactional
public class MajorServiceImpl extends ServiceImpl<MajorDao, Major> implements MajorService {

    @Autowired
    MajorDao majorDao;


    public Major insertMajor(Major major){
        majorDao.insert(major);
        return major;
    }

    public Major updateMajor(Major major){
        majorDao.updateById(major);
        return major;
    }

    public Integer deleteMajor(Integer id){
        Integer delete = majorDao.deleteById(id);
        return delete;
    }

    public List<Map> listPage(JSONObject params){
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        QueryWrapper<Major> wrapper = new QueryWrapper();
        List<Map> resultList;
        if (size>0 && current>0){
            Page page = new Page(size,current);
            resultList = majorDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = majorDao.listPage(wrapper);
        }
        return resultList;
    }

}

