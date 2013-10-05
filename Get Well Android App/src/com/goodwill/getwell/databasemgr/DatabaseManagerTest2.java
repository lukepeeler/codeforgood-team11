package com.goodwill.getwell.databasemgr;

import java.util.ArrayList;

import junit.framework.TestCase;

import android.content.Context;

import com.goodwill.getwell.*;

public class DatabaseManagerTest2 extends TestCase {
	
	
	public void testConnect(){
		DatabaseManager dbm = new DatabaseManager();
		
//		User user = new User("foo3", "bar", "fooATbar", "bla", "bla",
//				0,
//				0,
//				0,
//				0,
//				'c',
//				0);
//		dbm.addUser(user);
	}
	
	public void testFetchUser(){
		DataBaseHelper helper = new DataBaseHelper(null);
		helper.fetchUserByUsername("foo");
	}
	
}