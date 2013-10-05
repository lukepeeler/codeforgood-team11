package com.goodwill.getwell;

import com.goodwill.getwell.databasemgr.DataBaseHelper;
import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.content.Context;

public class LoginScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;
	DataBaseHelper helper;
	protected Context context;
	public static User user;
	EditText usernameText, passwordText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		System.out.println("TEST1");
		helper = new DataBaseHelper(context);
		System.out.println("TEST2");
		user = helper.fetchUserByUsername("foo");
		System.out.println("TEST 3");
	}
	private void usernameTextOnClick(View view){
		
	}
	private void passwordTextOnClick(View view){
		
	}
	
}