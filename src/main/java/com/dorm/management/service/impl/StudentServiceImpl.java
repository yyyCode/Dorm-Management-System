package com.dorm.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dorm.management.entity.Student;
import com.dorm.management.mapper.StudentMapper;
import com.dorm.management.service.IBedService;
import com.dorm.management.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Objects;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private IBedService bedService;

    @Override
    public boolean save(Student entity) {
        boolean result = super.save(entity);
        if (result && entity.getDormId() != null && entity.getBedNumber() != null) {
            bedService.assignBed(entity.getDormId(), entity.getBedNumber(), entity.getStudentId());
        }
        return result;
    }

    @Override
    public boolean updateById(Student entity) {
        Student oldStudent = this.getById(entity.getStudentId());
        boolean result = super.updateById(entity);
        if (result && oldStudent != null) {
            // 检查床位是否发生变化
            // 注意：这里假设 entity 中如果 dormId/bedNumber 为 null，则表示不修改（MyBatis-Plus 默认行为）
            // 如果需要支持清空床位，前端需传递特定值或后端改用 UpdateWrapper
            boolean dormChanged = entity.getDormId() != null && !Objects.equals(entity.getDormId(), oldStudent.getDormId());
            boolean bedChanged = entity.getBedNumber() != null && !Objects.equals(entity.getBedNumber(), oldStudent.getBedNumber());

            if (dormChanged || bedChanged) {
                // 释放旧床位
                if (oldStudent.getDormId() != null && oldStudent.getBedNumber() != null) {
                    bedService.releaseBed(oldStudent.getDormId(), oldStudent.getBedNumber());
                }
                // 分配新床位
                String newDormId = entity.getDormId() != null ? entity.getDormId() : oldStudent.getDormId();
                Integer newBedNum = entity.getBedNumber() != null ? entity.getBedNumber() : oldStudent.getBedNumber();
                
                if (newDormId != null && newBedNum != null) {
                    bedService.assignBed(newDormId, newBedNum, entity.getStudentId());
                }
            }
        }
        return result;
    }

    @Override
    public boolean removeById(Serializable id) {
        Student student = this.getById(id);
        boolean result = super.removeById(id);
        if (result && student != null && student.getDormId() != null && student.getBedNumber() != null) {
            bedService.releaseBed(student.getDormId(), student.getBedNumber());
        }
        return result;
    }
}
