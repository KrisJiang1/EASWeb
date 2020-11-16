<template>
  <div>

    <el-form :model="clazz" ref="clazz" label-width="100px" class="demo-ruleForm">

      <div style="display: flex">
        <el-form-item label="班级工号" prop="clazzId">
          <el-input v-model="clazz.clazzId" clearable></el-input>
        </el-form-item>

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
      </div>

      <div style="display: flex">
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
      </div>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="selectClazzByCondition()">立即查询</el-button>
      </el-form-item>
    </el-form>


    <el-row :gutter="20">
      <el-col :span="2">
        <div class="grid-content bg-purple">
          <el-button type="success" icon="el-icon-search" @click="selectAllClazz()">查看全部
          </el-button>
        </div>
      </el-col>
      <el-col :span="2" :offset="1">
        <div class="grid-content bg-purple">
          <el-button type="warning" icon="el-icon-circle-plus-outline" @click="skipInsert()">添加班级
          </el-button>
        </div>
      </el-col>
    </el-row>
    <el-table
      :data="allClazzs"
      style="width: 100%">
      <el-table-column
        prop="clazzId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="clazzName"
        label="班级名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="gradeName"
        label="年级">
      </el-table-column>
      <el-table-column
        prop="clazzMajor.majorName"
        label="所属专业">
      </el-table-column>
      <el-table-column
        prop="clazzInstructor.staffName"
        label="辅导员姓名">
      </el-table-column>
      <el-table-column label="班级所有学生">
        <template slot-scope="scope">
          <el-button icon="el-icon-search" type="success" circle style="margin-left: 30px" @click="skipSelectStudentInClazz(scope.row.clazzId)"></el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="updateClazz(scope.row.clazzId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteClazz(scope.row.clazzId)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>

  </div>
</template>

<script>
export default {
  name: "ClazzHome",
  data() {
    return {
      clazz:{
        clazzId:"",
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
      //所有班级
      allClazzs:[],
      // 分页插件
      currentPage: 1,
      total:1,
      pageSize:0
    }
  },
  methods: {
    //跳转到添加页面
    skipInsert(){
      this.$router.push({
        name:"insertClazz"
      })
    },

    updateClazz(clazzId){
      this.$router.push(
        {
          name:"updateClazz",
          query:{
            i:clazzId
          }
        }
      )
    },
    deleteClazz(clazzId){
      this.$http.delete("api/eas/clazz/deleteClazz/"+clazzId).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.selectAllClazz();
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },
    selectClazzByCondition(){
      this.$http.post("api/eas/clazz/selectClazzByCondition",
        this.clazz
      ).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.allClazzs = body.data;
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },
    //查看所有班级
    selectAllClazz(){
      this.$http.get("api/eas/clazz/selectAllClazzPaging/"+this.currentPage).then(
        res=>{
          this.allClazzs = res.data.data.list;
          this.total = res.data.data.total;
          this.pageSize = res.data.data.pageSize;
        }
      )
    },
    //跳转到查询该班级所有学生
    skipSelectStudentInClazz(clazzId){
      this.$router.push({
        name:"selectClazzStudent",
        query:{
          i:clazzId
        }
      })
    },

    handleCurrentChange(val) {
      this.currentPage = val;
      this.selectAllClazz();
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
          this.selectAllClazz();
        })
      }
    )

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

</style>

