package com.goodwill.getwell.databasemgr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.almworks.sqlite4java.SQLiteStatement;
import com.goodwill.getwell.Challenge;
import com.goodwill.getwell.User;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	 
    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.goodwill.getwell/databases/";
 
    private static String DB_NAME = "appdb.db";
 
    private SQLiteDatabase myDataBase; 
 
    private final Context myContext;
 
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {
 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }	
 
  /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{
 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){
    		//do nothing - database already exist
    	}else{
 
    		//By calling this method and empty database will be created into the default system path
               //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
 
        	try {
 
    			copyDataBase();
 
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
 
    }
 
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
 
    		//database does't exist yet.
 
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
 
    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public void openDataBase() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	
 
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
 
        // Add your public helper methods to access and get content from the database.
       // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
       // to you to create adapters for your views.
	
	public User fetchUserByUsername(String username) 
	{
		User user = null;
		try {
			openDataBase();
			Cursor cursor = myDataBase.rawQuery(
					"SELECT * FROM users WHERE _id = '" + username + "'", null);
			if (cursor != null) {
				while (cursor.moveToNext()) {
					user = new User(cursor.getString(0), cursor.getString(1),
							cursor.getString(2), cursor.getString(3),
							cursor.getString(4), cursor.getInt(5),
							cursor.getInt(6), cursor.getInt(7),
							cursor.getInt(8),
							cursor.getString(9).toCharArray()[0],
							cursor.getInt(10));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}
	
	public Challenge fetchDailyChallenge()
	{
		Date today = new Date();
		Challenge c = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date created = null, due = null;
		try{
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("SELECT * FROM challenge WHERE date_created = '" + dateFormat.format(today) + "'", null);
			if (cursor != null) {
				while (cursor.moveToNext()) {
					try {
						created = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(4));
						due = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(5));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}
					c = new Challenge(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
							  cursor.getInt(3), created, due, cursor.getInt(6), cursor.getString(7));
				}

			}
			
		} catch (SQLiteException e){
			e.printStackTrace();
		}
		
		return c;
	}
	
	public void addChallengeToUser(String username, Challenge c)
	{
		try{
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("INSERT INTO participation VALUES (" + c.getChallengeID() + ", '" + username + "', " + 0 + ")", null);
			while (cursor.moveToNext()){
				;
			}
		} catch (SQLiteException e){
			e.printStackTrace();
		}
	}
	
	public void addFriendToUser(User user, String friendName)
	{
		try{
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("INSERT INTO friendship VALUES ('" + user.getUsername() + "', '" + friendName + "')", null);
			while(cursor.moveToNext()){
				;
			}
		} catch (SQLiteException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> getUserFriends(String username)
	{

		ArrayList<User> friends = new ArrayList<User>();
		ArrayList<String> friendNames = new ArrayList<String>();
		try {
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("SELECT friend_name_id FROM friendship WHERE username_id = '" + username + "'", null);
			while (cursor.moveToNext()){
				friendNames.add(cursor.getString(0));
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
		
		
		for (String name : friendNames){
			friends.add(fetchUserByUsername(name));
		}
		return friends;
	}
	
	public ArrayList<Challenge> getUserChallenges(String username)
	{
		Date created = null, due = null;
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("SELECT * FROM challenge, participation WHERE username = '" + username +"' AND challenge._id = participation.challenge_id", null);
			while (cursor.moveToNext()) {
				try {
					created = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(4));
					due = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(5));
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				Challenge challenge = new Challenge(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
													cursor.getInt(3), created, due, cursor.getInt(6), cursor.getString(7));
				// see if challenge was completed (columnValue?)
				if (cursor.getInt(9) == 1){
					challenge.markComplete();
				}
				
				challenges.add(challenge);
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} 

		return challenges;
	}
	
	public ArrayList<Challenge> getChallengesByType(String type)
	{
		Date created = null, due = null;
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			openDataBase();
			Cursor cursor = myDataBase.rawQuery("SELECT * FROM challenge WHERE category = '" + type + "'", null);
			while (cursor.moveToNext()) {
				try {
					created = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(4));
					due = new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(5));
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				Challenge challenge = new Challenge(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
													cursor.getInt(3), created, due, cursor.getInt(6), cursor.getString(7));

				challenges.add(challenge);
			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		} 

		return challenges;
	}
 
}