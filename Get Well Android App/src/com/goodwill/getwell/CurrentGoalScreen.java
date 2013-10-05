package com.goodwill.getwell;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

 
public class CurrentGoalScreen extends Activity {
 
	private static final int DIALOG_DESC = 0;
	private static final int DIALOG_FIND_FRIEND = 1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_goal_screen);
	}
 
	public void openDescription(View view) {
	    // Do something in response to button click
		showDialog(DIALOG_DESC);
	}
	
	public void findFriend(View view) {
	    // Do something in response to button click
		showDialog(DIALOG_FIND_FRIEND);
	}
	
	@Override
	  protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case DIALOG_DESC:
		    // Create out AlterDialog
		    Builder builder = new AlertDialog.Builder(this);
		    builder.setTitle("Today's Goal");
		    builder.setMessage("Find as much change as you can around your house and put it in a jar.");
		    builder.setCancelable(true);
		    builder.setNegativeButton("Close", new CloseOnClickListener());
		    AlertDialog dialog = builder.create();
		    dialog.show();
		    break;
	    //case DIALOG_FIND_FRIEND:
	    	
	    }
	    return super.onCreateDialog(id);
	  }
	
	private final class CloseOnClickListener implements
    	DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which) {
			dialog.dismiss();
		}
	}
	
 
}
