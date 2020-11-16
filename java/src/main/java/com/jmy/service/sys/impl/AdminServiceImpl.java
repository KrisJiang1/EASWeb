package com.jmy.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.sys.AdminDao;
import com.jmy.pojo.sys.Admin;
import com.jmy.service.sys.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {


    @Override
    public boolean ifExistAdminAccountNum(String AccountNum) {
        return false;
    }
}
