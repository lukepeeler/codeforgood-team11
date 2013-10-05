package com.goodwill.getwell.databasemgr;

import junit.framework.TestCase;

import com.goodwill.getwell.*;

public class DatabaseManagerTest2 extends TestCase {
	
	
	public void testConnect(){
		DatabaseManager dbm = new DatabaseManager();
		
		User user = new User("foo2", "bar", "fooATbar", "bla", "bla",
				0,
				0,
				0,
				0,
				'c',
				0);
		dbm.addUser(user);
	}
}