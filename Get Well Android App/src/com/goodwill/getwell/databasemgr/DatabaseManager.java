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
		db = new SQLiteConnection(new File("../../../../../../appdb.db"));
	}

	public void addUser(User user) {
		SQLiteStatement st = null;
		try {
			db.open(true);
			st = db.prepare("INSERT INTO users (" + user.getUsername() + ", "
					+ user.getPassword() + ", " + user.getEmail() + ", "
					+ user.getFname() + ", " + user.getLname() + ", "
					+ user.getAge() + ", " + user.getHeightFeet() + ", "
					+ user.getHeightInches() + ", " + user.getWeight() + ", "
					+ user.getGender() + ", " + user.getEmployeeID() + ");");
			while (st.step()) {
				;
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			st.dispose();
		}
	}

	public User fetchUserByUsername(String username) {
		return null;
	}

	public static void main(String[] args) {
		DatabaseManager dbm = new DatabaseManager();
	}

}
