package com.finance.assignment.config;

import com.finance.assignment.entity.Role;
import com.finance.assignment.entity.RoleType;
import com.finance.assignment.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {

            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(RoleType.ROLE_ADMIN));
                roleRepository.save(new Role(RoleType.ROLE_ANALYST));
                roleRepository.save(new Role(RoleType.ROLE_VIEWER));
            }
        };
    }
}