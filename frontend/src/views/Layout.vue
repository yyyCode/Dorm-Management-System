<template>
  <el-container class="layout-container">
    <el-aside width="200px">
      <div class="logo">Dorm System</div>
      <el-menu
        router
        :default-active="$route.path"
        class="el-menu-vertical"
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409EFF"
      >
        <el-menu-item index="/students">
          <el-icon><User /></el-icon>
          <span>学生管理</span>
        </el-menu-item>
        <el-menu-item index="/dorms">
          <el-icon><House /></el-icon>
          <span>宿舍管理</span>
        </el-menu-item>
        <el-menu-item index="/beds">
          <el-icon><Files /></el-icon>
          <span>床位管理</span>
        </el-menu-item>
        <el-menu-item index="/fees">
          <el-icon><Money /></el-icon>
          <span>费用管理</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <div class="header-content">
          <h2>宿舍管理系统</h2>
        </div>
      </el-header>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.layout-container {
  height: 100vh;
}
.el-aside {
  background-color: #304156;
  color: #fff;
}
.logo {
  height: 60px;
  line-height: 60px;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
  color: #fff;
  border-bottom: 1px solid #1f2d3d;
}
.el-menu-vertical {
  border-right: none;
}
.el-header {
  background-color: #fff;
  border-bottom: 1px solid #dcdfe6;
  display: flex;
  align-items: center;
}
</style>
