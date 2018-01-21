package com.pine.common.lang;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class NumberUtil {
	 
	public static String format(String number, String decimalFormat) {
		double doubleValue = Double.parseDouble(number);
		if (null == decimalFormat) {
			decimalFormat = NumberConstants.STR_DEFAULT_FORMAT;
		}
		DecimalFormat format = new DecimalFormat(decimalFormat);
		FieldPosition f = new FieldPosition(0);
		StringBuffer strBuff = new StringBuffer();
		format.format(doubleValue, strBuff, f);
		return strBuff.toString();
	}

	public static int compare(BigDecimal object1, BigDecimal object2) {
		int result = object1.compareTo(object2);
		return result;
	}

	public static synchronized String generateRandomNo() {
		String value = null;
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			value = String.valueOf(random.nextInt()) + System.currentTimeMillis();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static BigDecimal getBigDecimalFromString(String str) { 
		final BigDecimal DECIMAL_ZERO = new BigDecimal(0);
		BigDecimal result = DECIMAL_ZERO; 
		if (StringUtils.isBlank(str)) {
			return result;
		}
		str = str.trim();

		// first, try percentage rate parser
		if (str.contains("%")) {
			str = StringUtils.remove(str, '$');
			str = StringUtils.remove(str, ' ');
			str = StringUtils.remove(str, ',');
			DecimalFormat pf = new DecimalFormat("0.0##########%");
			pf.setMultiplier(100);
			pf.setParseBigDecimal(true);
			try {
				result = (BigDecimal) pf.parse(str);
			} catch (Exception pe) {
				str = StringUtils.remove(str, '%');
				try {
					result = new BigDecimal(filterNonNumberic(str));
					if (result != null) {
						result = result.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
					}
				} catch (Exception ee) {
					result = DECIMAL_ZERO;
				}
			}
		} else {
			// try currency format
			str = StringUtils.remove(str, '$');
			str = StringUtils.remove(str, ' ');
			DecimalFormat df = new DecimalFormat("#,##0.00");
			df.setParseBigDecimal(true);
			try {
				result = (BigDecimal) df.parse(str);
			} catch (Exception e) {
				try {
					result = new BigDecimal(filterNonNumberic(str));
				} catch (Exception ee) {
					result = DECIMAL_ZERO;
				}
			}
		}
		return result;
	}

	public static String filterNonNumberic(String str) {
		if (StringUtils.isBlank(str)) {
			return "0.0";
		} else {
			StringBuffer result = new StringBuffer();
			boolean firstDot = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if ((c >= '0' && c <= '9')) {
					result.append(c);
				} else if (firstDot && c == '.') {
					result.append(c);
					firstDot = false;
				}
			}
			return result.toString();
		}
	}

	public static boolean isValidNumber(String value) {
		boolean isValid = false;
		Pattern p = Pattern.compile(RegexConstants.VALID_NUMBER_FORMAT);
		Matcher m = p.matcher(value);
		if (m.matches()) {
			isValid = true;
		}
		return isValid;
	}

}
