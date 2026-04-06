package com.finance.assignment.serviceImpl;

import com.finance.assignment.entity.Role;
import com.finance.assignment.entity.RoleType;
import com.finance.assignment.entity.User;
import com.finance.assignment.repository.RoleRepository;
import com.finance.assignment.repository.UserRepository;
import com.finance.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    public User createUser(User user) {

        // encode password
        user.setPassword(encoder.encode(user.getPassword()));

        // assign default role
        Role role = roleRepo.findByName(RoleType.ROLE_VIEWER)
                .orElseThrow();

        user.setRoles(Set.of(role));

        return userRepo.save(user);
    }
}