package com.dorm.management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * 床位表实体类
 * 注意：此表为复合主键 (DormID + BedNumber)，MyBatis-Plus 默认只支持单主键。
 * 在 Service 层操作时需使用 QueryWrapper 进行精确匹配。
 */
@Data
@TableName("Bed")
public class Bed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍ID，外键 (复合主键之一)
     */
    @com.baomidou.mybatisplus.annotation.TableField("DormID")
    private String dormId;

    /**
     * 床位号 (复合主键之一)
     */
    @com.baomidou.mybatisplus.annotation.TableField("BedNumber")
    private Integer bedNumber;

    /**
     * 是否已分配
     */
    @com.baomidou.mybatisplus.annotation.TableField("IsAssigned")
    private Boolean isAssigned;

    /**
     * 入住学生ID
     */
    @com.baomidou.mybatisplus.annotation.TableField("StudentID")
    private String studentId;
}
