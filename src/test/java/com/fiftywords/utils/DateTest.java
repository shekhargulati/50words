package com.fiftywords.utils;

import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;

public class DateTest {

	@Test
	public void jodaLibraryTest() {
		DateTime dateTime = new DateTime();
		int monthOfYear = dateTime.getMonthOfYear();
		System.out.println(monthOfYear);
		System.out.println(dateTime);

		dateTime = dateTime.plusDays(10);

		System.out.println(dateTime);

		dateTime = new DateTime();
		String monthAsText = dateTime.monthOfYear().getAsText();
		System.out.println(monthAsText);
		String italyMonth = dateTime.monthOfYear().getAsText(Locale.ITALY);
		System.out.println(italyMonth);
		boolean isLeap = dateTime.year().isLeap();
		System.out.println(isLeap);

		Chronology coptic = CopticChronology.getInstance();
		System.out.println(coptic);

		DateTimeZone dateTimeZone = DateTimeZone.forID("Asia/Tokyo");
		Chronology gregorianJuian = GJChronology.getInstance(dateTimeZone);

		System.out.println(gregorianJuian);

		Interval interval = new Interval(10, 20);
		System.out.println(interval);

		DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
		System.out.println(dt);
		DateTime plusPeriod = dt.plus(Period.days(1));
		System.out.println(plusPeriod);
		DateTime plusDuration = dt.plus(new Duration(24L * 60L * 60L * 1000L));
		System.out.println(plusDuration);
		
	}
}
