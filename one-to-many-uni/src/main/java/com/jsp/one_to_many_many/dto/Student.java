package com.jsp.one_to_many_many.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shivshankar Mishra
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	private String gender;
	private long phone;
}
