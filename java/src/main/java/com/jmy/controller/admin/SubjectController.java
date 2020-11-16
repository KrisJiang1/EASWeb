package com.jmy.controller.admin;

import com.jmy.commons.result.ResultVO;
import com.jmy.dto.MajorSubject;
import com.jmy.service.admin.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@RestController
@RequestMapping("subject")
public class SubjectController {


//    @Autowired
//    SubjectService subjectService;
//
//    @GetMapping("selectAllSubjectPaging/{pageNum}")
//    public PageInfo selectAllSubjectPaging(@PathVariable String pageNum){
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Subject> subjectList = subjectService.selectAllSubject();
//        PageInfo pageInfo = new PageInfo(subjectList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllSubject")
//    public List selectAllSubject(){
//        List<Subject> subjectList = subjectService.selectAllSubject();
//        return subjectList;
//    }
//
//    @PostMapping("selectSubjectByCondition")
//    public List selectSubjectByCondition(@RequestBody Subject subject){
//        List<Subject> subjectList = subjectService.selectSubject(subject);
//        return subjectList;
//    }
//
//    @PostMapping("insertSubject")
//    public MajorSubject insertSubject(@RequestBody MajorSubject majorSubject){
//        subjectService.insertSubject(majorSubject);
//        return majorSubject;
//    }
//
//    @PutMapping("updateSubject")
//    public Subject updateSubject(@RequestBody Subject subject){
//        subjectService.updateSubject(subject);
//        List<Subject> subjectList = subjectService.selectSubject(new Subject(subject.getSubjectId()));
//        return subjectList.get(0);
//    }
//
//    @DeleteMapping("deleteSubject/{subjectId}")
//    public ResultVO deleteSubject(@PathVariable Integer subjectId){
//        subjectService.deleteSubject(subjectId);
//        return new ResultVO("删除成功");
//    }
}
