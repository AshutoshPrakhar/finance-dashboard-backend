package com.finance.assignment.service;

import com.finance.assignment.entity.FinancialRecord;

import java.util.List;

public interface FinancialService {
    FinancialRecord create(FinancialRecord record);
    List<FinancialRecord> getAll();
}