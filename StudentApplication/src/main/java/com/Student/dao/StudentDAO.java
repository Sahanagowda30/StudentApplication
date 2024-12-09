package com.Student.dao;

import java.util.List;

import com.Student.dto.Student;

public interface StudentDAO {


	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mailid, String pass);
	public Student getStudent(Long phone, String mail);
	public List<Student> getStudent();
	
}
