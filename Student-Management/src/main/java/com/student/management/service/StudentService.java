package com.student.management.service;

import java.util.List;

import com.student.management.model.Student;

public interface StudentService {
	
	Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student, long id);

    void deleteStudent(Long id);

}
