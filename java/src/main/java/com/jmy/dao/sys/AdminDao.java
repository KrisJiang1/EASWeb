package com.jmy.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmy.pojo.sys.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao extends BaseMapper<Admin> {


}
