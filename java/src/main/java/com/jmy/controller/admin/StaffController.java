package com.jmy.controller.admin;

import com.jmy.service.admin.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("staff")
public class StaffController {

//
//    @Autowired
//    Staff staff;
//
//    @Autowired
//    StaffService staffService;
//
//    @PostMapping("insertStaff")
//    public Staff insertStaff(@RequestBody Staff staff){
//        staffService.insertStaff(staff);
//        return staff;
//    }
//
//    @PostMapping("selectStaffByCondition")
//    public List selectStaffByCondition(@RequestBody Staff staff){
//        List<Staff> staffList = staffService.selectStaff(staff);
//        return staffList;
//    }
//
//    @GetMapping("selectAllStaffPaging/{pageNum}")
//    public PageInfo selectAllStaffPaging(@PathVariable String pageNum){
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Staff> staffList = staffService.selectAllStaff();
//        PageInfo pageInfo = new PageInfo(staffList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllStaff")
//    public List selectAllStaff(){
//        List<Staff> staffList = staffService.selectAllStaff();
//        return staffList;
//    }
//
//
//    @PutMapping("updateStaff")
//    public List updateStaff(Staff staff){
//        this.staff.setStaffId(staff.getStaffId());
//        staffService.updateStaff(staff);
//        List<Staff> staffList = staffService.selectStaff(this.staff);
//        return staffList;
//    }
}
