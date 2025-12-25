# 宿舍管理系统 (Dorm Management System)

这是一个基于 **Spring Boot** 和 **Vue 3** 的现代化宿舍管理系统。支持学生信息管理、宿舍分配、床位管理以及费用缴纳记录等功能。

## 🛠️ 技术栈

### 后端 (Backend)
- **核心框架**: Spring Boot 3.3.1
- **ORM 框架**: MyBatis-Plus
- **数据库**: MySQL 5.7/8.0
- **工具**: Lombok, Maven

### 前端 (Frontend)
- **核心框架**: Vue 3 (Composition API)
- **构建工具**: Vite
- **UI 组件库**: Element Plus
- **路由**: Vue Router
- **HTTP 客户端**: Axios

## 🚀 快速开始 (Quick Start)

### 1. 数据库配置 (Database Configuration)

项目已配置连接到远程数据库，无需本地搭建数据库（除非你想改回本地）。

- **配置文件**: `src/main/resources/application.yml`
- **IP**: `10.21.32.13`
- **端口**: `3306`
- **数据库名**: `DormManagement`
- **用户名/密码**: `root` / `12345678`

> **注意**: 请确保你的网络环境可以访问该 IP 地址。

### 2. 启动后端 (Start Backend)

在项目根目录下（`d:\Java\Dorm-Management-System`），运行以下命令：

```bash
# 编译并运行 Spring Boot 应用
mvn spring-boot:run
```

后端服务默认启动在 `http://localhost:8080`。

### 3. 启动前端 (Start Frontend)

打开一个新的终端窗口，进入 `frontend` 目录并启动开发服务器：

```bash
# 进入前端目录
cd frontend

# 安装依赖 (仅第一次运行需要)
npm install

# 启动开发服务器
npm run dev
```

前端服务默认启动在 `http://localhost:5173`。

## 📂 功能模块

1.  **学生管理**: 录入、修改、删除学生信息（手动输入学号，非自增）。
2.  **宿舍管理**: 管理宿舍楼及房间信息。
3.  **床位管理**: 查看和分配床位状态（复合主键设计）。
4.  **费用管理**: 记录学生的住宿费、水电费等（使用 UUID 作为主键）。

## 📝 目录结构

```
Dorm-Management-System/
├── src/                    # 后端源代码
│   ├── main/java/          # Java 代码
│   └── main/resources/     # 配置文件 (application.yml)
├── frontend/               # 前端源代码 (Vue + Vite)
│   ├── src/views/          # 页面组件 (Student.vue, Dorm.vue 等)
│   └── vite.config.js      # 前端代理配置
├── pom.xml                 # Maven 依赖配置
└── mock_data.sql           # 测试数据脚本
```
