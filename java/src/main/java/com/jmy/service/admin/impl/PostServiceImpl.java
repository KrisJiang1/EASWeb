package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.PostDao;
import com.jmy.pojo.admin.Post;
import com.jmy.service.admin.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl extends ServiceImpl<PostDao, Post> implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public Post insertPost(Post post) {
        postDao.insert(post);
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public Integer deletePost(Integer id) {
        return null;
    }

    @Override
    public List<Post> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String postName = params.getString("postName");
        QueryWrapper<Post> wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(postName)){
            wrapper.eq("post_name",postName);
        }
        List<Post> resultList;
        if (size>0&&current>0){
            Page page = new Page(size,current);
            resultList = postDao.selectPage(page,wrapper).getRecords();
        }else{
            resultList = postDao.selectList(wrapper);
        }
        return resultList;
    }
}
