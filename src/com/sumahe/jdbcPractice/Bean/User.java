package com.sumahe.jdbcPractice.Bean;

public class User {
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	String Id;
	String Code;
	String Name;
	String Password;
}
