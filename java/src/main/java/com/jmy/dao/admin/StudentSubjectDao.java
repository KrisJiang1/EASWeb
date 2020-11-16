package com.jmy.dao.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jmy.dto.StudentSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface StudentSubjectDao extends BaseMapper<StudentSubject>{

    List<Map> listPage(@Param(Constants.WRAPPER) Wrapper<StudentSubject> wrapper);

    Page<Map> listPage(Page<StudentSubject> page, @Param(Constants.WRAPPER)Wrapper<StudentSubject> wrapper);
}
