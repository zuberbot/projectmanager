/**
 * MyProjectsUtility
 */
package com.myprojects.web.utility;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Chuck
 *
 */
public class MyProjectsUtility {

	/**
	 * 
	 * @return
	 */
	public static String getCurrentMySQLDate() {
		long time = System.currentTimeMillis();
		DateFormat dateFormat = new SimpleDateFormat(IProject.DATE_TIME_FORMAT);
		Date date = new Date(time);
		return dateFormat.format(date);
	}
	
	/**
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static String truncateMSFromDateString(String dateTimeString) {
		int idx = dateTimeString.lastIndexOf(IProject.PERIOD);
		dateTimeString = dateTimeString.substring(0, idx);
		return dateTimeString;
	}

}
