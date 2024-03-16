package com.jsp.one_to_one_uni.dto;

import java.time.LocalDate;

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
@NoArgsConstructor
@AllArgsConstructor
public class Adhar {
	@Id
	private long number;
	private String address;
	private LocalDate dob;
	private String fatherName;

}
