<template>
  <div>
    <el-row style="float: left;display: flex">
      <el-button type="success" @click="selectAllStudents" icon="el-icon-search">查看全部</el-button>
      <el-button type="primary" @click="insert" icon="el-icon-circle-plus-outline">添加学生</el-button>
    </el-row>

    <el-row>{{this.dormitory.dormitoryBuilding.dormiBuilName}}栋{{this.dormitory.dormitoryName}}</el-row>


    <!-- 学生列表 -->
    <el-table
      v-loading="loading"
      :data="dormitory.studentList"
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
                <span><el-button type="info" round icon="el-icon-collection-tag">查看课程</el-button></span>
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
          <el-button type="primary" icon="el-icon-edit" circle @click="updateStudent(scope.row.studentId)"></el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>

</template>

<script>
export default {
  name: "SelectStudentsInDor",
  data() {
    return {
      //所有学生列表
      dormitory:{
        studentList: [],
        dormitoryBuilding:{
          dormiBuilName:""
        }
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
    updateStudent(studentId){
      this.$router.push({
        name:'updateStudent',
        query:{
          i:studentId
        }
      })
    },
    insert(){
      this.$router.push({
        name:'insertStudent'
      })
    }

  },
  created() {
    let dormitoryId = this.$route.query.i;
    //查询所有学生信息
    this.$http.post("api/eas/dormitory/selectDormitoryByCondition",
      {dormitoryId:dormitoryId}
    ).then(
      res=>{
        this.dormitory = res.data.data[0];
        console.log(this.dormitory);
        this.loading = false;
      }
    )
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
