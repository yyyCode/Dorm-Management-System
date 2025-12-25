package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Bed;
import com.dorm.management.mapper.BedMapper;
import com.dorm.management.service.IBedService;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements IBedService {

    @Override
    public Bed getByDormAndBedNum(String dormId, Integer bedNumber) {
        return this.getOne(new LambdaQueryWrapper<Bed>()
                .eq(Bed::getDormId, dormId)
                .eq(Bed::getBedNumber, bedNumber));
    }

    @Override
    public boolean removeByDormAndBedNum(String dormId, Integer bedNumber) {
        return this.remove(new LambdaQueryWrapper<Bed>()
                .eq(Bed::getDormId, dormId)
                .eq(Bed::getBedNumber, bedNumber));
    }

    @Override
    public boolean updateStatus(String dormId, Integer bedNumber, Boolean isAssigned) {
        return this.update(new LambdaUpdateWrapper<Bed>()
                .eq(Bed::getDormId, dormId)
                .eq(Bed::getBedNumber, bedNumber)
                .set(Bed::getIsAssigned, isAssigned));
    }
}
