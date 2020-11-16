package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.DormitoryBuildingDao;
import com.jmy.pojo.admin.DormitoryBuilding;
import com.jmy.service.admin.DormitoryBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DormitoryBuildingServiceImpl extends ServiceImpl<DormitoryBuildingDao, DormitoryBuilding> implements DormitoryBuildingService {

    @Autowired
    DormitoryBuildingDao dormitoryBuildingDao;

    @Override
    public DormitoryBuilding insertDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
        dormitoryBuildingDao.insert(dormitoryBuilding);
        return dormitoryBuilding;
    }

    @Override
    public DormitoryBuilding updateDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
        dormitoryBuildingDao.updateById(dormitoryBuilding);
        return dormitoryBuilding;
    }

    @Override
    public Integer deleteDormitoryBuilding(Integer id) {
        Integer result = dormitoryBuildingDao.deleteById(id);
        return result;
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        Page<DormitoryBuilding> page = new Page(size,current);
        QueryWrapper wrapper = new QueryWrapper();
        List<Map> resultList;
        if (size>0&&current>0){
            resultList = dormitoryBuildingDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = dormitoryBuildingDao.listPage(wrapper);
        }
        return resultList;
    }
}
