package com.goodwill.getwell;

import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LoginScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;

	public static User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		user = DatabaseManager.fetchUserByUsername("foo");
	}
	
}