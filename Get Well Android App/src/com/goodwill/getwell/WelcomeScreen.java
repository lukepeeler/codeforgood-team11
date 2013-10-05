package com.goodwill.getwell;

import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class WelcomeScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;
	User user;
	Challenge c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		c = DatabaseManager.fetchDailyChallenge();
		user = LoginScreen.user;
	}
	
	public void currGlobalBtnOnClick(View view){
		Intent intent = new Intent(WelcomeScreen.this, CurrentGoalScreen.class);
		WelcomeScreen.this.startActivity(intent);
				
	}
	
	public void healthBtnOnClick(View view){
		Intent intent = new Intent(WelcomeScreen.this, HealthScreen.class);
		WelcomeScreen.this.startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_screen, menu);
		return true;
	}
}
