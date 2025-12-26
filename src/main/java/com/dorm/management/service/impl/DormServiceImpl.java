package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Dorm;
import com.dorm.management.mapper.DormMapper;
import com.dorm.management.service.IDormService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements IDormService {
}
