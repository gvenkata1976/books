package com.pine.common.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface DateConstants {
	String YYYY_HYP_MM_HYP_DD = "yyyy-MM-dd";
	String YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS = "yyyy-MM-dd HH:mm:ss";
	String DAY_END_TIME = " 23:59:59";
	String DAY_START_TIME = " 00:00:00";
	String DD_SL_MM_SL_YY = "dd/MM/yy";
	String DD_SL_MM_SL_YYYY = "dd/MM/yyyy";
	String MM_SL_DD_SL_YYYY__HH_COL_MM_COL_SS = "MM/dd/yyyy HH:mm:ss";
	String DD_SL_MM_SL_YYYY__HH_COL_MM_COL_SS = "dd/MM/yyyy HH:mm:ss";
	String MM_SL_DD_SL_YYYY = "MM/dd/yyyy";
	String MM_SL_DD_SL_YYYY_COL_HH_COL_MM_COL_SS = "MM/dd/yyyy:HH:mm:ss";
	String DD_SL_MM_SL_YYYY_COL_HH_COL_MM_COL_SS = "dd/MM/yyyy:HH:mm:ss";
	String YYYY_SL_MM_SL_DD = "yyyy/MM/dd";
	String MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS = "MM-dd-yyyy HH:mm:ss";
	String YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS_DOT_SSSS = "yyyy-MM-dd HH:mm:ss.SSSS";
	String HH_MM_SS_SS = "HHmmssSS";
	String YYYY_MM_DD = "yyyyMMdd";
	SimpleDateFormat FMT_TIME_HUNDREDTH = new SimpleDateFormat(HH_MM_SS_SS);
	SimpleDateFormat FMT_YYYY_MM_DD_HH_MM_SS_SSSS = new SimpleDateFormat(YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS_DOT_SSSS);
	SimpleDateFormat FMT_YYYY_HYP_MM_HYP_DD = new SimpleDateFormat(YYYY_HYP_MM_HYP_DD);
	SimpleDateFormat FMT_YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS = new SimpleDateFormat(YYYY_HYP_MM_HYP_DD__HH_COL_MM_COL_SS);
	SimpleDateFormat FMT_MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS = new SimpleDateFormat(MM_HYP_DD_HYP_YYYY__HH_COL_MM_COL_SS);
	DateFormat FMT_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
	DateFormat FMT_DEFAULT_MM_SL_DD_SL_YYYY = new SimpleDateFormat(MM_SL_DD_SL_YYYY); 
	DateFormat FMT_DD_SL_MM_SL_YYYY = new SimpleDateFormat(DD_SL_MM_SL_YYYY);
	SimpleDateFormat  FMT_MM_SL_DD_SL_YYYY_COL_HH_COL_MM_COL_SS = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");
}
