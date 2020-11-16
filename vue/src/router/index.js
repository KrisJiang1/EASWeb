import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/adminLogin/Home"
import Login from "../components/login/Login";
import StudentManage from "../components/adminLogin/student/StudentManage";
import StudentHome from "../components/adminLogin/student/StudentHome";
import InsertStudent from "../components/adminLogin/student/InsertStudent";
import UpdateStudent from "../components/adminLogin/student/UpdateStudent";
import SelectStudentSubject from "../components/adminLogin/student/SelectStudentSubject";

import TeacherManage from "../components/adminLogin/teacher/TeacherManage";
import TeacherHome from "../components/adminLogin/teacher/TeacherHome";
import InsertTeacher from "../components/adminLogin/teacher/InsertTeacher";
import UpdateTeacher from "../components/adminLogin/teacher/UpdateTeacher";

import StaffManage from "../components/adminLogin/staff/StaffManage";
import StaffHome from "../components/adminLogin/staff/StaffHome";
import InsertStaff from "../components/adminLogin/staff/InsertStaff";
import UpdateStaff from "../components/adminLogin/staff/UpdateStaff";

import MajorManage from "../components/adminLogin/major/MajorManage";
import MajorHome from "../components/adminLogin/major/MajorHome";
import InsertMajor from "../components/adminLogin/major/InsertMajor";
import UpdateMajor from "../components/adminLogin/major/UpdateMajor";
import SelectSubjectByMajor from "../components/adminLogin/major/SelectSubjectByMajor";

import ClazzManage from "../components/adminLogin/clazz/ClazzManage";
import ClazzHome from "../components/adminLogin/clazz/ClazzHome";
import InsertClazz from "../components/adminLogin/clazz/InsertClazz";
import UpdateClazz from "../components/adminLogin/clazz/UpdateClazz";
import SelectClazzStudent from "../components/adminLogin/clazz/SelectClazzStudent";

import DormitoryManage from "../components/adminLogin/dormitory/DormitoryManage";
import DormitoryHome from "../components/adminLogin/dormitory/DormitoryHome";
import SelectStudentsInDor from "../components/adminLogin/dormitory/SelectStudentsInDor";

import SubjectManage from "../components/adminLogin/subject/SubjectManage";
import SubjectHome from "../components/adminLogin/subject/SubjectHome";
import UpdateSubject from "../components/adminLogin/subject/UpdateSubject";

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',redirect:'/login'},
    {path: '/login',component: Login,name:"登录"},
    {path: '/home', component: Home,name:"首页",meta:{index:"1"},
      children: [
        {path: '/studentManage', component: StudentManage,name: "studentManage",meta:{title:'学生管理'},
          children:[
            {path: '/', redirect:'studentHome'},
            {path: 'studentHome',component: StudentHome,name:'studentHome',meta:{title:'学生管理主页'}},
            {path: 'insertStudent',component: InsertStudent,name:'insertStudent',meta:{title:'添加学生'}},
            {path: 'updateStudent',component: UpdateStudent,name:'updateStudent',meta:{title:'修改学生'}},
            {path: 'selectStudentSubject',component: SelectStudentSubject,name:'selectStudentSubject',meta:{title:'查看选课'}}
          ]
        },
        {path: '/teacherManage', component: TeacherManage,name: "teacherManage",meta:{title:'教师管理'},
          children:[
            {path: '/', redirect:'teacherHome'},
            {path: 'teacherHome', component: TeacherHome, name:'teacherHome',meta:{title:'教师管理主页'}},
            {path: 'insertTeacher', component: InsertTeacher, name:'insertTeacher',meta:{title:'添加教师'}},
            {path: 'updateTeacher', component: UpdateTeacher, name:'updateTeacher',meta:{title:'修改教师'}}
          ]
        },
        {path: '/staffManage', component: StaffManage,name: "staffManage",meta:{title:'工作人员管理'},
          children: [
            {path: '/', redirect:'staffHome'},
            {path: 'staffHome', component: StaffHome, name:'staffHome',meta:{title:'工作人员管理主页'}},
            {path: 'insertStaff', component: InsertStaff, name:'insertStaff',meta:{title:'添加工作人员'}},
            {path: 'updateStaff', component: UpdateStaff, name:'updateStaff',meta:{title:'修改工作人员'}}
          ]
        },
        {path: '/majorManage', component: MajorManage,name: "majorManage",meta:{title:'专业管理'},
          children: [
            {path: '/', redirect: 'majorHome'},
            {path: 'majorHome', component: MajorHome,name:"majorHome",meta:{title:'专业管理主页'}},
            {path: 'insertMajor', component: InsertMajor,name:"insertMajor",meta:{title:'添加专业'}},
            {path: 'updateMajor', component: UpdateMajor,name:"updateMajor",meta:{title:'修改专业'}},
            {path: 'selectSubjectByMajor', component: SelectSubjectByMajor,name:"selectSubjectByMajor",meta:{title:'专业课程'}},
          ]
        },
        {path: '/clazzManage', component: ClazzManage,name: "clazzManage",meta:{title:'班级管理'},
          children: [
            {path: '/', redirect: 'clazzHome'},
            {path: 'clazzHome', component: ClazzHome,name:"clazzHome",meta:{title:'班级管理主页'}},
            {path: 'insertClazz', component: InsertClazz,name:"insertClazz",meta:{title:'添加班级'}},
            {path: 'updateClazz', component: UpdateClazz,name:"updateClazz",meta:{title:'修改班级'}},
            {path: 'selectClazzStudent', component: SelectClazzStudent,name:"selectClazzStudent",meta:{title:'该班学生'}},

          ]
        },
        {path: '/dormitoryManage', component: DormitoryManage,name: "dormitoryManage",meta:{title:'寝室管理'},
          children: [
            {path: '/',redirect: 'dormitoryHome'},
            {path: 'dormitoryHome', component: DormitoryHome,name:"dormitoryHome",meta:{title:'寝室管理主页'}},
            {path: 'selectStudentsInDor', component: SelectStudentsInDor,name:"selectStudentsInDor",meta:{title:'寝室所有成员'}},
          ]
        },
        {path: '/subjectManage', component: SubjectManage,name: "subjectManage",meta:{title:"课程管理"},
          children: [
            {path: '/',redirect: 'subjectHome'},
            {path: 'subjectHome', component: SubjectHome,name:"subjectHome",meta:{title:'课程管理主页'}},
            {path: 'updateSubject', component: UpdateSubject,name:"updateSubject",meta:{title:'修改课程'}},
          ]
        }
      ]
    }
  ]
})
