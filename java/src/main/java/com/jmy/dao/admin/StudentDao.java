package com.jmy.dao.admin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jmy.pojo.admin.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentDao extends BaseMapper<Student> {

    List<Map> listPage(@Param(Constants.WRAPPER) Wrapper<Student> wrapper);

    Page<Map> listPage(Page<Student> page, @Param(Constants.WRAPPER)Wrapper<Student> wrapper);
}
