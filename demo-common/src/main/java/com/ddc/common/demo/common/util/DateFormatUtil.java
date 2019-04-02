package com.ddc.common.demo.common.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {

	public static Date strToDate(String dateStr){
		if(dateStr==null || dateStr.isEmpty()){
			return null;
		}
		SimpleDateFormat df=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	public static String dateToYYYYMMdd(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		return df.format(date);
	}
	public static String dateToString(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	public static Date addDate(Date date,int numberOfDay){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, numberOfDay);
		return c.getTime();
	}
	public static Date addMinute(Date date,int numberOfMinute){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, numberOfMinute);
		return c.getTime();
	}
	
	public static String dateToString(Integer time){
		if (time == null || time <= 0) {
			return null;
		}
		
		return dateToString(new Date(time * 1000L));
	}
	
	public static long minuteBetween(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long between = 0L;
		if (time == null || "".equals(time)) {
			return between;
		}
		
		try {
			Date date = df.parse(time);
			Date now = new Date();

			between = date.getTime() - now.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return between/(60*1000);
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss格式时间转化为时间戳
	 * @param dateStr
	 * @return
	 */
	public static int dateToTimestamp(String dateStr) {
		if (dateStr == null || dateStr.isEmpty()) {
			return 0;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df.parse(dateStr);
			Long timestamp = date.getTime() / 1000;
			return timestamp.intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static Long strToMicroTimestamp(String dateStr) {
		if (dateStr == null || dateStr.isEmpty()) {
			return null;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = df.parse(dateStr);
			return date.getTime() ;
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串转java.sql.Time
	 * @param strTime
	 * @return
	 */
	public static Time strToTime(String strTime) {
		if (strTime == null || strTime.isEmpty()){
			return null;
		}
		strTime += ":00";

		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date d = null;
		try {
			d = format.parse(strTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Time(d.getTime());
	}
}
