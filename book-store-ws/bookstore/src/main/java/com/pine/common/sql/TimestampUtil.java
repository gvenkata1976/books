package com.pine.common.sql;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.StringTokenizer;

import com.pine.common.date.DateConstants;
import com.pine.common.date.DateUtil;
import com.pine.common.lang.StringConstants;

public class TimestampUtil extends DateUtil {
	public static Timestamp createTimeStamp(java.util.Date date) {
		Timestamp _tsCreate = (date != null) ? new Timestamp(date.getTime()) : null;
		return _tsCreate;
	}

	public static Timestamp createTimeStamp(String dateString, int time) throws Exception {
		Timestamp timestamp = null; 
		Date date = null;
		try {
			date = DateConstants.FMT_YYYY_MM_DD.parse(dateString);
		} catch (Exception e) {
			new Exception("dateString :"+dateString , e);
			throw e;
		}
		timestamp = new Timestamp(date.getTime() + time);
		return timestamp;
	}

	public static Timestamp createTimeStamp(String dateString, String hour, String minutes) throws ParseException {
		String day = dateString.substring(0, 2);
		String month = dateString.substring(3, 5);
		String year = dateString.substring(6);

		Date tempDt = createDate(year, month, day, hour, minutes, String.valueOf(0));
		return createTimeStamp(tempDt);
	}

	public static String format(Timestamp t, String format) {
		if (t == null || format == null)
			return StringConstants.BLANK;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		return formatter.format(new Date(t.getTime()));
	}

	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getCurrentTimestamp() {
		String s = getCurrentTime().toString();
		return s;
	}

	public static String getTimeinHundredthSec(Timestamp t) {
		Date currentTime_1 = new Date(t.getTime());
		String tmString = DateConstants.FMT_TIME_HUNDREDTH.format(currentTime_1);
		return tmString;
	}

	public static String getTimestamp() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		String s = t.toString();
		s = s.replace(StringConstants.HYPHEN, StringConstants.BLANK_SPACE);
		s = s.replace(StringConstants.COLON , StringConstants.BLANK_SPACE);
		s = s.replace(StringConstants.DOT , StringConstants.BLANK_SPACE);
		StringTokenizer st = new StringTokenizer(s, StringConstants.BLANK_SPACE);
		StringBuffer sb = new StringBuffer();
		int nos = st.countTokens();
		int i = 0;
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
			i++;
			if (i == (nos - 2)){
				break;
			}
		}
		return sb.toString();
	}

	public static String formatTimeStamp(Timestamp t, String format) {
		if (t == null || format == null)
			return StringConstants.BLANK;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		return formatter.format(new Date(t.getTime()));
	}

	public static Timestamp StringToTimestamp(String dateString, String format) {
		Timestamp ts = null;
		Date date = parse(dateString, format);
		if (date != null)
			ts = new Timestamp(date.getTime());
		return ts;
	}
}
