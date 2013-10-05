package com.goodwill.getwell;

import java.util.Date;

public class Challenge {
	private int challengeID;
	private String challengeName;
	private String challengeDesc;
	private int challengePoints;
	private Date dateCreated;
	private Date dateDue;
	private boolean isComplete;
	private String type;
	
	public Challenge(int challengeID, String challengeName, String challengeDesc,
					 int challengePoints, Date dateCreated, Date dateDue, String type)
	{
		this.challengeID = challengeID;
		this.challengeName = challengeName;
		this.challengeDesc = challengeDesc;
		this.challengePoints = challengePoints;
		this.dateCreated = dateCreated;
		this.dateDue = dateDue;
		this.isComplete = false;
		this.type = type;
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isComplete()
	{
		return isComplete;
	}
	
	public void markComplete()
	{
		this.isComplete = true;
	}
	
	public int getChallengeID() {
		return challengeID;
	}
	public void setChallengeID(int challengeID) {
		this.challengeID = challengeID;
	}
	public String getChallengeName() {
		return challengeName;
	}
	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}
	public String getChallengeDesc() {
		return challengeDesc;
	}
	public void setChallengeDesc(String challengeDesc) {
		this.challengeDesc = challengeDesc;
	}
	public int getChallengePoints() {
		return challengePoints;
	}
	public void setChallengePoints(int challengePoints) {
		this.challengePoints = challengePoints;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateDue() {
		return dateDue;
	}
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}
	
	
}
