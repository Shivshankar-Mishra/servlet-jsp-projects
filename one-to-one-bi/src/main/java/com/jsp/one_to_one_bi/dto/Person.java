package com.jsp.one_to_one_bi.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	@Id
	private int  id;
	private String name;
	private String email;
	private long phone;
	@OneToOne
	private Adhar adhar;

}
