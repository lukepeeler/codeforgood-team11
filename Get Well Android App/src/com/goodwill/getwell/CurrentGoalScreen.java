package com.goodwill.getwell;
import java.util.ArrayList;
import java.util.Calendar;

import com.goodwill.getwell.databasemgr.DataBaseHelper;
import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

 
public class CurrentGoalScreen extends Activity {
 
	final Context context = this;
	ImageButton todaysChallengeButton; 
	Button findFriendsButton;
	TextView time;
	TextView challengeDesc;
	Challenge c;
	DataBaseHelper helper;
	
	
	//Boolean to decide if Challenge was Accepted
	boolean challengeAccepted = false;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.current_goal_screen);
		setUpVars();
	}
	
	private void setUpVars(){
		helper = new DataBaseHelper(context);
		c = helper.fetchDailyChallenge();
		todaysChallengeButton = (ImageButton) findViewById(R.id.todaysChallengeButton);
		findFriendsButton = (Button) findViewById(R.id.findFriendsButton);
		challengeDesc = (TextView) findViewById(R.id.textView1);
		challengeDesc.setText(c.getChallengeName());
		
		//Populate Icon with challenge Type
		String cat = c.getType();
		if(cat.equals("Health")){
			todaysChallengeButton.setBackgroundResource(R.drawable.healthicon);
		}
		else if(cat.equals("Career")){
			todaysChallengeButton.setBackgroundResource(R.drawable.careericon);
		}
		else if(cat.equals("Financial")){
			todaysChallengeButton.setBackgroundResource(R.drawable.financeicon);
		}
		else{
			todaysChallengeButton.setBackgroundResource(R.drawable.socialicon);
		}
		
		
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
				
				final CharSequence[] items = {"Bob", "Mary", "Betty"};

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Choose A Friend");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					//Close Dialog
				    dialog.dismiss();
				    //Get Friend's Name
				    CharSequence f = items[item];    
				    sendMessage(f.toString());
				}
				});
				AlertDialog alert = builder.create();
				alert.show();
				
			}
		});
		
		
		
		//Set the left time
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int timeLeft = 24-hour;
		String timeleft = Integer.toString(timeLeft);
		time = (TextView)findViewById(R.id.time);
		time.setText(timeleft);
	}
	
	//Send a Message
	public void sendMessage(String friend){
		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle("Send "+ friend +" A Message");
		// Set an EditText view to get user input 
		final EditText input = new EditText(this);
		alert.setView(input);

		alert.setPositiveButton("Send", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
		  Editable value = input.getText();
		  // Do something with value!
		  dialog.dismiss();
		  }
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int whichButton) {
		    // Canceled.
			dialog.dismiss();
		  }
		});

		alert.show();
	}
 
	//Override Back Button
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
	        //do your stuff
	    	Intent intent = new Intent(CurrentGoalScreen.this, WelcomeScreen.class);
			CurrentGoalScreen.this.startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	
	public void welcomeOnClick(View view){
		Intent intent = new Intent(CurrentGoalScreen.this, WelcomeScreen.class);
		CurrentGoalScreen.this.startActivity(intent);
				
	}
 
}
