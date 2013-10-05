package com.goodwill.getwell;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

public class SocialScreen extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social_screen);
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
	
	public void welcomeOnClick(View view){
		Intent intent = new Intent(SocialScreen.this, WelcomeScreen.class);
		SocialScreen.this.startActivity(intent);
				
	}
	
}
