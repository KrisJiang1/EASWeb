<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="2">
        <div class="grid-content bg-purple">
          <el-button type="danger" icon="el-icon-circle-plus-outline" @click="dialogVisible = true">添加班级
          </el-button>
        </div>
      </el-col>
      <el-col :span="8" :offset="12"><div class="grid-content bg-purple">
        <el-row>
          <el-col :span="17">
            <el-input v-model="searchKeyWord" size="middle" placeholder="输入关键字搜索"/>
          </el-col>
        </el-row>
      </div>
      </el-col>
    </el-row>

    <el-tabs v-model="dormiBuilIdIndex" >
      <el-tab-pane label="A栋" name="1"></el-tab-pane>
      <el-tab-pane label="B栋" name="2"></el-tab-pane>
      <el-tab-pane label="C栋" name="3"></el-tab-pane>
      <el-tab-pane label="D栋" name="4"></el-tab-pane>
    </el-tabs>

    <el-table
      :data="searchByName(searchKeyWord)"
      style="width: 100%">
      <el-table-column
        prop="dormitoryId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="dormitoryName"
        label="寝室号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="dormitoryPeoNum"
        label="人数">
      </el-table-column>
      <el-table-column label="查看寝室所有成员">
        <template slot-scope="scope">
          <el-button type="success" plain @click="skipSelectAllStuInDor(scope.row.dormitoryId)">所有成员</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle disabled></el-button>
          <el-button type="danger" icon="el-icon-delete" circle disabled ></el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
  export default {
    name: "DormitoryHome",
    data() {
      return {
        dormitoryBuilding:{
          dormitoryList:[]
        },
        searchKeyWord: '',
        dormiBuilIdIndex: '1'
      }
    },
    methods: {
      selectDormByBuildId(){
        this.$http.post("api/eas/dorBuil/selectDorBuilByCondition",
          {"dormiBuilId":this.dormiBuilIdIndex}
        ).then(
          res=>{
            this.dormitoryBuilding = res.data.data[0];
            console.log(this.dormitoryBuilding);
          }
        )
      },
      //跳转到显示寝室内所有成员的页面
      skipSelectAllStuInDor(dormitoryId){
        this.$router.push({
          name:"selectStudentsInDor",
          query:{
            i:dormitoryId
          }
        })
      },
      searchByName(searchKeyWord){
        let newArr = [];
        searchKeyWord = searchKeyWord.replace(/\s+/g, "");
        this.dormitoryBuilding.dormitoryList.forEach(item=>{
          if (item.dormitoryName.indexOf(searchKeyWord) != -1){
            newArr.push(item);
          }
        })
        return newArr;
      }
    },
    created() {
      this.selectDormByBuildId();
    },
    watch:{
      dormiBuilIdIndex(newVal,oldVal){
        this.selectDormByBuildId();
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

