package com.jmy.controller.admin;

import com.jmy.commons.result.ResultVO;
import com.jmy.dto.StudentSubject;
import com.jmy.service.admin.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("student")
public class StudentController {

//    @Autowired
//    Student student;
//
//    @Autowired
//    Subject subject;
//
//    @Autowired
//    StudentSubject studentSubject;
//
//    @Autowired
//    StudentService studentService;
//
//    @GetMapping("selectAllStudentsPaging/{pageNum}")
//    public PageInfo selectAllStudentsPaging(@PathVariable String pageNum) {
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Student> studentList = studentService.selectAllStudent();
//        PageInfo pageInfo = new PageInfo(studentList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllStudents")
//    public List<Student> selectAllStudents() {
//        List<Student> studentList = studentService.selectAllStudent();
//        return studentList;
//    }
//
//    @PostMapping("insertStudent")
//    public Student insertStudent(@RequestBody @Valid Student student){
//        studentService.insertStudent(student);
//        return student;
//    }
//
//    @DeleteMapping("deleteStudent/{studentId}")
//    public ResultVO deleteStudent(@PathVariable Integer studentId){
//        student.setStudentId(studentId);
//        studentSubject.setStudent(student);
//        studentService.deleteStudent(studentId);
//        return new ResultVO("删除成功");
//    }
//
//    //删除学生选择的课程
//    @DeleteMapping("deleteStudentSubject/{studentId}/{subjectId}")
//    public ResultVO deleteStudentSubject(@PathVariable Integer studentId,@PathVariable Integer subjectId){
//        student.setStudentId(studentId);
//        subject.setSubjectId(subjectId);
//        studentSubject.setStudent(student);
//        studentSubject.setSubject(subject);
//        studentService.deleteStudentSubject(studentSubject);
//        return new ResultVO("删除成功");
//    }
//
//    @PutMapping("updateStudent")
//    public Student updateStudent(@RequestBody Student student){
//        studentService.updateStudent(student);
//        //查询修改后的student
//        this.student.setStudentId(student.getStudentId());
//        List<Student> list = studentService.selectStudent(student);
//        return list.get(0);
//    }
//
//    //按条件查询
//    @PostMapping("selectStudentByCondition")
//    public List<Student> selectStudentByCondition(@RequestBody Student student){
//        List<Student> list = studentService.selectStudent(student);
//        return list;
//    }
}
