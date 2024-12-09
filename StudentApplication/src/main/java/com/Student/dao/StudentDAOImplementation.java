 package com.Student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Student.connector.ConnectionFactory;
import com.Student.dto.Student;

public class StudentDAOImplementation implements StudentDAO {

	private Connection con;
	private Student s;	

//	whenever an object of this class is created, con obj is returned
//	to make con global(common for all the members present in class)
    public StudentDAOImplementation() {
		this.con = ConnectionFactory.requestConnection();;
	 }

	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps = null;
	    int res1 =0;
	    String query = "INSERT INTO STUDENT1 VALUES(0,?,?,?,?,?,?,SYSDATE())";
	    try {
	    	con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			
//			res stores value of whether the data is inserted or not
		    res1 = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    if(res1>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps = null;
		String query = "UPDATE STUDENT1 SET NAME=?,PHONE=?,MAILID=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?";
		int res =0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    return false;
		}
	}

	@Override
	public boolean deleteStudent(Student s) {
		PreparedStatement ps = null;
	    int res2 =0;
		String query = "DELETE FROM STUDENT1 WHERE ID=?";
		
		try {
			ps=con.prepareStatement(query);

			ps.setInt(1, s.getId());
			
			res2 = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(res2>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Student getStudent(String mailid, String pass) {
		String query = "SELECT * FROM STUDENT1 WHERE MAILID=? AND PASSWORD=?";
		Student s = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1,mailid);
			ps.setString(2,pass);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));	
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public List<Student> getStudent() {
		ArrayList<Student> students = new ArrayList<>();
		Student s = null;
		String query = "SELECT * FROM STUDENT1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getStudent(Long phone, String mail) {
		
		String query = "SELECT * FROM STUDENT1 WHERE PHONE=? AND MAILID=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setLong(1, phone);
			ps.setString(2, mail);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
