package com.pine.common.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;

import com.pine.common.io.LoggerUtil;
import com.pine.common.lang.StringConstants;

public class CalendarUtil {
	public static int compareTo(Calendar savedCalendar, Calendar rightNowCalendar) {
		return savedCalendar.compareTo(rightNowCalendar);
	}

	public static int getMonthsBetween(Date date1, Date date2) {
		int result = 0;
		// TODO
		return result;
	}

	public static Date createDate(String dateString) throws Exception {
		return DateConstants.FMT_YYYY_HYP_MM_HYP_DD.parse(dateString);
	}

	public static String format(Date dt, String format) {
		if (dt == null || format == null)
			return StringConstants.BLANK;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		return formatter.format(dt);
	}

	public static String formatDateString(String dt, String format) {
		String finalDate = StringConstants.BLANK;
		try {
			if (dt == null || format == null)
				return finalDate;
			Date tmpDt = DateConstants.FMT_DD_SL_MM_SL_YYYY.parse(dt);
			finalDate = format(tmpDt, format);
		} catch (Exception e) {
			LoggerUtil.error("Exception ", e);
		}
		return finalDate;
	}

	public static int getDaysBetween(Date date1, Date date2) {
		int result = 0;
		return result;
	}

	public static Date getPreviousBusinessDay(Date startDate) {

		Date previousDay = DateUtils.truncate(addDays(startDate, -1), Calendar.DATE);
		if (isBusinessDay(previousDay)) {
			return previousDay;
		} else {
			return getPreviousBusinessDay(previousDay);
		}
	}

	public static Date parseDate(String strDate) throws Exception {
		if (!(strDate == null || ("").equals(strDate))) {
			return DateConstants.FMT_YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS.parse(strDate);
		}
		return null;
	}

	public static String format(Timestamp t, String format) {
		if (t == null || format == null) {
			return StringConstants.BLANK;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date(t.getTime()));
	}

	public static Date parseQuietly(String dateString, String pattern) {

		if (pattern == null || dateString == null || dateString.trim().length() == 0) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			LoggerUtil.info(" dateString:" + dateString + ";format:" + pattern, e);
		}
		return date;
	}

	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}

	public static boolean isBetween(Calendar date, Calendar dateStart, Calendar dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			return date.after(dateStart) && date.before(dateEnd) || (date.equals(dateStart) || date.equals(dateEnd));
		}
		return false;
	}

	public static Date getFirstDateOfTheMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static Date getLastDateOfTheMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static boolean equalsMonth(Date d1, Date d2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(d2);
		boolean isExists = false;
		if (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)) {
			isExists = true;
		}
		return isExists;
	}

	public static Date parse(String stringDate) {
		Date date = null;
		if (stringDate != null && stringDate.length() > 0) {
			try {
				date = DateConstants.FMT_MM_SL_DD_SL_YYYY_COL_HH_COL_MM_COL_SS.parse(stringDate);
			} catch (Exception e) {
				LoggerUtil.error("Exception ", e);
			}
		}
		return date;
	}

	public static String getCurrentDateAsString(String dFormat) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(dFormat);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

	public static boolean isValidDate(String date, String regEx) {
		Pattern pattern = Pattern.compile(regEx);
		Matcher patternMatcher = pattern.matcher(date.subSequence(0, date.length()));
		return patternMatcher.find();
	}

	public static String convert(String dateString, String inputFormat, String outputFormat) {
		String resultDate = null;

		if (dateString != null && dateString.length() > 0) {
			try {
				SimpleDateFormat inputFormater = new SimpleDateFormat(inputFormat);
				SimpleDateFormat outputFmater = new SimpleDateFormat(outputFormat);
				resultDate = outputFmater.format(inputFormater.parse(dateString));
			} catch (ParseException e) {
				LoggerUtil.error(
						" dateString:" + dateString + ", inputFormat:" + inputFormat + ", outputFormat:" + outputFormat,
						e);
			}
		}
		return resultDate;
	}

	public static Date getMonthsLastBusinessDay(Date startDate) {
		Date result = null;
		Calendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		result = new GregorianCalendar(year, month, day).getTime();
		if (!isBusinessDay(result))
			result = getPreviousBusinessDay(result);
		return result;
	}

	public static Date getPreviousDay(Date startDate) {
		Date previousDay = DateUtils.truncate(addDays(startDate, -1), Calendar.DATE);
		return previousDay;
	}

	private static Date addDays(Date dateToAdd, int numberOfDay) {
		if (dateToAdd == null) {
			throw new IllegalArgumentException("Date can't be null!");
		}
		Calendar tempCal = Calendar.getInstance();
		tempCal.setTime(dateToAdd);
		tempCal.add(Calendar.DATE, numberOfDay);
		return tempCal.getTime();
	}

	public static boolean isBusinessDay(Date dateToCheck) {
		Calendar baseCal = Calendar.getInstance();
		int dayOfWeek = baseCal.get(Calendar.DAY_OF_WEEK);
		boolean onWeekend = (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
		return !onWeekend;
	}

	public static int getMaxDaysInAnYear(int year) {
		Calendar cal = Calendar.getInstance();
		int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		return numOfDays;
	}

	public static boolean isLeapYear(int year) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		return cal.isLeapYear(year);
	}
}
