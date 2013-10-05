package com.goodwill.getwell.databasemgr;

import java.io.File;



import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.goodwill.getwell.*;

public class DatabaseManager {
	private SQLiteConnection db;

	public DatabaseManager() {
		// TODO: edit path of this database when demoing!!
		db = new SQLiteConnection(new File("/Users/lukepeeler/dev/appdb.db"));
	}

	public void addUser(User user) {
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
		db.dispose();
	}

	public User fetchUserByUsername(String username) {
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
		
		db.dispose();
		return user;
		
	}
		



}
