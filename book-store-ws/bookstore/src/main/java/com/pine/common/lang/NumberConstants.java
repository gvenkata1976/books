package com.pine.common.lang;

import java.text.DecimalFormat;
import java.text.NumberFormat;
public interface NumberConstants{
	String ZERO = "0"; 
	String STR_DEFAULT_FORMAT = "#,##0.00";
	String STR_FORMAT_1 = "###,###,###,##0.######";
	NumberFormat AMOUNT_FORMATTER_1 = new DecimalFormat(STR_FORMAT_1); 
}
 	 
