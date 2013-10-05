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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeightFeet() {
		return heightFeet;
	}

	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}

	public int getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
}
