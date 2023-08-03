package com.student.management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="students")
public class Student {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String course;
	
	private String country;

}
