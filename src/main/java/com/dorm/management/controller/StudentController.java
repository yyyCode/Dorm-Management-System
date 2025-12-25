package com.dorm.management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dorm.management.entity.Student;
import com.dorm.management.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    // 查全部
    @GetMapping
    public List<Student> list() {
        return studentService.list();
    }

    // 分页查询 (简单实现，实际需配置PaginationInnerInterceptor)
    @GetMapping("/page")
    public IPage<Student> page(@RequestParam(defaultValue = "1") int current,
                               @RequestParam(defaultValue = "10") int size) {
        return studentService.page(new Page<>(current, size));
    }

    // 查单个
    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return studentService.getById(id);
    }

    // 新增
    @PostMapping
    public boolean save(@RequestBody Student student) {
        return studentService.save(student);
    }

    // 修改
    @PutMapping
    public boolean update(@RequestBody Student student) {
        return studentService.updateById(student);
    }

    // 删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return studentService.removeById(id);
    }
}
