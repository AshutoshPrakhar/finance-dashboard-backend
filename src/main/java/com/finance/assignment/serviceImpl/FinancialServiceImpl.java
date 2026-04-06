package com.finance.assignment.serviceImpl;

import com.finance.assignment.entity.FinancialRecord;
import com.finance.assignment.entity.User;
import com.finance.assignment.repository.FinancialRecordRepository;
import com.finance.assignment.repository.UserRepository;
import com.finance.assignment.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialRecordRepository repo;

    @Autowired
    private UserRepository userRepo;

    public FinancialRecord create(FinancialRecord record) {

        // get logged-in user
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepo.findByUsername(username).orElseThrow();

        // set creator
        record.setCreatedBy(user);

        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }
}