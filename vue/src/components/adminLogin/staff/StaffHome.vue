<template>
  <div>
    <el-form :model="staff" ref="staff" label-width="100px" class="demo-ruleForm">
      <div style="display: flex">
        <el-form-item label="工号" prop="staffId">
          <el-input v-model="staff.staffId" clearable></el-input>
        </el-form-item>

        <el-form-item label="姓名" prop="staffName">
          <el-input v-model="staff.staffName" clearable></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="staffSex" style="width: 308px">
          <el-radio-group v-model="staff.staffSex">
            <el-radio label="">全部</el-radio>
            <el-radio label="1">男</el-radio>
            <el-radio label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="联系方式" prop="staffPhone">
          <el-input v-model="staff.staffPhone" clearable></el-input>
        </el-form-item>
      </div>

      <div style="display: flex">
        <el-form-item label="身份证件" prop="staffIdNum" style="width: 308px">
          <el-input v-model="staff.staffIdNum" clearable></el-input>
        </el-form-item>


        <el-form-item label="所属职位" prop="staffPost">
          <el-select v-model="staff.staffPost.postId" placeholder="请选择" clearable>
            <el-option
              v-for="item in formMsg.allPosts"
              :key="item.postId"
              :label="item.postName"
              :value="item.postId">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="家庭住址" prop="staffAddress">
          <el-input v-model="staff.staffAddress" clearable></el-input>
        </el-form-item>
      </div>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="selectStaffByCondition()">立即查询</el-button>
      </el-form-item>
    </el-form>

    <el-row style="float: left">
          <el-button type="danger" icon="el-icon-search" @click="selectAllStaff()">查看全部</el-button>

          <router-link to="/staffManage/insertStaff">
            <el-button type="danger" icon="el-icon-circle-plus-outline">添加工作人员</el-button>
          </router-link>
    </el-row>

    <el-table
      v-loading="loading"
      :data="allStaffs"
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
                <span>{{ props.row.staffId }}</span>
              </el-form-item>
              <el-form-item label="姓名:">
                <span>{{ props.row.staffName }}</span>
              </el-form-item>
              <el-form-item label="性别:">
                <span>{{ props.row.staffSex }}</span>
              </el-form-item>
              <el-form-item label="联系方式:">
                <span>{{ props.row.staffPhone }}</span>
              </el-form-item>
              <el-form-item label="身份证件:">
                <span>{{ props.row.staffIdNum }}</span>
              </el-form-item>
              <el-form-item label="职务:">
                <span>{{ props.row.staffPost.postName }}</span>
              </el-form-item>
              <el-form-item label="地址:">
                <span>{{ props.row.staffAddress }}</span>
              </el-form-item>
            </div>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="工号"
        prop="staffId">
      </el-table-column>
      <el-table-column
        label="姓名"
        prop="staffName">
      </el-table-column>
      <el-table-column
        label="职务"
        prop="staffPost.postName">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="skipUpdate(scope.row.staffId)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteStaff(scope.row.staffId)"></el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "StaffHome",
  data() {
    return {
      allStaffs:[],
      staff: {
        staffId:"",
        staffName: "",
        staffSex: "",
        staffPhone: "",
        staffIdNum: "",
        staffPost: {
          postId:""
        },
        staffAddress: "",
      },
      formMsg:{
        allPosts:[]
      },
      loading: true
    }
  },
  methods: {
    selectStaffByCondition(){
      this.$http.post("api/eas/staff/selectStaffByCondition",
        this.staff).then(
          res=>{
            if(res.data.status == '100'){
              this.allStaffs = res.data.data;
            }else{
              this.$message.error(res.data.message);
            }
          }
      )
    },

    selectAllStaff(){
      this.$http.get("api/eas/staff/selectAllStaff").then(
        res=>{
          res.data.data.forEach(function (e){
            if (e.staffSex == 1){
              e.staffSex = "男"
            }else{
              e.staffSex = "女"
            }
          });
          this.allStaffs = res.data.data;
          console.log(this.allStaffs);
        }
      )
    },

    //未测试
    deleteStaff(staffId){
      this.$http.delete("api/eas/staff/deleteStaff/"+staffId).then(
        res=>{
          let body = res.data;
          if(body.status == '100'){
            this.$message({
              message:body.message,
              type:"success"
            });
          }else if(body.status == '101'){
            this.$message.error(body.message);
          }
        }
      )
    },
    //跳转到update页面
    skipUpdate(staffId){
      this.$router.push({
        name:'updateStaff',
        query:{
          i:staffId
        }
      })
    }
  },
  created() {
    this.$http.get("api/eas/post/selectAllPost").then(
      res=>{
        this.formMsg.allPosts = res.data.data;
        this.selectAllStaff();
        this.loading = false;
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

