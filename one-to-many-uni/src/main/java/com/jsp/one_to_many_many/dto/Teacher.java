package com.jsp.one_to_many_many.dto;
/**
 * @author Shivshankar Mishra
 */

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	
	@OneToMany
	private List<Student> student;
}
