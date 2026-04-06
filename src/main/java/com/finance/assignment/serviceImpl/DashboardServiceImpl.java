package com.finance.assignment.serviceImpl;

import com.finance.assignment.dto.DashboardSummary;
import com.finance.assignment.entity.FinancialRecord;
import com.finance.assignment.repository.FinancialRecordRepository;
import com.finance.assignment.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private FinancialRecordRepository repo;

    public DashboardSummary getSummary() {

        double income = repo.findAll().stream()
                .filter(r -> r.getType().equals("INCOME"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double expense = repo.findAll().stream()
                .filter(r -> r.getType().equals("EXPENSE"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        return new DashboardSummary(income, expense, income - expense);
    }
}
