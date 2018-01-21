package com.pine.common.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.pine.common.io.LoggerUtil;
import com.pine.common.lang.StringConstants;
import com.pine.common.lang.StringUtil;

public class DateUtil {

	public static Date parse(String inputDate, String dateFormat) {
		Date parsedDate = null;
		if (inputDate != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			parsedDate = simpleDateFormat.parse(inputDate, new ParsePosition(0));
		}
		return parsedDate;
	}

	public static String formatCurrentDate(String dateFormat) throws ParseException {
		String date = new Date().toString();
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date today = Calendar.getInstance().getTime();
		date = df.format(today);
		return date;
	}

	public static int compare(java.sql.Date date1, java.sql.Date date2) {
		int check = date1.compareTo(date2);
		return check;
	}

	public static Date createDate(String year, String month, String day, String hour, String minute, String second)
			throws ParseException {
		return DateConstants.FMT_YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS.parse(
				year + "-" + month + "-" + day + StringConstants.BLANK_SPACE + hour + ":" + minute + ":" + second);
	}

	public static String format(Date inputDate, String dateFormat) {
		String formatedDate = "";
		if (inputDate != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			formatedDate = simpleDateFormat.format(inputDate);
		}
		return formatedDate;
	}

	// This method calculates the difference between given date and today's
	// date.
	public static int dateDiff(Date fileDate) {
		Date today = new Date();
		String dateString = DateConstants.FMT_MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS.format(today);
		int diff1 = 0;
		try {
			Date endDate = DateConstants.FMT_MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS.parse(dateString);
			Date startDate = DateConstants.FMT_MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS
					.parse(DateConstants.FMT_MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS.format(fileDate));
			diff1 = (int) ((((endDate.getTime() - startDate.getTime()) / 1000) / 24) / 60) / 60;
		} catch (ParseException e) {
			LoggerUtil.error(" fileDate: " + fileDate, e);
		}

		LoggerUtil.info(" Output:" + diff1);
		return diff1;
	}

	public static String getFormattedDate(String date, String currentFormat, String requiredFormat)
			throws ParseException {
		String retDate = null;
		if (StringUtil.isNullOrBlank(currentFormat)) {
			currentFormat = DateConstants.YYYY_MM_DD;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(currentFormat);
		if (StringUtil.isNullOrBlank(date)) {
			Date today = Calendar.getInstance().getTime();
			date = dateFormat.format(today);
		}
		Date d = dateFormat.parse(date);
		SimpleDateFormat newDateFormat = new SimpleDateFormat(requiredFormat);
		retDate = newDateFormat.format(d);
		return retDate;
	}

}
