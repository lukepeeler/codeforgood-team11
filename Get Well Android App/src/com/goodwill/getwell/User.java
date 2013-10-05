package com.goodwill.getwell;

public class User {
	private String username;
	private String password;
	private String email;
	private String fname;
	private String lname;
	private int age;
	private int heightFeet;
	private int heightInches;
	private int weight;
	private char gender;
	private int employeeID;
	
	public User(String username, String password, String email, String fname, String lname,
				int age, int heightFeet, int heightInches, int weight, char gender, int employeeID)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.heightFeet = heightFeet;
		this.heightInches = heightInches;
		this.weight = weight;
		this.gender = gender;
		this.employeeID = employeeID;
	}
	
	
}
