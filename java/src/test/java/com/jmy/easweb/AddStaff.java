package com.jmy.easweb;

import com.alibaba.fastjson.JSONObject;
import com.jmy.EaswebApplication;
import com.jmy.dao.admin.StaffDao;
import com.jmy.pojo.admin.Clazz;
import com.jmy.service.sys.AdminService;
import com.jmy.service.admin.ClazzService;
import com.jmy.service.admin.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EaswebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddStaff {


    @Autowired
    ClazzService clazzService;

    @Test
    public void demo(){
        JSONObject params = new JSONObject();
        params.put("current",0);
        params.put("size",0);
        Clazz clazz = new Clazz();
        clazz.setClazzName("一班");
        clazz.setGradeName("1");
        clazz.setInstructorId("1");
        clazz.setMajorId("1");
        Clazz clazz1 = clazzService.insertClazz(clazz);

//        List list = clazzService.listPage(params);
//        for (Object o : list) {
//            System.out.println(o);
//        }
//        clazzService.insertClazz(clazz);
    }
}
