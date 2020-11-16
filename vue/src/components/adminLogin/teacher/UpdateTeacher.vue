<template>
  <div class = "insertTeacher">
    <el-form :model="teacher" :rules="rules" ref="teacher" label-width="100px" class="demo-ruleForm">

      <el-form-item label="教师姓名" prop="teacherName">
        <el-input v-model="teacher.teacherName" clearable></el-input>
      </el-form-item>

      <el-form-item label="教师性别" prop="teacherSex">
        <el-radio-group v-model="teacher.teacherSex">
          <el-radio label="1">男</el-radio>
          <el-radio label="0">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="联系方式" prop="teacherPhone">
        <el-input v-model="teacher.teacherPhone" clearable></el-input>
      </el-form-item>

      <el-form-item label="身份证件" prop="teacherIdNum">
        <el-input v-model="teacher.teacherIdNum" clearable></el-input>
      </el-form-item>


      <el-form-item label="所属专业" prop="teacherMajor">
        <el-select v-model="teacher.teacherMajor.majorId" placeholder="请选择" @change="selectClazzByMajor()">
          <el-option
            v-for="item in formMsg.allMajors"
            :key="item.majorId"
            :label="item.majorName"
            :value="item.majorId">
          </el-option>
        </el-select>
      </el-form-item>


      <el-form-item label="所属职位" prop="teacherPost">
        <el-select v-model="teacher.teacherPost.postId" placeholder="请选择">
          <el-option
            v-for="item in formMsg.allPosts"
            :key="item.postId"
            :label="item.postName"
            :value="item.postId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="家庭住址" prop="teacherAddress">
        <el-input v-model="teacher.teacherAddress"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('teacher')">立即修改</el-button>
        <el-button @click="resetForm('teacher')">重置</el-button>
      </el-form-item>
    </el-form>


    <el-dialog title="提示" :visible.sync="msgDialogVisible" width="30%" center>
      <span>{{dialogContent}}</span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name:"UpdateTeacher",
  data() {
    return {
      //添加表单
      teacher: {
        teacherId:"",
        teacherName: "",
        teacherSex: "1",
        teacherPhone: "",
        teacherIdNum: "",
        teacherPost: {
          postId:""
        },
        teacherMajor: {
          majorId:""
        },
        teacherAddress: "",
      },
      //选择框初始化数组
      formMsg:{
        allMajors: [],
        allPosts:[
          {postId:10,postName:"教授"},
          {postId:11,postName:"副教授"},
          {postId:12,postName:"讲师"},
          {postId:13,postName:"助教"}
        ]
      },
      //初级验证规则
      rules: {
        teacherName: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 8, message: '长度在 2 到 10 ', trigger: 'blur' }
        ],
        teacherSex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        teacherPhone: [
          { required: true, message: '请输入手机号码', trigger: 'blur' },
          { min:11, max:11, message: '长度为11位', trigger: 'blur' }
        ],
        teacherIdNum: [
          { required: true, message: '请输入身份证号', trigger: 'blur' },
          { min:18, max:18, message: '长度为18位', trigger: 'blur' }
        ],
        teacherPost: [
          { required: true, message: '请选择职位', trigger: 'change' }
        ],
        teacherMajor: [
          {  required: true, message: '请选择专业', trigger: 'change' }
        ],
        teacherAddress: [
          { required: true, message: '请输入家庭地址', trigger: 'blur' },
        ]
      },
      //提示文本
      dialogContent:"",
      //信息提示框的开关
      msgDialogVisible:false,
    }
  },
  methods: {
    //提交表单
    submitForm(teacher) {
      this.$refs[teacher].validate((valid) => {
        if (valid) {
          this.updateTeacher();
        } else {
          alert('error submit!!');
          return false;
        }
      });
    },

    //重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //修改教师信息
    updateTeacher(){
      this.$http.put(
        "api/eas/teacher/updateTeacher",
        this.teacher
      ).then(
        res=>{
          console.log(res.data.data);
          if(res.data.status == 100){
            this.dialogContent = res.data.message;
            this.msgDialogVisible = true;
            setTimeout(()=>{
              this.msgDialogVisible = false;
            },3000);
          }
        }
      )
    }
  },
  created() {
    let teacherId = this.$route.query.i;
    //根据ID查询该教师信息
    this.$http.post("api/eas/teacher/selectTeacherByCondition",
      {teacherId:teacherId}
    ).then(
      res=>{
        this.teacher = res.data.data[0];
        this.teacher.teacherId = teacherId;
        console.log(this.teacher);
        //查询所有专业
        this.$http.get("api/eas/major/selectAllMajor").then(
          res=>{
            //将查询到的所有专业信息填充到选择框中
            this.formMsg.allMajors = res.data.data;
          }
        )
      }
    )
  }
}
</script>

<style scoped>
.insertTeacher{
  width: 40%;
}
</style>
