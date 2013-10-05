package com.goodwill.getwell.databasemgr;

import java.util.ArrayList;

import junit.framework.TestCase;

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
		DatabaseManager dbm = new DatabaseManager();
		dbm.fetchUserByUsername("foo2");
	}
	
	public void testGetChallenges(){
		DatabaseManager dbm = new DatabaseManager();
		ArrayList<Challenge> fooChallenges = dbm.getUserChallenges("foo");
		for (Challenge c : fooChallenges){
			System.out.println(c.getChallengeID() + "\t" + c.getChallengeName() + "\t" + c.getChallengeDesc() + "\t" + c.getChallengePoints() + "\t" + c.getDateCreated() + "\t" + c.getDateDue() + "\t" + c.isComplete());
		}
	}
	
	public void testGetFriends(){
		DatabaseManager dbm = new DatabaseManager();
		ArrayList<User> friends = dbm.getUserFriends("foo");
		for (User friend : friends){
			System.out.println(friend.getUsername());
		}
		
		dbm.addFriendToUser(dbm.fetchUserByUsername("foo"), "foo4");
		
		friends = dbm.getUserFriends("foo");
		for (User friend : friends){
			System.out.println(friend.getUsername());
		}
		
		DatabaseManager.fetchDailyChallenge();
 	}
}