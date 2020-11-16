package com.jmy.controller.admin;

import com.jmy.service.admin.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("dormitory")
public class DormitoryController {

    @Autowired
    DormitoryService dormitoryService;
//
//    @PostMapping("selectDormitoryByCondition")
//    public List selectDormitoryByCondition(@RequestBody Dormitory dormitory){
//        List<Dormitory> dormitoryList = dormitoryService.selectDormitory(dormitory);
//        return dormitoryList;
//    }
}
