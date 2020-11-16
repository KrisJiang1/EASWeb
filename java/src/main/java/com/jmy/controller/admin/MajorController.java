package com.jmy.controller.admin;

import com.jmy.dto.MajorSubject;
import com.jmy.service.admin.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;


@Scope("prototype")
@RestController
@RequestMapping("major")
public class MajorController {


    @Autowired
    MajorSubject majorSubject;

    @Autowired
    MajorService majorService;

//
//    @PostMapping("insertMajor")
//    public Major insertMajor(@RequestBody Major major){
//        majorService.insertMajor(major);
//        return major;
//    }
//
//    @PutMapping("updateMajor")
//    public ResultVO updateMajor(@RequestBody Major major){
//        majorService.updateMajor(major);
//        return new ResultVO("修改成功");
//    }
//
//    //未测试
//    @DeleteMapping("deleteMajor/{majorId}")
//    public ResultVO deleteMajor(@PathVariable Integer majorId){
//        majorService.deleteMajor(majorId);
//        return new ResultVO("删除成功");
//    }
//
//
//    @DeleteMapping("deleteMajorSubject/{majorId}/{subjectId}")
//    public ResultVO deleteMajorSubject(@PathVariable Integer majorId,@PathVariable Integer subjectId){
//        majorSubject.setMajor(new Major(majorId));
//        majorSubject.setSubject(new Subject(subjectId));
//        majorService.deleteMajorSubject(majorSubject);
//        return new ResultVO("移除成功");
//    }
//
//    @PostMapping("insertMajorSubject")
//    public MajorSubject insertMajorSubject(@RequestBody MajorSubject majorSubject){
//        majorService.insertMajorSubject(majorSubject);
//        return majorSubject;
//    }
//
//    @GetMapping("selectAllMajorPaging/{pageNum}")
//    public PageInfo selectAllMajorPaging(@PathVariable String pageNum) {
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Major> majorList = majorService.selectAllMajor();
//        PageInfo pageInfo = new PageInfo(majorList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllMajor")
//    public List selectAllMajor() {
//        List<Major> majorList = majorService.selectAllMajor();
//        return majorList;
//    }
//
//    @PostMapping("selectMajorByCondition")
//    public List selectMajorByCondition(@RequestBody Major major){
//        List<Major> majorList = majorService.selectMajor(major);
//        return majorList;
//    }

}
