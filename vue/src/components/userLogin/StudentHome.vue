<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-tabs>
          <el-tab-pane ></el-tab-pane>
          <el-tab-pane label="教务后台管理系统"></el-tab-pane>
        </el-tabs>
      </el-header>
      <el-container style="height: 1030px">
        <el-aside width="200px">
          <el-row class="tac">
            <el-col>
              <h4>功能区域</h4>
              <el-menu default-active="1" class="el-menu-vertical-demo">

                <router-link to="/home">
                  <el-menu-item index="1">
                    <i class="el-icon-s-home"></i>
                    <span slot="title">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</span>
                  </el-menu-item>
                </router-link>

                <router-link to="/studentManage">
                  <el-menu-item index="2">
                    <i class="el-icon-user-solid"></i>
                    <span slot="title">校内公告</span>
                  </el-menu-item>
                </router-link>

                <router-link to="/teacherManage">
                  <el-menu-item index="3">
                    <i class="el-icon-s-check"></i>
                    <span slot="title">教师管理</span>
                  </el-menu-item>
                </router-link>


                <router-link to="/staffManage">
                  <el-menu-item index="4">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">工作人员管理</span>
                  </el-menu-item>
                </router-link>


                <router-link to="/majorManage">
                  <el-menu-item index="5">
                    <i class="el-icon-notebook-2"></i>
                    <span slot="title">专业管理</span>
                  </el-menu-item>
                </router-link>

                <router-link to="/subjectManage">
                  <el-menu-item index="6">
                    <i class="el-icon-menu"></i>
                    <span slot="title">课程管理</span>
                  </el-menu-item>
                </router-link>

                <router-link to="/clazzManage">
                  <el-menu-item index="7">
                    <i class="el-icon-sunny"></i>
                    <span slot="title">班级管理</span>
                  </el-menu-item>
                </router-link>

                <router-link to="/dormitoryManage">
                  <el-menu-item index="8">
                    <i class="el-icon-office-building"></i>
                    <span slot="title">寝室管理</span>
                  </el-menu-item>
                </router-link>


              </el-menu>
            </el-col>

          </el-row>
        </el-aside>
        <el-main>
          <el-header style="height: 40px">
            <!-- 面包屑 -->
            <el-breadcrumb class="app-breadcrumb" separator="/" style="margin-top: 10px">
              <transition-group name="breadcrumb">
                <el-breadcrumb-item v-for="(item,index) in levelList" v-if="item.meta.title" :key="item.path">
                  <span v-if="item.redirect==='noredirect'||index==levelList.length-1" class="no-redirect">{{item.meta.title}}</span>
                  <router-link v-else :to="item.redirect||item.path">{{item.meta.title}}</router-link>
                </el-breadcrumb-item>
              </transition-group>
            </el-breadcrumb>
            <el-divider></el-divider>
          </el-header>
          <el-main>
            <router-view></router-view>
          </el-main>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "StudentHome",
  data() {
    return {
      activeName:'first',
      levelList: null
    };
  },
  methods: {
    //生成面包屑的方法
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name)
      const first = matched[0]
      if (first && first.name !== 'home') {
        matched = [{path: '/home', meta: { title: '首页' }}].concat(matched)
      }
      this.levelList = matched;
    }
  },
  created() {
    this.getBreadcrumb();
  },
  watch: {
    $route(to, from) {
      this.getBreadcrumb();
    }
  }

}
</script>

<style scoped>
body,html{
  padding: 0;
  margin: 0;
}

.el-header {
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  color: #333;
  text-align: center;
}

.el-main {
  color: #333;
  text-align: center;
}

body > .el-container {
  margin-bottom: 40px;
}

a{
  text-decoration: none;
}
.el-divider--horizontal{
  margin: 10px 0 0;
}
</style>
