<template>
  <div>

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
        width="800">
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
      allSubjects:[],
      nameKeyWord:"",
      studentId:""
    }
  },
  methods: {
    //查询所有的课程信息
    selectAllSubject(){
      let studentId = this.$route.query.i;
      this.studentId = studentId;
      this.$http.post("api/eas/student/selectStudentByCondition",
        {studentId:studentId}
      ).then(
        res=>{
          this.allSubjects = res.data.data[0].studentSubjectList;
        }
      )
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
    deleteSubject(subjectId){
      this.$http.delete("api/eas/student/deleteStudentSubject/"+this.studentId+"/"+subjectId).then(
        res=>{
          this.selectAllSubject();
        }
      )
    }
  },
  created() {
    this.selectAllSubject();
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

