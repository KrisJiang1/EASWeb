<template>
  <div>
    <el-row style="display: flex">
      <el-col :span="5">
        <p ref="majorName" style="text-align: left"></p>
      </el-col>
      <el-col :span="8">
        <el-select v-model="subject.subjectId" clearable placeholder="请选择">
          <el-option
            v-for="subject in allSubjects"
            :key="subject.subjectId"
            :label="subject.subjectName"
            :value="subject.subjectId">
          </el-option>
        </el-select>
        <el-button type="success" @click="insertMajorSubject">添加课程</el-button>
      </el-col>

    </el-row>
    <el-table
      :data="subjectList"
      style="width: 100%">
      <el-table-column
        prop="subjectId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="subjectName"
        label="课程名称"
        width="280">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" @click="deleteMajorSub(scope.row.subjectId)">移除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "SelectSubjectByMajor",
  data(){
    return {
      //要添加的课程
      subject: {
        subjectId:""
      },
      //全部的课程
      allSubjects:[],

      //该专业的课程列表
      subjectList:[
      ]
    }

  },
  methods:{
    insertMajorSubject(){
      this.$http.post("api/eas/major/insertMajorSubject",
        {
          major:{
            majorId:this.$route.query.i
          },
          subject:this.subject
        }
      ).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.selectMajorSubject();
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },


    deleteMajorSub(subjectId){
      this.$http.delete("api/eas/major/deleteMajorSubject/"+this.$route.query.i+"/"+subjectId).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.selectMajorSubject();
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },

    selectMajorSubject() {
      let majorId = this.$route.query.i;
      this.$http.post("api/eas/major/selectMajorByCondition",
        {majorId:majorId}
      ).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$refs.majorName.innerHTML = "专业: "+body.data[0].majorName;
            this.subjectList = body.data[0].subjectList;
            this.$message.success(body.message);
          }else{
            this.$message.error(body.message);
            this.$router.push({
              name:"majorHome"
            })
          }
        }
      )
    }
  },
  created() {
    this.$http.get("api/eas/subject/selectAllSubject").then(
      res=>{
        this.allSubjects = res.data.data;
        this.selectMajorSubject();
      }
    )
  }
}
</script>

<style scoped>

</style>
