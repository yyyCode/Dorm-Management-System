package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Student;
import com.dorm.management.mapper.StudentMapper;
import com.dorm.management.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
}
