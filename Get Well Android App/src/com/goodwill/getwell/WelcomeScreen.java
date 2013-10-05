package com.goodwill.getwell;

import com.goodwill.getwell.databasemgr.DataBaseHelper;
import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.content.Context;

public class WelcomeScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;
	User user;
	Challenge c;
	DataBaseHelper helper;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		helper = new DataBaseHelper(context);
		c = helper.fetchDailyChallenge();
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
	
	public void moneyBtnOnClick(View view){
		Intent intent = new Intent(WelcomeScreen.this, FinanceScreen.class);
		WelcomeScreen.this.startActivity(intent);
	}
	
	public void socialBtnOnClick(View view){
		Intent intent = new Intent(WelcomeScreen.this, SocialScreen.class);
		WelcomeScreen.this.startActivity(intent);
	}
	
	public void careerBtnOnClick(View view){
		Intent intent = new Intent(WelcomeScreen.this, CareerScreen.class);
		WelcomeScreen.this.startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_screen, menu);
		return true;
	}
}
