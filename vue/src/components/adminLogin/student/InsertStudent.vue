<template>
  <div class = "insertStudent">
    <el-form :model="student" :rules="rules" ref="student" label-width="100px" class="demo-ruleForm">

      <el-form-item label="学生姓名" prop="studentName">
        <el-input v-model="student.studentName"></el-input>
      </el-form-item>

      <el-form-item label="学生性别" prop="studentSex">
        <el-radio-group v-model="student.studentSex">
          <el-radio label="1">男</el-radio>
          <el-radio label="0">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="联系方式" prop="studentPhone">
        <el-input v-model="student.studentPhone"></el-input>
      </el-form-item>

      <el-form-item label="身份证件" prop="studentIdNum">
        <el-input v-model="student.studentIdNum"></el-input>
      </el-form-item>

      <el-form-item label="所学专业" prop="studentMajor">
        <el-select v-model="student.studentMajor.majorId" placeholder="请选择" @change="selectClazzByMajor()">
          <el-option
            v-for="item in formMsg.allMajors"
            :key="item.majorId"
            :label="item.majorName"
            :value="item.majorId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="所在班级" prop="studentClazz">
        <el-select v-model="student.studentClazz.clazzId" placeholder="请先选择专业">
          <el-option
            v-for="item in formMsg.allClazzs"
            :key="item.clazzId"
            :label="item.clazzName"
            :value="item.clazzId">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="所在寝室" prop="studentDormitory">
        <div class="block">
          <el-cascader v-model="student.studentDormitory" :options="formMsg.allDormitories"></el-cascader>
        </div>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('student')">立即添加</el-button>
        <el-button @click="resetForm('student')">重置</el-button>
      </el-form-item>
    </el-form>


    <el-dialog title="提示" :visible.sync="msgDialogVisible" width="30%" center>
      <span>{{dialogContent}}</span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name:"InsertStudent",
  data() {
    return {
      //添加表单
      student: {
        //添加时需要的字段
        studentName:"",
        studentSex:"1",
        studentPhone:"",
        studentIdNum:"",
        studentClazz:{
          clazzId:""
        },
        studentMajor:{
          majorId:""
        },
        studentDormitory:null,
      },
      //选择框初始化数组
      formMsg:{
        allDormitories: [],
        allMajors: [],
        allClazzs: []
      },
      //初级验证规则
      rules: {
        // studentName: [
        //   { required: true, message: '请输入姓名', trigger: 'blur' },
        //   { min: 2, max: 8, message: '长度在 2 到 10 ', trigger: 'blur' }
        // ],
        // studentSex: [
        //   { required: true, message: '请选择性别', trigger: 'change' }
        // ],
        // studentPhone: [
        //   { required: true, message: '请输入手机号码', trigger: 'blur' },
        //   { min:11, max:11, message: '长度为11位', trigger: 'blur' }
        // ],
        // studentIdNum: [
        //   { required: true, message: '请输入身份证号', trigger: 'blur' },
        //   { min:18, max:18, message: '长度为18位', trigger: 'blur' }
        // ],
        // studentClazz: [
        //   { required: true, message: '请选择班级', trigger: 'change' }
        // ],
        // studentMajor: [
        //   {  required: true, message: '请选择专业', trigger: 'change' }
        // ],
        // studentDormitory: [
        //   { required: true, message: '请选择寝室', trigger: 'change' }
        // ]
      },
      //提示文本
      dialogContent:"",
      //信息提示框的开关
      msgDialogVisible:false
    }
  },
  methods: {
    submitForm(student) {
      this.$refs[student].validate((valid) => {
        if (valid) {
          this.insertStudent();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    insertStudent(){
      if(this.student.studentDormitory!=null){
        this.student.studentDormitory = {
          dormitoryId:this.student.studentDormitory[1],
          dormitoryBuilding: {
            dormiBuilId: this.student.studentDormitory[0]
          }
        }
      }
      this.$http.post(
        "api/eas/student/insertStudent",
          this.student
      ).then(
        res=>{
          if(res.data.status == 100){
            this.dialogContent = res.data.message;
            this.msgDialogVisible = true;
            setTimeout(()=>{
              this.msgDialogVisible = false;
            },3000);
            this.resetForm('student');
          }
        }
      )
    },
    selectClazzByMajor(){
      this.$http.post(
        "api/eas/major/selectStudentByCondition",
        {majorId:this.student.studentMajor.majorId}
      ).then(
        res=>{
          this.formMsg.allClazzs = res.data.data[0].clazzList;
          this.student.studentClazz.clazzId = res.data.data[0].clazzList[0].clazzId;
        }
      )
    }
  },
  created() {
      //查询所有专业
      this.$http.get("api/eas/major/selectAllMajor").then(
        res=>{
          //将查询到的所有专业信息填充到选择框中
          this.formMsg.allMajors = res.data.data;
          //查询所有寝室
          this.$http.get("api/eas/dorBuil/selectAllDorBuil").then(
            res=>{
              //将查询到的所有寝室填充到选择框中
              let buildArr = res.data.data;
              let buildingArr = new Array();
              for(let i =0;i<buildArr.length;i++){
                buildingArr[i] = {
                  "value":buildArr[i].dormiBuilId,
                  "label":buildArr[i].dormiBuilName+"栋",
                  "children":buildArr[i].dormitoryList
                };
                for(let j=0;j<buildArr[i].dormitoryList.length;j++){
                  buildingArr[i].children[j]= {
                    "value":buildArr[i].dormitoryList[j].dormitoryId,
                    "label":buildArr[i].dormitoryList[j].dormitoryName
                  }
                }
              }
              this.formMsg.allDormitories = buildingArr;
            }
          )
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
