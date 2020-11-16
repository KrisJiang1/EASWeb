package com.jmy.controller.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope("prototype")
@RestController
@RequestMapping("dorBuil")
public class DormitoryBuildingController {

//    @Autowired
//    DormitoryBuildingService dormitoryBuildingService;
//
//    @GetMapping("selectAllDorBuilPaging/{pageNum}")
//    public PageInfo selectAllDorBuilPaging(@PathVariable String pageNum){
//
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<DormitoryBuilding> dormitoryBuildingList = dormitoryBuildingService.selectAllDormitoryBuilding();
//        PageInfo pageInfo = new PageInfo(dormitoryBuildingList, 5);
//        return pageInfo;
//    }
//
//    @GetMapping("selectAllDorBuil")
//    public List<DormitoryBuilding> selectAllDorBuil(){
//        List<DormitoryBuilding> list = dormitoryBuildingService.selectAllDormitoryBuilding();
//        return list;
//    }
//
//    @PostMapping("selectDorBuilByCondition")
//    public List selectDorBuilByCondition(@RequestBody DormitoryBuilding dormitoryBuilding){
//        List<DormitoryBuilding> dormitoryBuildingList = dormitoryBuildingService.selectDormitoryBuilding(dormitoryBuilding);
//        return dormitoryBuildingList;
//    }
}
