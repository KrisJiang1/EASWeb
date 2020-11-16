package com.jmy.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.sys.Admin;

public interface AdminService extends IService<Admin> {

    boolean ifExistAdminAccountNum(String AccountNum);

}
