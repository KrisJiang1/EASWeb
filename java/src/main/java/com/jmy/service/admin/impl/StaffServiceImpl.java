package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.StaffDao;
import com.jmy.pojo.admin.Staff;
import com.jmy.service.admin.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StaffServiceImpl extends ServiceImpl<StaffDao, Staff> implements StaffService {

    @Autowired
    StaffDao staffDao;

    @Override
    public Staff insertStaff(Staff staff) {
        staffDao.insert(staff);
        return staff;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        staffDao.updateById(staff);
        return staff;
    }

    @Override
    public Integer deleteStaff(Integer id) {
        Integer delete = staffDao.deleteById(id);
        return delete;
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String staffName = params.getString("staffName");
        String staffSex = params.getString("staffSex");
        String staffPhone = params.getString("staffPhone");
        String staffIdNum = params.getString("staffIdNum");
        String postId = params.getString("postId");
        String staffAddress = params.getString("staffAddress");
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty("staffName")){
            wrapper.eq("staff_Name",staffName);
        }
        if (!StringUtils.isEmpty("staffSex")){
            wrapper.eq("staff_Sex",staffSex);
        }
        if (!StringUtils.isEmpty("staffPhone")){
            wrapper.eq("staff_Phone",staffPhone);
        }
        if (!StringUtils.isEmpty("staffIdNum")){
            wrapper.eq("staff_IdNum",staffIdNum);
        }
        if (!StringUtils.isEmpty("postId")){
            wrapper.eq("post_Id",postId);
        }
        if (!StringUtils.isEmpty("staffAddress")){
            wrapper.eq("staff_Address",staffAddress);
        }
        List<Map> resultList;
        if (size>0&&current>0){
            Page page = new Page(size,current);
            resultList = staffDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = staffDao.listPage(wrapper);
        }
        return resultList;
    }
}
