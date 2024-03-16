package com.jsp.one_to_one_bi.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adhar {
	private long number;
	private String gender;
	private String address;
	private String fathername;
	@OneToOne(mappedBy = "adhar")
	private Person person;

}
