package com.jmy.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmy.pojo.sys.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Mapper
@Repository
public interface SysMenuDao extends BaseMapper<SysMenu>{


}
