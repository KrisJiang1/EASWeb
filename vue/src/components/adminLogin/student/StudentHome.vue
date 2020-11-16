<template>
  <div>
    <el-form :model="student" ref="student" label-width="100px" class="demo-ruleForm">
      <div style="display: flex">
        <el-form-item label="学生工号" prop="studentId">
          <el-input v-model="student.studentId" clearable></el-input>
        </el-form-item>

        <el-form-item label="学生姓名" prop="studentName">
          <el-input v-model="student.studentName" clearable></el-input>
        </el-form-item>

        <el-form-item label="学生性别" prop="studentSex" style="width: 308px">
          <el-radio-group v-model="student.studentSex">
            <el-radio label="">全部</el-radio>
            <el-radio label="1">男</el-radio>
            <el-radio label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="联系方式" prop="studentPhone">
          <el-input v-model="student.studentPhone" clearable></el-input>
        </el-form-item>
      </div>

      <div style="display: flex">
        <el-form-item label="身份证件" prop="studentIdNum" style="width: 308px">
          <el-input v-model="student.studentIdNum" clearable></el-input>
        </el-form-item>

        <el-form-item label="所在班级" prop="studentClazz" style="width: 220px">
          <el-select v-model="student.studentClazz.clazzId" placeholder="请选择" clearable>
            <el-option
              v-for="item in formMsg.allClazzs"
              :key="item.clazzId"
              :label="item.clazzName"
              :value="item.clazzId">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="所学专业" prop="studentMajor" style="width: 300px">
          <el-select v-model="student.studentMajor.majorId" placeholder="请选择" clearable>
            <el-option
              v-for="item in formMsg.allMajors"
              :key="item.majorId"
              :label="item.majorName"
              :value="item.majorId">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="所在寝室" prop="studentDormitory" style="width: 300px">
          <div class="block">
            <el-cascader v-model="student.studentDormitory" :options="formMsg.allDormitories" clearable></el-cascader>
          </div>
        </el-form-item>
      </div>


      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="selectStudentByCondition()">立即查询</el-button>
      </el-form-item>
    </el-form>

    <el-row style="float: left">
      <el-button type="success" @click="selectAllStudents" icon="el-icon-search">查看全部</el-button>
      <el-button type="primary" @click="skipInsert" icon="el-icon-circle-plus-outline">添加学生</el-button>
    </el-row>

    <!-- 学生列表 -->
    <el-table
      v-loading="loading"
      :data="studentsList"
      style="width: 100%">
      <el-table-column type="expand">

        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand" style="display: flex">
            <div class="demo-image">
              <div class="block">
                <span class="demonstration"></span>
                <el-image
                  style="width: 150px; height: 200px"
                  src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
                  fit="fill"></el-image>
              </div>
            </div>
            <div style="padding-left: 150px">
              <el-form-item label="工号:">
                <span>{{ props.row.studentId }}</span>
              </el-form-item>
              <el-form-item label="姓名:">
                <span>{{ props.row.studentName }}</span>
              </el-form-item>
              <el-form-item label="性别:">
                <span>{{ props.row.studentSex | transformSex(props.row.studentSex) }}</span>
              </el-form-item>
              <el-form-item label="联系方式:">
                <span>{{ props.row.studentPhone }}</span>
              </el-form-item>
              <el-form-item label="身份证件:">
                <span>{{ props.row.studentIdNum }}</span>
              </el-form-item>
              <el-form-item label="班级:">
                <span>{{ props.row.studentClazz.clazzName}}</span>
              </el-form-item>
              <el-form-item label="专业:">
                <span>{{ props.row.studentMajor.majorName}}</span>
              </el-form-item>
              <el-form-item label="宿舍:">
                <span>{{ props.row.studentDormitory.dormitoryBuilding.dormiBuilName}}栋{{ props.row.studentDormitory.dormitoryName}}</span>
              </el-form-item>
              <el-form-item>
                <span><el-button type="info" round icon="el-icon-collection-tag" @click="skipStudentSubject(props.row.studentId)">查看课程</el-button></span>
              </el-form-item>
            </div>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="工号"
        prop="studentId">
      </el-table-column>
      <el-table-column
        label="姓名"
        prop="studentName">
      </el-table-column>
      <el-table-column
        label="专业"
        prop="studentMajor.majorName">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="skipUpdate(scope.row.studentId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteStudent(scope.row.studentId)"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog
      title="提示"
      :visible.sync="dialog.msgDialogVisible"
      width="30%"
      center>
      <span>{{dialog.msgContent}}</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialog.msgDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialog.msgDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

  </div>

</template>

<script>
export default {
  name: "StudentHome",
  data() {
    return {
      //所有学生列表
      studentsList: [],

      dialog:{
        //提示信息内容
        msgContent:"",
        //成功信息显示框
        msgDialogVisible: false
      },


      student: {
        //按条件查找
        studentId:"",
        studentName:"",
        studentSex:"",
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
      formMsg:{
        allDormitories: [],
        allMajors: [],
        allClazzs: []
      },
      loading:true
    }
  },
  methods: {
    //查询所有学生
    selectAllStudents(){
      this.$http.get("api/eas/student/selectAllStudents").then(
        res=>{
          console.log(res.data.data);
          this.studentsList = res.data.data;
        }
      )
    },
    //删除
    deleteStudent(studentId){
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.delete("api/eas/student/deleteStudent/"+studentId).then(
          res=>{
            if (res.data.status == "100"){
              this.$message({
                type: 'success',
                message: res.data.message
              })
              this.selectAllTeacher();
            }else if(res.data.status == "101"){
              this.$message({
                type: 'warn',
                message: res.data.message
              })
            }
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    //按条件查询
    selectStudentByCondition(){
      if(this.student.studentDormitory!=null){
        this.student.studentDormitory = {
          dormitoryId:this.student.studentDormitory[1],
          dormitoryBuilding: {
            dormiBuilId: this.student.studentDormitory[0]
          }
        }
      }
      this.$http.post(
        "api/eas/student/selectStudentByCondition",
        this.student
      ).then(
        res=>{
          console.log(res.data);
          if(res.data.status == '100'){
            this.studentsList = res.data.data;
          }else if(res.data.status == '101'){
            this.dialog.msgContent = res.data.message;
            this.dialog.msgDialogVisible = true;
            setTimeout(()=>{
              this.dialog.msgDialogVisible = true;
            },2000);
          }
        }
      )
    },
    skipUpdate(studentId){
      this.$router.push({
        name:'updateStudent',
        query:{
          i:studentId
        }
      })
    },
    skipInsert(){
      this.$router.push({
        name:'insertStudent'
      })
    },
    skipStudentSubject(studentId){
      this.$router.push({
        name:"selectStudentSubject",
        query:{
          i:studentId
        }
      })
    }
  },
  created() {
    //查询所有学生信息
    this.$http.get("api/eas/student/selectAllStudents").then(
      res=>{
        this.studentsList = res.data.data;
        this.loading = false;
        this.$http.get("api/eas/major/selectAllMajor").then(
          res=>{
            //将查询到的所有专业信息填充到选择框中
            this.formMsg.allMajors = res.data.data;
            //查询所有班级
            this.$http.get("api/eas/clazz/selectAllClazz").then(
              res=>{
                //将查询到的所有班级填充到选择框中
                this.formMsg.allClazzs = res.data.data;
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
                  })
              })
          })
      })
  },
  filters: {
    transformSex:arg=>{
      if(arg == 1){
        return '男'
      } else if (arg == 0){
        return '女'
      }


    }
  }


}
</script>

<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
.demo-image{
  padding-left: 30px;
  padding-top: 30px;
}

.el-row{
  margin-bottom: 20px;
}
</style>
