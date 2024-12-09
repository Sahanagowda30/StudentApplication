package com.Student.dto;

public class Student {
	
			 private int id;
			 private String name;
			 private long phone;
			 private String mailid;
			 private String branch;
			 private String location;
			 private String password;
			 private String date;
			 
			// respective getter and setter methods
			 public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public long getPhone() {
				return phone;
			}
			public void setPhone(long phone) {
				this.phone = phone;
			}
			public String getMailid() {
				return mailid;
			}
			public void setMailid(String mailid) {
				this.mailid = mailid;
			}
			public String getBranch() {
				return branch;
			}
			public void setBranch(String branch) {
				this.branch = branch;
			}
			public String getLocation() {
				return location;
			}
			public void setLocation(String location) {
				this.location = location;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}

			@Override
			public String toString() {
				return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", mailid=" + mailid + ", branch=" + branch
						+ ", location=" + location + ", date=" + date + "]";
			}

}
