package com.goodwill.getwell;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class HealthScreen extends Activity{
	
	private String[] challenges;
	TextView currWeight, goalWeight;
	String challenge1;
	String challenge2;
	String challenge3;
	String challenge4;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.health_screen);
		currWeight = (TextView) findViewById(R.id.currWeight);
		currWeight.setText("Current Weight: " + LoginScreen.user.getWeight());
		goalWeight = (TextView) findViewById(R.id.goalWeight);
		goalWeight.setText("Goal Weight: " + LoginScreen.user.getGoalWeight());
		challenge1 = "test1";
		challenge2 = "test2";
		challenge3 = "test3";
		challenge4 = "test4";
		challenges = new String[]{"--choose a challenge--", challenge1, challenge2, challenge3, challenge4};
		Spinner healthSpinner = (Spinner) findViewById(R.id.healthSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(HealthScreen.this, android.R.layout.simple_spinner_item, challenges);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    healthSpinner.setAdapter(adapter);
		
	    healthSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {               
	            if(position != 0)
	            	Toast.makeText(getApplicationContext(), challenges[position], Toast.LENGTH_SHORT).show();
	    	}
	
	        public void onNothingSelected(AdapterView<?> parent) {
	            // TODO Auto-generated method stub
	        }});
		}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
	        //do your stuff
	    	Intent intent = new Intent(HealthScreen.this, WelcomeScreen.class);
			HealthScreen.this.startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	public void welcomeOnClick(View view){
		Intent intent = new Intent(HealthScreen.this, WelcomeScreen.class);
		HealthScreen.this.startActivity(intent);
				
	}
	
	
}
