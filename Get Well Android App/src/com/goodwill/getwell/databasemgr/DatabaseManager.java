package com.goodwill.getwell.databasemgr;

import java.io.File;
import com.goodwill.getwell.*;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.table.SqlJetDb;



public class DatabaseManager {
	private String dbname = "appdb.db";
	private File dbFile = new File(dbname);
	private SqlJetDb db;
	
	public DatabaseManager()
	{
		try{
			db = SqlJetDb.open(dbFile, true);
		} catch (SqlJetException e){
			e.printStackTrace();
		}
	}
	
	public void addUser(User user)
	{
		
	}
	
	

}
