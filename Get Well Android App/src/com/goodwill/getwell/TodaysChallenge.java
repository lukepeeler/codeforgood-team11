package com.goodwill.getwell;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TodaysChallenge extends Activity {
	
	Button acceptButton, declineButton;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todays_challenge);
		setUpVars();
	}
	
	private void setUpVars(){
		acceptButton = (Button) findViewById(R.id.acceptButton);
		declineButton = (Button) findViewById(R.id.declineButton);
		
		//If Accept Pressed Go Back to Challenge Screen, add timer
		acceptButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(TodaysChallenge.this, CurrentGoalScreen.class);
				TodaysChallenge.this.startActivity(intent);
				
			}
		});
		
		//If Decline Pressed Open Dialog and Offer Choice
		declineButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(TodaysChallenge.this, CurrentGoalScreen.class);
				TodaysChallenge.this.startActivity(intent);
				
			}
		});
	}
	
	
	
	
	
	
}