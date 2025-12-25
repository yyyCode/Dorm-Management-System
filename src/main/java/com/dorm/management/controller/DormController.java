package com.dorm.management.controller;

import com.dorm.management.entity.Dorm;
import com.dorm.management.service.IDormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dorms")
public class DormController {

    @Autowired
    private IDormService dormService;

    @GetMapping
    public List<Dorm> list() {
        return dormService.list();
    }

    @GetMapping("/{id}")
    public Dorm getById(@PathVariable String id) {
        return dormService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Dorm dorm) {
        return dormService.save(dorm);
    }

    @PutMapping
    public boolean update(@RequestBody Dorm dorm) {
        return dormService.updateById(dorm);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return dormService.removeById(id);
    }
}
