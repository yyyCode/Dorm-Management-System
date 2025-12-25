package com.dorm.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 费用表实体类
 */
@Data
@TableName("Fee")
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用ID，使用UUID作为主键
     */
    @TableId(value = "FeeID", type = IdType.ASSIGN_UUID)
    private String feeId;

    /**
     * 学生ID，外键
     */
    @com.baomidou.mybatisplus.annotation.TableField("StudentID")
    private String studentId;

    /**
     * 费用类型（如住宿费、罚款等）
     */
    @com.baomidou.mybatisplus.annotation.TableField("FeeType")
    private String feeType;

    /**
     * 费用金额
     */
    @com.baomidou.mybatisplus.annotation.TableField("Amount")
    private BigDecimal amount;

    /**
     * 缴费日期
     */
    @com.baomidou.mybatisplus.annotation.TableField("PayDate")
    private LocalDate payDate;
}
