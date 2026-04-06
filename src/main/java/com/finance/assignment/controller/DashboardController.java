package com.finance.assignment.controller;

import com.finance.assignment.dto.DashboardSummary;
import com.finance.assignment.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public DashboardSummary getSummary() {
        return service.getSummary();
    }
}
