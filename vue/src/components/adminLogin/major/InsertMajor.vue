<template>
  <div class = "insertMajor">
    <el-form :model="major" ref="major" label-width="100px" class="demo-ruleForm">

      <el-form-item label="专业名称" prop="majorName">
        <el-input v-model="major.majorName"></el-input>
      </el-form-item>

      <el-form-item label="专业学制" prop="majorSchoolSystem">
        <el-input-number v-model="major.majorSchoolSystem" :min="1" :max="10" label="专业学制"></el-input-number>
      </el-form-item>

      <el-form-item label="选择课程" prop="MajorSubjectList">
        <el-checkbox-group
          v-model="major.subjectList">
          <el-checkbox v-for="subject in allSubjects" :label="subject" :key="subject.subjectId">{{subject.subjectName}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('major')">立即添加</el-button>
        <el-button @click="resetForm('major')">重置</el-button>
      </el-form-item>

    </el-form>


  </div>
</template>

<script>
export default {
  name: "InsertMajor",
  data(){
    return{
      major:{
        majorName:"",
        majorSchoolSystem:"",
        subjectList:[
        ]
      },
      allSubjects:[]
    }
  },
  methods:{
    submitForm(major) {
      this.$refs[major].validate((valid) => {
        if (valid) {
          this.insertMajor();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.major.subjectList = [];
    },
    insertMajor(){
      this.$http.post("api/eas/major/insertMajor",
        this.major).then(
          res=>{
            let body = res.data;
            if(body.status == '100'){
              this.$message.success(body.message);
              this.resetForm('major');
            }else if(body.status == '101'){
              this.$message.error(body.message);
            }
      })
    }
  },
  created() {
    this.$http.get("api/eas/subject/selectAllSubject").then(
      res=>{
       this.allSubjects = res.data.data;
      }
    )
  }

}
</script>

<style scoped>
  .insertMajor{
    width: 40%;
  }
</style>
