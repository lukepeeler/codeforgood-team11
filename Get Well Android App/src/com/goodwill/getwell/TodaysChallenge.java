package com.goodwill.getwell;
import com.goodwill.getwell.databasemgr.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

public class TodaysChallenge extends Activity {
	TextView chalCat, chalDesc, chalTip;
	Button acceptButton, declineButton;
	DataBaseHelper helper;
	private Context context;
	Challenge c;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		helper = new DataBaseHelper(context);
		setContentView(R.layout.todays_challenge);
		setUpVars();
	}
	
	private void setUpVars(){
		c = helper.fetchDailyChallenge();
		acceptButton = (Button) findViewById(R.id.acceptButton);
		declineButton = (Button) findViewById(R.id.declineButton);
		
		chalCat = (TextView) findViewById(R.id.chalCat);
		chalDesc = (TextView) findViewById(R.id.chalDesc);
		chalTip = (TextView) findViewById(R.id.chalTip);
		chalCat.setText(c.getType());
		chalDesc.setText(c.getChallengeName());
		chalTip.setText(c.getChallengeDesc());
		
		
		
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
	
	//Override Back Button
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
	        //do your stuff
	    	Intent intent = new Intent(TodaysChallenge.this, CurrentGoalScreen.class);
			TodaysChallenge.this.startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	
}