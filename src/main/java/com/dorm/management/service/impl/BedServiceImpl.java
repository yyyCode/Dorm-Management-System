package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Bed;
import com.dorm.management.mapper.BedMapper;
import com.dorm.management.service.IBedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

    @Override
    public boolean assignBed(String dormId, Integer bedNumber, String studentId) {
        return this.update(new LambdaUpdateWrapper<Bed>()
                .eq(Bed::getDormId, dormId)
                .eq(Bed::getBedNumber, bedNumber)
                .set(Bed::getIsAssigned, true)
                .set(Bed::getStudentId, studentId));
    }

    @Override
    public boolean releaseBed(String dormId, Integer bedNumber) {
        return this.update(new LambdaUpdateWrapper<Bed>()
                .eq(Bed::getDormId, dormId)
                .eq(Bed::getBedNumber, bedNumber)
                .set(Bed::getIsAssigned, false)
                .set(Bed::getStudentId, null));
    }
}
