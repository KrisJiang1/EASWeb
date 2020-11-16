<template>
  <div class = "insertClazz">
    <el-form :model="clazz" ref="clazz" label-width="100px" class="demo-ruleForm">

      <el-form-item label="班级名称" prop="clazzName">
        <el-input v-model="clazz.clazzName" clearable></el-input>
      </el-form-item>

      <el-form-item label="年级" prop="gradeName" style="width: 308px">
        <el-select v-model="clazz.gradeName" placeholder="请选择">
          <el-option
            v-for="item in allGrades"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="辅导员" prop="clazzInstructor" style="width: 325px">
        <el-select v-model="clazz.clazzInstructor.staffId" placeholder="请选择" clearable>
          <el-option
            v-for="item in allInstructors"
            :key="item.staffId"
            :label="item.staffName"
            :value="item.staffId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="所属专业" prop="clazzMajor" style="width: 325px">
        <el-select v-model="clazz.clazzMajor.majorId" placeholder="请选择" clearable>
          <el-option
            v-for="item in allMajors"
            :key="item.majorId"
            :label="item.majorName"
            :value="item.majorId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('clazz')">立即添加</el-button>
        <el-button @click="resetForm('clazz')">重置</el-button>
      </el-form-item>

    </el-form>


  </div>
</template>

<script>
export default {
  name: "InsertClazz",
  data(){
    return{
      clazz:{
        clazzName:"",
        gradeName:"",
        clazzMajor:{
          majorId:""
        },
        clazzInstructor:{
          staffId:""
        }
      },
      //所有专业
      allMajors:[],
      //所有辅导员
      allInstructors:[],
      allGrades:[1,2,3,4],
    }
  },
  methods:{
    submitForm(clazz) {
      this.$refs[clazz].validate((valid) => {
        if (valid) {
          this.insertClazz();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    insertClazz(){
      this.$http.post("api/eas/clazz/insertClazz",
        this.clazz).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.resetForm('clazz');
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    }
  },
  created() {
    this.$http.get("api/eas/major/selectAllMajor").then(
      res=> {
        //将查询到的所有专业信息填充到选择框中
        this.allMajors = res.data.data;
        //根据职位ID查询
        this.$http.post("api/eas/post/selectPostByCondition",
          {postId:9}
        ).then(res=>{
          this.allInstructors = res.data.data[0].staffList;
        })
      }
    )
  }

}
</script>

<style scoped>
.insertClazz{
  width: 40%;
}
</style>
