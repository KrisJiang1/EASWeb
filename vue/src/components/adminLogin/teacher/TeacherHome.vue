<template>
  <div>
    <!-- 查询 -->
    <el-form :model="teacherForm" ref="teacherForm" label-width="100px" class="demo-ruleForm">

      <div style="display: flex">
        <el-form-item label="教师工号" prop="teacherId">
          <el-input v-model="teacherForm.teacherId" clearable></el-input>
        </el-form-item>

        <el-form-item label="教师姓名" prop="teacherName">
          <el-input v-model="teacherForm.teacherName" clearable></el-input>
        </el-form-item>

        <el-form-item label="教师性别" prop="teacherSex" style="width: 320px">
          <el-radio-group v-model="teacherForm.teacherSex">
            <el-radio label="">全部</el-radio>
            <el-radio label="1">男</el-radio>
            <el-radio label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="联系方式" prop="teacherPhone">
          <el-input v-model="teacherForm.teacherPhone" clearable></el-input>
        </el-form-item>
      </div>

      <div style="display: flex">
        <el-form-item label="身份证件" prop="teacherIdNum">
          <el-input v-model="teacherForm.teacherIdNum" clearable></el-input>
        </el-form-item>

        <el-form-item label="家庭住址" prop="teacherAddress">
          <el-input v-model="teacherForm.teacherAddress" clearable></el-input>
        </el-form-item>

        <el-form-item label="教师职务" prop="teacherPost">
          <el-select v-model="teacherForm.teacherPost.postId" placeholder="请选择" clearable>
            <el-option
              v-for="item in formMsg.allPosts"
              :key="item.postId"
              :label="item.postName"
              :value="item.postId">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="所学专业" prop="teacherMajor">
          <el-select v-model="teacherForm.teacherMajor.majorId" placeholder="请选择" clearable>
            <el-option
              v-for="item in formMsg.allMajors"
              :key="item.majorId"
              :label="item.majorName"
              :value="item.majorId">
            </el-option>
          </el-select>
        </el-form-item>
      </div>
      <el-button type="primary" icon="el-icon-search" @click="selectTeacherByCondition()">立即查询</el-button>
    </el-form>

    <el-row style="float: left">
      <el-button type="success" icon="el-icon-search" @click="selectAllTeacher">查看所有</el-button>
      <router-link to="/teacherManage/insertTeacher"><el-button type="primary" icon="el-icon-circle-plus-outline">添加教师</el-button></router-link>
    </el-row>
    <!-- 所有教师列表 -->
    <el-table
      :data="allTeachers"
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
                <span>{{ props.row.teacherId }}</span>
              </el-form-item>
              <el-form-item label="姓名:">
                <span>{{ props.row.teacherName }}</span>
              </el-form-item>
              <el-form-item label="性别:">
                <span>{{ props.row.teacherSex }}</span>
              </el-form-item>
              <el-form-item label="联系方式:">
                <span>{{ props.row.teacherPhone }}</span>
              </el-form-item>
              <el-form-item label="身份证件:">
                <span>{{ props.row.teacherIdNum }}</span>
              </el-form-item>
              <el-form-item label="职务:">
                <span>{{ props.row.teacherPost.postName }}</span>
              </el-form-item>
              <el-form-item label="专业:">
                <span>{{ props.row.teacherMajor.majorName }}</span>
              </el-form-item>
              <el-form-item label="地址:">
                <span>{{ props.row.teacherAddress }}</span>
              </el-form-item>
              <el-form-item label="所教班级:">
                <span v-for="clazz in props.row.teaTeaClazzList">
                  {{ clazz.clazzName}}
                </span>
              </el-form-item>
            </div>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="工号"
        prop="teacherId">
      </el-table-column>
      <el-table-column
        label="姓名"
        prop="teacherName">
      </el-table-column>
      <el-table-column
        label="职务"
        prop="teacherPost.postName">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="updateTeacher(scope.row.teacherId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteTeacher(scope.row.teacherId)"></el-button>
        </template>
      </el-table-column>
    </el-table> 
  </div>
</template>

<script>
export default {
  name: "TeacherHome",
  data() {
    return {
      //所有教师列表
      allTeachers: [],

      dialog:{
        //提示信息内容
        msgContent:"",
        //成功信息显示框
        msgDialogVisible: false
      },

      teacherForm: {
        //查询条件
        teacherId:"",
        teacherName:"",
        teacherSex:"",
        teacherPhone:"",
        teacherIdNum:"",
        teacherAddress:"",
        teacherPost: {
          postId:""
        },
        teacherMajor:{
          majorId:""
        },
      },
      formMsg:{
        allMajors: [],
        allPosts: [
          {postId:10,postName:"教授"},
          {postId:11,postName:"副教授"},
          {postId:12,postName:"讲师"},
          {postId:13,postName:"助教"}
        ]
      }
    }
  },
  methods: {
    selectAllTeacher(){
      this.$http.get("api/eas/teacher/selectAllTeacher").then(
        res => {
          res.data.data.forEach(function (e) {
            if (e.teacherSex == 1) {
              e.teacherSex = "男"
            } else {
              e.teacherSex = "女"
            }
          });
          this.allTeachers = res.data.data;
        }
      )
    },

    //按条件查询
    selectTeacherByCondition(){
      console.log(this.teacherForm);
      this.$http.post("api/eas/teacher/selectTeacherByCondition",
        this.teacherForm
      ).then(
        res=>{
          this.allTeachers = res.data.data;
        }
      )
    },
    //修改教师信息
    updateTeacher(teacherId){
      this.$router.push({
        name:'updateTeacher',
        query:{
          i:teacherId
        }
      })
    },
    //删除教师信息
    deleteTeacher(teacherId) {
      this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.delete("api/eas/teacher/deleteTeacher/"+teacherId).then(
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
    }
  },
  created() {
    this.$http.get("api/eas/major/selectAllMajor").then(
      res => {
        this.formMsg.allMajors = res.data.data;
        this.selectAllTeacher();
      }
    );
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
  width: 100%;
}
.demo-image{
  padding-left: 30px;
  padding-top: 30px;
}

.el-form-item__content{
  padding:0;
}
</style>

