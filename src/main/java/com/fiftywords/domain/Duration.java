package com.fiftywords.domain;

/**
 * The duration for which challenge will last.
 * 
 * @author shekhargulati
 *
 */
public enum Duration {

	SEVEN_DAYS(7,"7 Days"),THIRTY_DAYS(30,"30 Days"),NINETY_DAYS(90,"90 Days"),ONE_HUNDRED_EIGHTY_DAYS(180,"180 Days"),THREE_HUNDRED_SIXTY_FIVE_DAYS(365,"365 Days");
	
	private int days;
	private String text;

	Duration(int days,String text){
		this.days = days;
		this.text = text;
	}
	
	public int getDays() {
		return days;
	}
	
	public String getText() {
		return text;
	}
	
}
