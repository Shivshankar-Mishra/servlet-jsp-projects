package com.jsp.one_to_one_uni.service;
/**
 * @author Shivshankar Mishra
 */

import com.jsp.one_to_one_uni.dao.PersonOneToOneDao;
import com.jsp.one_to_one_uni.dto.Adhar;
import com.jsp.one_to_one_uni.dto.Person;

public class PersonAdharService {
	PersonOneToOneDao pd = new PersonOneToOneDao();
	/**
	 * method for insert data 
	 * @param p
	 * @param a
	 * @return Person;
	 */
	public Person insertData(Person p,Adhar a) {
		return pd.insert(p, a);
	}
	/**
	 * method for fetching one data
	 * @param id
	 * @return Person;
	 */
	public Person fetchOneData(int id) {
		return pd.fetch(id);
	}

}
