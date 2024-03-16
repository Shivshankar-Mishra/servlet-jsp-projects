package com.jsp.one_to_many_many.service;
/**
 * @author Shivshankar Mishra
 */

import java.util.List;

import com.jsp.one_to_many_many.dao.TeacherStudentDao;
import com.jsp.one_to_many_many.dto.Student;
import com.jsp.one_to_many_many.dto.Teacher;

public class TeacherStudentService {
	TeacherStudentDao tsd = new TeacherStudentDao();
	public Teacher insertData(Teacher t) {
		return tsd.insert(t);
	}
	public List<Teacher> fetchAllData(){
		return tsd.fetchAll();
	}
	public Teacher fetchOneData(int id) {
		return tsd.fetchOne(id);
	}
	public Student fetchOneStudent(int tid, int sid) {
		return tsd.fetchStudent(tid, sid);
	}
	public Teacher updateTeacherData(Teacher t) {
		return tsd.updateTeacher(t);
	}
	public void deleteTeacherData(int id) {
		tsd.deleteTeacher(id);
	}

}
