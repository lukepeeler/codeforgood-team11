package com.goodwill.getwell.databasemgr;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;





import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.goodwill.getwell.*;

public class DatabaseManager {
	private static SQLiteConnection db = new SQLiteConnection(new File("/Users/lukepeeler/dev/appdb.db"));

	public DatabaseManager() {
		// TODO: edit path of this database when demoing!!
	}

	public static void addUser(User user) {
		SQLiteStatement st = null;
		try {
			db.open();
			st = db.prepare("INSERT INTO users (username, password, email, fname, lname, age, height_ft, height_in, weight, gender, employee_id) values ('" + user.getUsername() + "', "
					+ "'" + user.getPassword() + "', '" + user.getEmail() + "', '"
					+ user.getFname() + "', '" + user.getLname() + "', "
					+ user.getAge() + ", " + user.getHeightFeet() + ", "
					+ user.getHeightInches() + ", " + user.getWeight() + ", '"
					+ user.getGender() + "', " + user.getEmployeeID() + ");");
			while (st.step()) {
				;
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			st.dispose();
		}
//		db.dispose();
	}

	public static User fetchUserByUsername(String username) {
		SQLiteStatement st = null;
		User user = null;
		try {
			db.open();
			st = db.prepare("SELECT * FROM users WHERE username = '" + username +"'");
			while (st.step()) {
				user = new User(st.columnString(0),
								st.columnString(1),
								st.columnString(2),
								st.columnString(3),
								st.columnString(4),
								st.columnInt(5),
								st.columnInt(6),
								st.columnInt(7),
								st.columnInt(8),
								st.columnString(9).toCharArray()[0],
								st.columnInt(10));
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			st.dispose();
		}
		
		//db.dispose();
		return user;
		
	}
	
	public static ArrayList<Challenge> getUserChallenges(String username)
	{
		SQLiteStatement st = null;
		Date created = null, due = null;
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			db.open();
			st = db.prepare("SELECT * FROM challenge NATURAL JOIN participation WHERE username = '" + username +"';");
			while (st.step()) {
				try {
					created = new SimpleDateFormat("yyyy-MM-dd").parse(st.columnString(4));
					due = new SimpleDateFormat("yyyy-MM-dd").parse(st.columnString(5));
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				Challenge challenge = new Challenge(st.columnInt(0), st.columnString(1), st.columnString(2),
													st.columnInt(3), created, due, st.columnInt(6), st.columnString(7));
				// see if challenge was completed (columnValue?)
				if (st.columnInt(9) == 1){
					challenge.markComplete();
				}
				
				challenges.add(challenge);
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			st.dispose();
		}
		
//		db.dispose();
		return challenges;
	}
	
	public static ArrayList<User> getUserFriends(String username)
	{
		SQLiteStatement st = null;
		ArrayList<User> friends = new ArrayList<User>();
		ArrayList<String> friendNames = new ArrayList<String>();
		try {
			db.open();
			st = db.prepare("SELECT friend_name FROM users NATURAL JOIN friendship WHERE username = '" + username +"';");
			while (st.step()) {
				friendNames.add(st.columnString(0));
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			st.dispose();
		}
		
		//db.dispose();
		
		for (String name : friendNames){
			friends.add(fetchUserByUsername(name));
		}
		return friends;
	}
	
	public static void addFriendToUser(User user, String friendName)
	{
		SQLiteStatement st = null;
		try{
			db.open();
			st = db.prepare("INSERT INTO friendship VALUES ('" + user.getUsername() + "', '" + friendName + "');");
			while(st.step()){
				;
			}
		} catch (SQLiteException e){
			e.printStackTrace();
		} finally {
			st.dispose();
		}
	}
	
	public static void addChallengeToUser(String username, Challenge c)
	{
		SQLiteStatement st = null;
		try{
			db.open();
			st = db.prepare("INSERT INTO participation VALUES (" + c.getChallengeID() + ", '" + username + "', " + 0 + ");");
			while(st.step()){
				;
			}
		} catch (SQLiteException e){
			e.printStackTrace();
		} finally {
			st.dispose();
		}
	}
	
	public static Challenge fetchDailyChallenge()
	{
		Date today = new Date();
		Challenge c = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(today));
		Date created = null, due = null;
		SQLiteStatement st = null;
		try{
			db.open();
			st = db.prepare("SELECT * FROM challenge WHERE date_created = '" + dateFormat.format(today) + "';");
			while(st.step()){
				try {
					created = new SimpleDateFormat("yyyy-MM-dd").parse(st.columnString(4));
					due = new SimpleDateFormat("yyyy-MM-dd").parse(st.columnString(5));
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
					c = new Challenge(st.columnInt(0), st.columnString(1), st.columnString(2),
									  st.columnInt(3), created, due, st.columnInt(6), st.columnString(7));
			}
		} catch (SQLiteException e){
			e.printStackTrace();
		} finally {
			st.dispose();
		}
		
		return c;
	}
		



}
