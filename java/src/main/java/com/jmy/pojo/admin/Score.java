package com.jmy.pojo.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;


@Component
@TableName("EAS_SCORE")
public class Score {

    @TableId(type = IdType.ID_WORKER_STR)
  private String scoreId;
  private String studentId;
  private String subjectId;
  private String subjectScore;


  public String getScoreId() {
    return scoreId;
  }

  public void setScoreId(String scoreId) {
    this.scoreId = scoreId;
  }


  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }


  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }


  public String getSubjectScore() {
    return subjectScore;
  }

  public void setSubjectScore(String subjectScore) {
    this.subjectScore = subjectScore;
  }

}
