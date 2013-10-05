package com.goodwill.getwell;

import java.util.ArrayList;

import com.goodwill.getwell.databasemgr.DataBaseHelper;
import android.content.Context;

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
	private int goalWeight;
	private char gender;
	private int employeeID;
	private ArrayList<User> friends;
	private ArrayList<Challenge> challengesAccepted = new ArrayList<Challenge>();
	private int totalScore;
	private int currentStreak;
	private static Context context;
	private static DataBaseHelper helper = new DataBaseHelper(context);
	
	// "signup" constructor
	public User(String username, String password, String email, String fname, String lname,
				int age, int heightFeet, int heightInches, int weight, char gender, int employeeID, int goalWeight)
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
		this.goalWeight = goalWeight;
		
		// push data to database
	}
	
	
	// "login" and return 0 if OK, -1 if user not found, -2 if incorrect password
	public static int login(String username, String password)
	{
		User user = helper.fetchUserByUsername(username);
		if (user == null){
			return -1;
		}
		if (user.getPassword().equals(password)){
			return 0;
		} else{
			return -2;
		}
	}
	
	// to be called after login info is verified using method above
	public static User fetchUserAfterLogin(String username)
	{
		User user = helper.fetchUserByUsername(username);
		return user;
	}
	
	public int getGoalWeight()
	{
		return goalWeight;
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
		// update age in DB
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
		// update weight in DB
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
	
	public ArrayList<User> getUserFriends()
	{
		this.friends = helper.getUserFriends(username);
		return friends;
	}
	
	public ArrayList<Challenge> getUserChallenges()
	{
		this.challengesAccepted = helper.getUserChallenges(username);
		return challengesAccepted;
	}
	
	public void addChallenge(Challenge c)
	{
		helper.addChallengeToUser(username, c);
	}
	
	public void addDailyChallenge()
	{
		helper.addChallengeToUser(username, helper.fetchDailyChallenge());
	}
	
	public int getScore()
	{
		ArrayList<Challenge> challenges = helper.getUserChallenges(username);
		int score = 0;
		for (Challenge c : challenges){
			if (c.isComplete()){
				score += c.getChallengePoints();
			}
		}
		
		this.totalScore = score;
		return score;
	}
	
	public void submitChallenge()
	{
		
	}
	

	
	
}
