package com.fiftywords.utils;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void shouldAddDays(){
		Date date = new Date();
		DateTime now = new DateTime(date);
		int nowDays = now.dayOfYear().get();
		Date tenDaysAhead = DateUtils.addDays(date, 10);
		
		DateTime dateTime = new DateTime(tenDaysAhead);
		int tenDays = dateTime.dayOfYear().get();
		
		assertEquals(10, (tenDays-nowDays));
	}
}
