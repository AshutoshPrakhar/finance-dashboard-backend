package com.finance.assignment.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/dashboard/test")
    public String dashboard() {
        return "Dashboard working";
    }

    @GetMapping("/admin/test")
    public String admin() {
        return "Admin working";
    }
    @GetMapping("/whoami")
    public String whoAmI() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }
}