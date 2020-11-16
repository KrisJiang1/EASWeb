<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="10">
        <div class="grid-content bg-purple" style="display: flex">
          <el-input placeholder="请输入内容" v-model="insert.majorSubject.subject.subjectName" clearable></el-input>
          <el-select v-model="insert.majorSubject.subject.subjectMajorOrMinor" placeholder="请选择">
            <el-option
              v-for="item in subjectMajorOrMinorList"
              :key="item.value"
              :label="item.name"
              :value="item.value">
            </el-option>
          </el-select>
          <el-select v-model="insert.majorSubject.major.majorId" placeholder="请选择">
            <el-option
              v-for="item in allMajors"
              :key="item.majorId"
              :label="item.majorName"
              :value="item.majorId">
            </el-option>
          </el-select>
          <el-button type="danger" icon="el-icon-circle-plus-outline" @click="insertSubject()">添加课程</el-button>
        </div>
      </el-col>
      <el-col :span="5" :offset="12"><div class="grid-content bg-purple">
        <el-row>
          <el-col :span="24">

          </el-col>
        </el-row>
      </div>
      </el-col>
    </el-row>

    <!--修改课程信息弹出框-->
    <el-dialog
      title="修改课程"
      :visible.sync="centerDialogVisible"
      width="20%"
      center>
      <el-form :model="update.subject">
        <el-form-item label="课程名称" label-width="80px">
          <el-input v-model="update.subject.subjectName" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="updateSubject()">确定修改</el-button>
        <el-button @click="centerDialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>


    <el-table
      :data="search(nameKeyWord)"
      style="width: 100%">
      <el-table-column
        prop="subjectId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="subjectName"
        label="课程名称"
        width="600">
      </el-table-column>
      <el-table-column
        prop="subjectMajorOrMinor"
        label="课程主辅修"
        width="100">
      </el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-autocomplete
            popper-class="my-autocomplete"
            v-model="nameKeyWord"
            :fetch-suggestions="querySearch"
            placeholder="请输入内容">
            <template slot-scope="{ item }">
              <div class="name">{{ item.value }}</div>
            </template>
          </el-autocomplete>
        </template>
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="skipUpdate(scope.row.subjectId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteSubject(scope.row.subjectId)"></el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  name: "SubjectHome",
  data() {
    return {
      insert:{
        majorSubject:{
          major:{
            majorId:""
          },
          subject:{
            subjectName:"",
            subjectMajorOrMinor:"1"
          }
        }

      },

      update:{
        subject:{
          subjectId:"",
          subjectName:"",
          subjectMajorOrMinor:""
        }
      },
      allSubjects:[],
      allMajors:[],
      nameKeyWord:"",
      subjectMajorOrMinorList:[
        {
          name:"主修",
          value:"1"
        },
        {
          name:"辅修",
          value: "2"
        }
      ],
      //修改课程弹出框
      centerDialogVisible:false
    }
  },
  methods: {
    //查询所有的课程信息
    selectAllSubject(){
      this.$http.get("api/eas/subject/selectAllSubject").then(
        res=>{
          let data = res.data.data;
          data.forEach(item=>{
            if(item.subjectMajorOrMinor == "1"){
              item.subjectMajorOrMinor = "主修"
            }else{
              item.subjectMajorOrMinor = "辅修"
            }
          })
          this.allSubjects = data;

        }
      )
    },
    //清空表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //添加课程
    insertSubject(){
      this.$http.post("api/eas/subject/insertSubject",
        this.insert.majorSubject
      ).then(res=>{
        let body = res.data;
        if(body.status == '100'){
          this.insert.majorSubject.subject.subjectName = "";
          this.selectAllSubject();
          this.$message.success(body.message);
        }else if(body.status == '101'){
          this.$message.error(body.message);
        }
      })
    },

    //根据名字进行查询
    search(nameKeyWord) {
      let newList = [];
      nameKeyWord = nameKeyWord.replace(/\s+/g, "");
      this.allSubjects.forEach((item) => {
        if (item.subjectName.indexOf(nameKeyWord) != -1) {
          newList.push(item);
        }
      })
      return newList;
    },
    //文本框提示
    querySearch(queryString, cb) {
      let newArr = [];
      let allSubjects = this.allSubjects;
      allSubjects.forEach(item =>{
        newArr.push({
          value:item.subjectName
        })
      })
      let results = queryString ? newArr.filter(this.createFilter(queryString)) : newArr;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (allSubjects) => {
        return (allSubjects.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    //数据回显及打开修改弹窗
    skipUpdate(subjectId){
      this.$http.post("api/eas/subject/selectSubjectByCondition",
        {subjectId:subjectId}
      ).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.update.subject = body.data[0];
            this.centerDialogVisible = true;
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },
    updateSubject(){
      this.$http.put("api/eas/subject/updateSubject",
        this.update.subject
      ).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.centerDialogVisible = false;
            this.selectAllSubject();
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },
    //删除课程
    deleteSubject(subjectId){
      this.$http.delete("api/eas/subject/deleteSubject/"+subjectId).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.selectAllSubject();
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
        this.selectAllSubject();
      }
    )

  },
  filter: {
    transformMajorMinor: arg => {
      if (arg == 1) {
        return '主修'
      } else if (arg == 2) {
        return '辅修'
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
  width: 100%;
}
.demo-image{
  padding-left: 30px;
  padding-top: 30px;
}
</style>

