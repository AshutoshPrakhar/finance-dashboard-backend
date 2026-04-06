package com.finance.assignment.controller;

import com.finance.assignment.entity.FinancialRecord;
import com.finance.assignment.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialController {

    @Autowired
    private FinancialService service;

    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return service.create(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }
}
