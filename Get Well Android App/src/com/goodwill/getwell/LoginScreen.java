package com.goodwill.getwell;

import org.apache.http.auth.UsernamePasswordCredentials;

import com.goodwill.getwell.databasemgr.DataBaseHelper;
import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class LoginScreen extends Activity {
	
	int currStreak, currBadges, currNotifications;
	DataBaseHelper helper;
	protected Context context;
	public static User user;
	EditText usernameText, passwordText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		helper = new DataBaseHelper(context);
		usernameText = (EditText) findViewById(R.id.usernameText);
		passwordText = (EditText) findViewById(R.id.passwordText);
	}
	public void usernameTextOnClick(View view){
		usernameText.setText("");
	}
	public void passwordTextOnClick(View view){
		passwordText.setText("");
		
	}
	public void loginBtnOnClick(View view){
		switch(User.login(usernameText.getText().toString(), passwordText.getText().toString()) )
		{	
			case 0:
				user = helper.fetchUserByUsername(usernameText.getText().toString());
				Intent intent = new Intent(LoginScreen.this, WelcomeScreen.class);
				LoginScreen.this.startActivity(intent);
				break;
//			case -1: Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_SHORT).show();
//				break;
//			case -2: Toast.makeText(getApplicationContext(), "Password incorrect", Toast.LENGTH_SHORT).show();
//				break;
		}
	}
	
}