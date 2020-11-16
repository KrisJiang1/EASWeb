package com.jmy.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jmy.pojo.admin.Score;

import java.util.List;
import java.util.Map;

public interface ScoreService extends IService<Score> {

    Score insertScore(Score score);

    Score updateScore(Score score);

    Integer deleteScore(Integer id);

    List<Map> listPage(JSONObject params);
}
