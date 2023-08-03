package com.student.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
