package com.goodwill.getwell;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

 
public class CurrentGoalScreen extends Activity {
 
	ImageButton todaysChallengeButton;
	Button findFriendsButton;
	
	//Boolean to decide if Challenge was Accepted
	boolean challengeAccepted = false;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.current_goal_screen);
		setUpVars();
	}
	
	private void setUpVars(){
		todaysChallengeButton = (ImageButton) findViewById(R.id.todaysChallengeButton);
		findFriendsButton = (Button) findViewById(R.id.findFriendsButton);
		
		//If $ Button pressed, go to description
		todaysChallengeButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(CurrentGoalScreen.this, TodaysChallenge.class);
				CurrentGoalScreen.this.startActivity(intent);
				
			}
		});
		
		
	}
 
	
	
	
 
}
