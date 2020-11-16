package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.DormitoryDao;
import com.jmy.pojo.admin.Dormitory;
import com.jmy.service.admin.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DormitoryServiceImpl extends ServiceImpl<DormitoryDao, Dormitory> implements DormitoryService {

    @Autowired
    DormitoryDao dormitoryDao;

    @Override
    public Dormitory insertDormitory(Dormitory dormitory){
        dormitoryDao.insert(dormitory);
        return dormitory;
    }

    @Override
    public Dormitory updateDormitory(Dormitory dormitory){
        dormitoryDao.updateById(dormitory);
        return dormitory;
    }

    @Override
    public Integer deleteDormitory(Integer id){
        Integer delete = dormitoryDao.deleteById(id);
        return delete;
    }


    @Override
    public List<Map> listPage(JSONObject params){
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        QueryWrapper<Dormitory> wrapper = new QueryWrapper<>();
        List<Map> resultList;
        if (size>0 && current>0){
            Page page = new Page(size,current);
            resultList = dormitoryDao.listPage(page, wrapper).getRecords();
        }else {
            resultList = dormitoryDao.listPage(wrapper);
        }
        return resultList;
    }
}
