package com.jmy.controller.admin;

import com.jmy.commons.result.ResultVO;
import com.jmy.service.admin.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

//    @GetMapping("selectAllTeacherPaging/{pageNum}")
//    public PageInfo selectAllTeacherPaging(@PathVariable String pageNum) {
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Teacher> teacherList = teacherService.selectAllTeacher();
//        PageInfo pageInfo = new PageInfo(teacherList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllTeacher")
//    public List selectAllTeacher() {
//        List<Teacher> teacherList = teacherService.selectAllTeacher();
//        return teacherList;
//    }
//
//    @PostMapping("insertTeacher")
//    public Teacher insertStudent(@RequestBody Teacher teacher){
//        teacherService.insertTeacher(teacher);
//        return teacher;
//    }
//
//    @PostMapping("selectTeacherByCondition")
//    public List selectTeacherByCondition(@RequestBody Teacher teacher){
//        List<Teacher> teacherList = teacherService.selectTeacher(teacher);
//        return teacherList;
//    }
//
//    @PutMapping("updateTeacher")
//    public Teacher updateTeacher(@RequestBody Teacher teacher){
//        teacherService.updateTeacher(teacher);
//        List<Teacher> teachersList = teacherService.selectTeacher(new Teacher(teacher.getTeacherId()));
//        return teachersList.get(0);
//    }
//
//    @DeleteMapping("deleteTeacher/{teacherId}")
//    public ResultVO deleteTeacher(@PathVariable Integer teacherId){
//        teacherService.deleteTeacher(teacherId);
//        return new ResultVO("删除成功");
//    }
}
