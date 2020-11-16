<template>
  <div class = "insertStudent">
    <el-form :model="staff" :rules="rules" ref="staff" label-width="100px" class="demo-ruleForm">

      <el-form-item label="姓名" prop="staffName">
        <el-input v-model="staff.staffName"></el-input>
      </el-form-item>

      <el-form-item label="性别" prop="staffSex">
        <el-radio-group v-model="staff.staffSex">
          <el-radio label="1">男</el-radio>
          <el-radio label="0">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="联系方式" prop="staffPhone">
        <el-input v-model="staff.staffPhone"></el-input>
      </el-form-item>

      <el-form-item label="身份证件" prop="staffIdNum">
        <el-input v-model="staff.staffIdNum"></el-input>
      </el-form-item>

      <el-form-item label="所属职位" prop="staffPost">
        <el-select v-model="staff.staffPost.postId" placeholder="请选择">
          <el-option
            v-for="item in formMsg.allPosts"
            :key="item.postId"
            :label="item.postName"
            :value="item.postId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="家庭住址" prop="staffAddress">
        <el-input v-model="staff.staffAddress"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('staff')">立即添加</el-button>
        <el-button @click="resetForm('staff')">重置</el-button>
      </el-form-item>
    </el-form>


    <el-dialog title="提示" :visible.sync="msgDialogVisible" width="30%" center>
      <span>{{dialogContent}}</span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name:"InsertStaff",
  data() {
    return {
      //添加表单
      staff: {
        staffName: "",
        staffSex: "1",
        staffPhone: "",
        staffIdNum: "",
        staffPost: {
          postId:""
        },
        staffAddress: "",
      },
      //选择框初始化数组
      formMsg:{
        allPosts:[]
      },
      //初级验证规则
      rules: {
        staffName: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 8, message: '长度在 2 到 10 ', trigger: 'blur' }
        ],
        staffSex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        staffPhone: [
          { required: true, message: '请输入手机号码', trigger: 'blur' },
          { min:11, max:11, message: '长度为11位', trigger: 'blur' }
        ],
        staffIdNum: [
          { required: true, message: '请输入身份证号', trigger: 'blur' },
          { min:18, max:18, message: '长度为18位', trigger: 'blur' }
        ],
        staffPost: [
          { required: true, message: '请选择职位', trigger: 'change' }
        ],
        staffAddress: [
          { required: true, message: '请输入家庭地址', trigger: 'blur' },
        ]
      },
      //提示文本
      dialogContent:"",
      //信息提示框的开关
      msgDialogVisible:false
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.insertStaff();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    insertStaff(){
      this.$http.post(
        "api/eas/staff/insertStaff",
        this.staff
      ).then(
        res=>{
          if(res.data.status == 100){
            this.dialogContent = res.data.message;
            this.msgDialogVisible = true;
            setTimeout(()=>{
              this.msgDialogVisible = false;
            },3000);
            this.resetForm('staff');
            this.staff.staffPost.postId = "";
          }
        }
      )
    }
  },
  created() {
    //查询所有专业
    this.$http.get("api/eas/post/selectAllPost").then(
      res=>{
        //将查询到的所有专业信息填充到选择框中
        this.formMsg.allPosts = res.data.data;
      }
    )
  }
}
</script>

<style scoped>
.insertStudent{
  width: 40%;
}
</style>
