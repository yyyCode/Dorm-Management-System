-- 创建数据库
CREATE DATABASE IF NOT EXISTS DormManagement;
USE DormManagement;

-- 创建学生表 (Student)
CREATE TABLE Student (
    StudentID VARCHAR(20) PRIMARY KEY,   -- 学生ID，手动生成的唯一标识
    Name VARCHAR(100) NOT NULL,           -- 学生姓名
    Gender CHAR(1) NOT NULL,              -- 性别 (M/F)
    BirthDate DATE,                       -- 出生日期
    Grade VARCHAR(50),                    -- 年级
    DormID VARCHAR(20),                   -- 宿舍ID，外键
    Phone VARCHAR(15)                     -- 联系方式
);

-- 创建宿舍表 (Dorm)
CREATE TABLE Dorm (
    DormID VARCHAR(20) PRIMARY KEY,       -- 宿舍ID，手动生成的唯一标识
    Building VARCHAR(50),                 -- 宿舍楼号
    BedCount INT NOT NULL                 -- 床位数
);

-- 创建床位表 (Bed) - 复合主键 (DormID + BedNumber)
CREATE TABLE Bed (
    DormID VARCHAR(20),                   -- 宿舍ID，外键
    BedNumber INT NOT NULL,               -- 床位号
    IsAssigned BOOLEAN DEFAULT FALSE,     -- 是否已分配
    PRIMARY KEY (DormID, BedNumber),      -- 复合主键：宿舍ID + 床位号
    FOREIGN KEY (DormID) REFERENCES Dorm(DormID)
);

-- 创建费用表 (Fee)
CREATE TABLE Fee (
    FeeID CHAR(36) PRIMARY KEY,           -- 费用ID，使用UUID作为主键
    StudentID VARCHAR(20),                -- 学生ID，外键
    FeeType VARCHAR(50),                  -- 费用类型（如住宿费、罚款等）
    Amount DECIMAL(10, 2),                -- 费用金额
    PayDate DATE,                         -- 缴费日期
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);
