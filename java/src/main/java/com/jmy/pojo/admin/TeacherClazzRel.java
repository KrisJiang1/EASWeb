package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("EAS_TEACHER_CLAZZ_REL")
public class TeacherClazzRel {

  @TableId(type = IdType.ID_WORKER_STR)
  private String id;
  private String teacherId;
  private String clazzId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }


  public String getClazzId() {
    return clazzId;
  }

  public void setClazzId(String clazzId) {
    this.clazzId = clazzId;
  }

}
