package com.goodwill.getwell;

import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SocialScreen extends Activity {
	
	final Context context = this;
	Button addFriendButton;
	private String[] challenges;
	String challenge1;
	String challenge2;
	String challenge3;
	String challenge4;
	
	String friend1;
	String friend2;
	String friend3;
	String friend4;
	String friend5;
	String friend6;
	String friend7;
	String[] FRIENDS;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social_screen);
		challenge1 = "Goal 1";
		challenge2 = "Goal 2";
		challenge3 = "Goal 3";
		challenge4 = "Goal 4";
		challenges = new String[]{"--Your Social Goals--", challenge1, challenge2, challenge3, challenge4};
		Spinner socialSpinner = (Spinner) findViewById(R.id.socialSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(SocialScreen.this, android.R.layout.simple_spinner_item, challenges);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    socialSpinner.setAdapter(adapter);
		
	    socialSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {               
	            if(position != 0)
	            	Toast.makeText(getApplicationContext(), challenges[position], Toast.LENGTH_SHORT).show();
	    	}
	
	        public void onNothingSelected(AdapterView<?> parent) {
	            // TODO Auto-generated method stub
	        }});
	    
	    friend1 = "Bob";
	    friend2 = "You!";
	    friend3 = "Mary";
	    friend4 = "Betty";
	    friend5 = "Karl";
	    friend6 = "Hannah";
	    friend7 = "Jenna";
	    FRIENDS = new String[] { friend1,friend2,friend3,friend4,friend5,friend6,friend7 };
	    
	    final ListView lv = (ListView) findViewById(R.id.friendList);
	    
	    ArrayAdapter<String> fadapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, FRIENDS);
	    
	    lv.setAdapter(fadapter);
	    lv.setOnItemClickListener(new OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  itemValue    = (String) lv.getItemAtPosition(position);
                
              // Show Alert 
              Toast.makeText(getApplicationContext(),
                "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                .show();
           
            }

        });
	    
	    addFriendButton = (Button) findViewById(R.id.addFriendButton);
	    
	    addFriendButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//Show Multiple Choice Dialog Box

				
			}
		});
	    

	    		
	    
	    
	    
	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
	        //do your stuff
	    	Intent intent = new Intent(SocialScreen.this, WelcomeScreen.class);
			SocialScreen.this.startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
}
