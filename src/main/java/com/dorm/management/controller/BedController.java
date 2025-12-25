package com.dorm.management.controller;

import com.dorm.management.entity.Bed;
import com.dorm.management.service.IBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private IBedService bedService;

    @GetMapping
    public List<Bed> list() {
        return bedService.list();
    }

    // 复合主键查询
    @GetMapping("/{dormId}/{bedNumber}")
    public Bed getById(@PathVariable String dormId, @PathVariable Integer bedNumber) {
        return bedService.getByDormAndBedNum(dormId, bedNumber);
    }

    @PostMapping
    public boolean save(@RequestBody Bed bed) {
        return bedService.save(bed);
    }

    // 修改状态
    @PutMapping("/{dormId}/{bedNumber}")
    public boolean updateStatus(@PathVariable String dormId, 
                                @PathVariable Integer bedNumber, 
                                @RequestParam Boolean isAssigned) {
        return bedService.updateStatus(dormId, bedNumber, isAssigned);
    }

    // 删除
    @DeleteMapping("/{dormId}/{bedNumber}")
    public boolean delete(@PathVariable String dormId, @PathVariable Integer bedNumber) {
        return bedService.removeByDormAndBedNum(dormId, bedNumber);
    }
}
