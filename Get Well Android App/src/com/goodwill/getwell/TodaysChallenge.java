package com.goodwill.getwell;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodaysChallenge extends Activity {
	TextView chalCat, chalDesc, chalTip;
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
		
		chalCat = (TextView) findViewById(R.id.chalCat);
		chalDesc = (TextView) findViewById(R.id.chalDesc);
		chalTip = (TextView) findViewById(R.id.chalTip);
		CharSequence chalCategory = "financial wellness";
		chalCat.setText(chalCategory);
		CharSequence chalDescription = "Find as much change as you can around your house and put it in a jar.";
		chalDesc.setText(chalDescription);
		CharSequence challTip = "PRO TIP - On Average, setting aside small change daily can add up to $50 a month!";
		chalTip.setText(challTip);
		
		
		
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