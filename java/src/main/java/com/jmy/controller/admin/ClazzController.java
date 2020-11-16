package com.jmy.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.jmy.commons.result.ResultVO;
import com.jmy.pojo.admin.Clazz;
import com.jmy.service.admin.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Scope("prototype")
@RestController
@RequestMapping("clazz")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @PostMapping("insertClazz")
    public Clazz insertClazz(@RequestBody @Valid Clazz clazz){
        Clazz entry = clazzService.insertClazz(clazz);
        return entry;

    }


    @PutMapping("updateClazz")
    public Clazz updateClazz(@RequestBody @Valid Clazz clazz){
        Clazz entry = clazzService.updateClazz(clazz);
        return entry;
    }


    @DeleteMapping("deleteClazz/{clazzId}")
    public ResultVO updateClazz(@PathVariable Integer clazzId){
        clazzService.deleteClazz(clazzId);
        return new ResultVO("删除成功");
    }

    @PostMapping("selectAllClazzPaging")
    public List selectAllClazzPaging(@RequestBody JSONObject params){
        List<Clazz> clazzList = clazzService.listPage(params);
        return clazzList;
    }

}
