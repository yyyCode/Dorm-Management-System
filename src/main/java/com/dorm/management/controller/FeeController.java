package com.dorm.management.controller;

import com.dorm.management.entity.Fee;
import com.dorm.management.service.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private IFeeService feeService;

    @GetMapping
    public List<Fee> list() {
        return feeService.list();
    }

    @GetMapping("/{id}")
    public Fee getById(@PathVariable String id) {
        return feeService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Fee fee) {
        return feeService.save(fee);
    }

    @PutMapping
    public boolean update(@RequestBody Fee fee) {
        return feeService.updateById(fee);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return feeService.removeById(id);
    }
}
