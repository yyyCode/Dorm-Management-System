package com.dorm.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * 宿舍表实体类
 */
@Data
@TableName("Dorm")
public class Dorm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍ID，手动生成的唯一标识
     */
    @TableId(value = "DormID", type = IdType.INPUT)
    private String dormId;

    /**
     * 宿舍楼号
     */
    @com.baomidou.mybatisplus.annotation.TableField("Building")
    private String building;

    /**
     * 床位数
     */
    @com.baomidou.mybatisplus.annotation.TableField("BedCount")
    private Integer bedCount;
}
