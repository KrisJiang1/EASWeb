<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="2">
        <div class="grid-content bg-purple">
          <el-button type="danger" icon="el-icon-circle-plus-outline" @click="skipIns">添加专业</el-button>
        </div>
      </el-col>
      <el-col :span="5" :offset="16"><div class="grid-content bg-purple">
        <el-row>
          <el-col :span="24">
            <el-autocomplete
              popper-class="my-autocomplete"
              v-model="nameKeyWord"
              :fetch-suggestions="querySearch"
              placeholder="请输入内容">
              <template slot-scope="{ item }">
                <div class="name">{{ item.value }}</div>
              </template>
            </el-autocomplete>
          </el-col>
        </el-row>
      </div>
      </el-col>
    </el-row>

    <el-table
      :data="search(nameKeyWord)"
      style="width: 100%">
      <el-table-column
        prop="majorId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="majorName"
        label="专业名称"
        width="280">
      </el-table-column>
      <el-table-column
        prop="majorSchoolSystem"
        label="学制">
      </el-table-column>
      <el-table-column label="查看">
        <template slot-scope="scope">
          <el-button type="success" plain @click="selectMajorSub(scope.row.majorId)">查看专业课程</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="skipUpd(scope.row.majorId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteMajor(scope.row.majorId)"></el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  name: "MajorHome",
  data() {
    return {
      allMajors:[],
      nameKeyWord:""
    }
  },
  methods: {
    //查询所有的专业信息
    selectAllMajor(){
      this.$http.get("api/eas/major/selectAllMajor").then(
        res=>{
          res.data.data.forEach(function (e){
            e.majorSchoolSystem = e.majorSchoolSystem+"年";
          })
          this.allMajors = res.data.data;
        }
      )
    },


    //根据名字进行查询
    search(nameKeyWord) {
      let newList = [];
      nameKeyWord = nameKeyWord.replace(/\s+/g, "");
      this.allMajors.forEach((item) => {
        if (item.majorName.indexOf(nameKeyWord) != -1) {
          newList.push(item);
        }
      })
      return newList;
    },
    //文本框提示
    querySearch(queryString, cb) {
      let newArr = [];
      let allMajors = this.allMajors;
      allMajors.forEach(item =>{
        newArr.push({
          value:item.majorName
        })
      })
      let results = queryString ? newArr.filter(this.createFilter(queryString)) : newArr;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (allMajors) => {
        return (allMajors.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    //跳转到根据专业查询课程页面
    selectMajorSub(majorId){
      this.$router.push({
        name:"selectSubjectByMajor",
        query:{
          i:majorId
        }
      })
    },
    //跳转到添加页面
    skipIns(){
      this.$router.push({
        name:"insertMajor"
      })
    },
    //跳转到修改页面
    skipUpd(majorId){
      this.$router.push({
        name:"updateMajor",
        query:{
          i:majorId
        }
      })
    },
    //删除专业
    deleteMajor(majorId){
      this.$http.delete("api/eas/major/deleteMajor/"+majorId).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message.success(body.message);
            this.selectAllMajor();
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    }
  },
  created() {
    this.selectAllMajor();
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

