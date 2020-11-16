package com.jmy.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmy.dao.admin.ScoreDao;
import com.jmy.pojo.admin.Score;
import com.jmy.service.admin.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, Score> implements ScoreService {

    @Autowired
    ScoreDao scoreDao;

    @Override
    public Score insertScore(Score score) {
        scoreDao.insert(score);
        return score;
    }

    @Override
    public Score updateScore(Score score) {
        scoreDao.updateById(score);
        return score;
    }

    @Override
    public Integer deleteScore(Integer id) {
        Integer delete = scoreDao.deleteById(id);
        return delete;
    }

    @Override
    public List<Map> listPage(JSONObject params) {
        Integer size = params.getInteger("size");
        Integer current = params.getInteger("current");
        String studentId = params.getString("studentId");
        String subjectId = params.getString("subjectId");
        String subjectScore = params.getString("subjectScore");
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(studentId)){
            wrapper.eq("student_Id",studentId);
        }
        if (!StringUtils.isEmpty(subjectId)){
            wrapper.eq("subject_Id",subjectId);
        }
        if (!StringUtils.isEmpty(subjectScore)){
            wrapper.eq("subject_Score",subjectScore);
        }
        List<Map> resultList;
        if (size>0 && current>0){
            Page<Score> page = new Page(size,current);
            resultList = scoreDao.listPage(page,wrapper).getRecords();
        }else{
            resultList = scoreDao.listPage(wrapper);
        }
        return resultList;
    }
}
