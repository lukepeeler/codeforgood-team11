package com.goodwill.getwell;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

 
public class CurrentGoalScreen extends Activity {
 
	ImageButton todaysChallengeButton; 
	Button findFriendsButton;
	TextView time;
	TextView challengeDesc;
	Challenge c;
	
	//Boolean to decide if Challenge was Accepted
	boolean challengeAccepted = false;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.current_goal_screen);
		setUpVars();
	}
	
	private void setUpVars(){
		c = DatabaseManager.fetchDailyChallenge();
		todaysChallengeButton = (ImageButton) findViewById(R.id.todaysChallengeButton);
		findFriendsButton = (Button) findViewById(R.id.findFriendsButton);
		challengeDesc = new (TextView) findFriendsButton(R.id.textView1);
		challengeDesc.setText(c.getChallengeName());
		//If $ Button pressed, go to description
		todaysChallengeButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(CurrentGoalScreen.this, TodaysChallenge.class);
				CurrentGoalScreen.this.startActivity(intent);
				
			}
		});
		
		findFriendsButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//Show Multiple Choice Dialog Box

				
			}
		});
		
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int timeLeft = 24-hour;
		
		
		
		
		
	}
 
	
	
	
 
}
