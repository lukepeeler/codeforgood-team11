package com.goodwill.getwell;

public class functions {

	/**
	 * @param args
	 */
	public static double calculateBMI(double height, double weight)
	{
		return (weight/(height*height))*703;
	}
	public static void updateUserScoreAndBadge(int totalScore)
	{
		//put the totalScore and the badge into the data base;
	}
	/*public static String getBadge(int totalScore)
	{
		if(totalScore/10==0)
		{
			return "10th";
		}
		else if(totalScore/10==1)
		{
			return "9th";
		}
		else if(totalScore/10==2)
		{
			return "8th";
		}
		else if(totalScore/10==3)
		{
			return "7th";
		}
		else if(totalScore%10==4)
		{
			return "6th";
		}
		else if(totalScore/10==5)
		{
			return "5th";
		}
		else if(totalScore/10==6)
		{
			return "4th";
		}
		else if(totalScore/10==7)
		{
			return "3rd";
		}
		else if(totalScore/10==8)
		{
			return "2nd";
		}
		else if(totalScore/10==9)
		{
			return "1st";
		}
	}*/
	public static int getScore(int score, String challange)
	{
		int total=10;//note this is a tempary value;
		//this function needs to go into the database and get the updated goal
		total=total+score;
		return total;
	}
	public static int calcScoreForSession(boolean CompletedGoal)
	{
		if(CompletedGoal==true)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}

}
