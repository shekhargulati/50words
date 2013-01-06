package com.fiftywords.utils;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * A utility class for working with {@link Date}
 * 
 * @author shekhargulati
 *
 */
public abstract class DateUtils {

	/**
	 * Add days to date
	 * 
	 * @param date
	 * @param days
	 * @return give date which is days ahead
	 */
	public static Date addDays(Date date, int days){
		DateTime dateTime = new DateTime(date);
		dateTime = dateTime.plusDays(days);
		return dateTime.toDate();
	}
}
