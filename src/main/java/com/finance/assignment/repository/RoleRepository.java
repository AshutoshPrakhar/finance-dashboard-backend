package com.finance.assignment.repository;

import com.finance.assignment.entity.Role;
import com.finance.assignment.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
