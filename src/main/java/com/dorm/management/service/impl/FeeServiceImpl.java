package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Fee;
import com.dorm.management.mapper.FeeMapper;
import com.dorm.management.service.IFeeService;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fee> implements IFeeService {
}
