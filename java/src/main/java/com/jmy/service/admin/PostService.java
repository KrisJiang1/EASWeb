package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Post;

import java.util.List;

public interface PostService extends IService<Post> {

    Post insertPost(Post post);

    Post updatePost(Post post);

    Integer deletePost(Integer id);

    List<Post> listPage(JSONObject params);
    
}
