package com.jsp.one_to_one_uni.dto;
/**
 * @author Shivshankar Mishra
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	private String gender;

	@OneToOne
	@JoinColumn(name="adharid")
	private Adhar adhar;
}
