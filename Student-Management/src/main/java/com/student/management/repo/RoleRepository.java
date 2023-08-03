package com.student.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
