package com.radiantshub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFormatUtil {

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @param timeUnit
	 * @return
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	public static String getNotificationDate(Date date){
		Date todaysDate = new Date();
		String result="";
		if(todaysDate.compareTo(date)>0){
			long diff=Math.abs(todaysDate.getTime()-date.getTime());
			int hours=(int)Math.abs(diff/(1000*60*60));
			int mins=(int)Math.abs(diff/(1000*60));
			int sec=(int)Math.abs(diff/(1000));
			if(hours>24){
				result=formatDateToString(date, "dd-MMMM-yyyy");
			}
			else if(hours>0){
				result=hours+" hours ago";
			}
			else if(mins>0)
				result=mins+" minutes ago";
			else if(sec>0){
				result=sec+" seconds ago";
			}
		}
		return result;
	}
	
	/**
	 * Format date to date.
	 *
	 * @param date the date
	 * @param formatStyle the format style
	 * @return the date
	 */
	public static Date formatDateToDate(String date, String formatStyle) {
        Date formattedDate = null;
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(formatStyle);
            try {
				formattedDate = format.parse(date);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
        }
        return formattedDate;
    }
	
	/**
	 * Format date to string.
	 *
	 * @param date the date
	 * @param formatStyle the format style
	 * @return the string
	 */
	public static String formatDateToString(Date date, String formatStyle) {
        String formattedDate = null;
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(formatStyle);
            formattedDate = format.format(date);
        }
        return formattedDate;
    }
	
	

}
