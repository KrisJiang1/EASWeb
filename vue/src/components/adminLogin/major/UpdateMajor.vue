<template>

  <div class = "updateMajor">
    <el-form :model="major" ref="major" label-width="100px" class="demo-ruleForm">

      <el-form-item label="专业名称" prop="majorName">
        <el-input v-model="major.majorName"></el-input>
      </el-form-item>

      <el-form-item label="专业学制" prop="majorSchoolSystem">
        <el-input-number v-model="major.majorSchoolSystem" :min="1" :max="10" label="专业学制"></el-input-number>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('major')">立即修改</el-button>
        <el-button @click="resetForm('major')">重置</el-button>
      </el-form-item>

    </el-form>

  </div>

</template>

<script>
export default {
  name: "UpdateMajor",
  data(){
    return{
      major:{
        majorName:"",
        majorSchoolSystem:""
      },

    }
  },
  methods:{
    submitForm(major) {
      this.$refs[major].validate((valid) => {
        if (valid) {
          this.updateMajor();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    updateMajor(){
      this.$http.put("api/eas/major/updateMajor",
        this.major).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.major = body.data;
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    }
  },
  created() {
    let majorId = this.$route.query.i;
    //根据Id 对专业信息进行数据回显
    this.$http.post("api/eas/major/selectMajorByCondition",
      {majorId:majorId}).then(
      res=>{
        this.major.majorId = majorId;
        this.major = res.data.data[0];
      }
    )
  }
}
</script>

<style scoped>
  .updateMajor{
    width: 40%;
  }
</style>
