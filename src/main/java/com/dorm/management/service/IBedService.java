package com.dorm.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dorm.management.entity.Bed;

public interface IBedService extends IService<Bed> {
    // 增加针对复合主键的操作定义
    Bed getByDormAndBedNum(String dormId, Integer bedNumber);
    boolean removeByDormAndBedNum(String dormId, Integer bedNumber);
    boolean updateStatus(String dormId, Integer bedNumber, Boolean isAssigned);
}
