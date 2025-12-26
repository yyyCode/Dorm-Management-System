package com.dorm.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 学生表实体类
 */
@Data
@TableName("Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生ID，手动生成的唯一标识
     */
    @TableId(value = "StudentID", type = IdType.INPUT)
    private String studentId;

    /**
     * 出生日期
     */
    @com.baomidou.mybatisplus.annotation.TableField("BirthDate")
    private LocalDate birthDate;

    /**
     * 年级
     */
    @com.baomidou.mybatisplus.annotation.TableField("Grade")
    private String grade;

    /**
     * 宿舍ID，外键
     */
    @com.baomidou.mybatisplus.annotation.TableField("DormID")
    private String dormId;

    /**
     * 床位号
     */
    @com.baomidou.mybatisplus.annotation.TableField("BedNumber")
    private Integer bedNumber;

    /**
     * 联系方式
     */
    @com.baomidou.mybatisplus.annotation.TableField("Phone")
    private String phone;

    /**
     * 学生姓名
     */
    @com.baomidou.mybatisplus.annotation.TableField("Name")
    private String name;

    /**
     * 性别 (M/F)
     */
    @com.baomidou.mybatisplus.annotation.TableField("Gender")
    private String gender;
}
