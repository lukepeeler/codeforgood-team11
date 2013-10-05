package com.goodwill.getwell;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;
	Button streakBtn, badgesBtn, notificationsBtn, moneyBtn, careerBtn, socialBtn, healthBtn, currGlobalBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		setUpVars();
	}
	
	private void setUpVars(){
		streakBtn = (Button) findViewById(R.id.streakBtn);
		badgesBtn = (Button) findViewById(R.id.badgesBtn);
		notificationsBtn = (Button) findViewById(R.id.notificationsBtn);
		moneyBtn = (Button) findViewById(R.id.moneyBtn);
		careerBtn = (Button) findViewById(R.id.careerBtn);
		socialBtn = (Button) findViewById(R.id.socialBtn);
		healthBtn = (Button) findViewById(R.id.healthBtn);
		currGlobalBtn = (Button) findViewById(R.id.currGlobalBtn);
		
		currGlobalBtn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_screen, menu);
		return true;
	}
}
