package com.jmy.controller.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Scope("prototype")
@RestController
@RequestMapping("post")
public class PostController {

//    @Autowired
//    PostService postService;
//
//
//    @GetMapping("selectAllPostPaging/{pageNum}")
//    public PageInfo selectAllPostPaging(@PathVariable String pageNum){
//        PageHelper.startPage(Integer.parseInt(pageNum),5);
//        List<Post> postList = postService.selectAllPost();
//        PageInfo pageInfo = new PageInfo(postList,5);
//        return pageInfo;
//    }
//
//
//    @GetMapping("selectAllPost")
//    public List selectAllPost(){
//        List<Post> postList = postService.selectAllPost();
//        return postList;
//    }
//
//
//    @PostMapping("selectPostByCondition")
//    public List selectPostByCondition(@RequestBody Post post){
//        List<Post> postList = postService.selectPost(post);
//        return postList;
//    }
}
