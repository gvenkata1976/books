package com.pine.common.lang;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.pine.common.io.LoggerUtil;

public class StringUtil extends StringUtils {

	// for (ParterName) data validation in HedgeTek data upload
	private static Set<String> FORBIDDEN_TAGS;

	public static boolean isAlphaNumeric(String str) {
		boolean b = false;
		if (!isEmpty(str)) {
			b = Pattern.matches("[a-zA-Z0-9\\s]*", str);
		}
		return b;
	}

	/**
	 * @param objects
	 * @return returns single string contains all objects
	 */
	public static String toString(Object[] objects) {
		String objectNames = null;

		if (objects != null) {
			int objectCount = objects.length;
			StringBuffer obj = new StringBuffer();
			for (int iCount = 0; iCount < objectCount; iCount++) {
				if (objects[iCount] != null) {
					obj.append(objects[iCount].toString() + ", ");
				}
			}
			objectNames = obj.toString();
			if (objectNames.length() > 0) {
				objectNames = objectNames.substring(0, objectNames.length() - 2);
			}
		}
		return objectNames;
	}

	/**
	 * @param str
	 * @param delimeter
	 * @return returns Object array containing substrings of str separated by
	 *         delimiter
	 */
	public static Object[] toArray(String str, String delimeter) {
		Object[] elements = null;
		List<String> elementList = new ArrayList<String>();
		if (str != null && !StringConstants.BLANK.equals(str)) {
			StringTokenizer strToken = new StringTokenizer(str, delimeter);
			while (strToken.hasMoreTokens()) {
				elementList.add((String) strToken.nextElement());
			}
			elements = (String[]) elementList.toArray(new String[0]);
		}
		return elements;

	}

	public static String toCamelCase(String textValue) {
		if (textValue != null && !textValue.isEmpty()) {
			String firstChar = textValue.substring(0, 1);
			String camelCaseText = firstChar.toUpperCase() + textValue.substring(1, textValue.length()).toLowerCase();
			return camelCaseText;
		}
		return null;
	}

	public static double toDouble(String amount) {
		double returnValue = 0.00;
		if (!isBlank(amount)) {
			if (amount.charAt(0) == '-') {
				returnValue = (-convert(amount.substring(1)));
			} else {
				returnValue = convert(amount);
			}
		}
		return returnValue;
	}

	/**
	 * @param name
	 * @return returns decoded string for special characters
	 */
	public static String decodeSpecialChars(String name) {
		String tempName = name;
		// TODO
		return tempName;
	}

	/**
	 * @param str
	 * @return returns decoded string for UTF8 characters
	 */
	public static String decode(String str) {
		String retStr = StringConstants.BLANK;
		if (!isBlank(str)) {
			try {
				retStr = new String(str.getBytes(EncodingConstants.CHARACTER_SET_8859_1),
						EncodingConstants.CHARACTER_SET_UTF8);
			} catch (UnsupportedEncodingException e) {
				retStr = str;
			}
		}
		return retStr;
	}

	/**
	 * @param list
	 * @param value
	 * @return returns true if values exists in list, false otherwise
	 */
	public static boolean exists(String[] list, String value) {
		boolean flag = false;
		if (list != null && list.length > 0 && value != null && value.length() > 0) {
			for (int i = 0; i < list.length; i++) {
				if (value.equals(list[i])) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * @param list
	 * @param values
	 * @return returns true if values exists in list, false otherwise
	 */
	public static boolean exists(String[] list, String[] values) {
		boolean flag = false;
		if (list != null && list.length > 0 && values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				flag = exists(list, values[i]);
				if (flag) {
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * @param formatString
	 * @param argument
	 * @return returns formatted message
	 */
	public static String formatMessage(String formatString, String argument) {
		return formatMessage(formatString, new String[] { argument });
	}

	/**
	 * @param formatString
	 * @param arguments
	 * @return returns formatted message
	 */
	public static String formatMessage(String formatString, String[] arguments) {
		return MessageFormat.format(formatString, (Object[]) arguments);
	}

	/**
	 * @param entityName
	 * @return returns formatted string of entityName
	 */
	public static String formatName(String entityName) {
		String formattedName = entityName;

		if (!isBlank(entityName)) {
			if (entityName.contains("<")) {
				formattedName = formattedName.replaceAll("<", "&lt;");
			}
			if (entityName.contains(">")) {
				formattedName = formattedName.replaceAll(">", "&gt;");
			}
		}
		return formattedName;
	}

	/**
	 * @param amount
	 * @return returns formatted string of amount
	 */
	public static String FormatToString(BigDecimal amount) {
		String strAmount = StringConstants.BLANK;
		if (amount != null) {
			strAmount = formatToString(amount.doubleValue(), 2);
		}
		return strAmount;
	}

	/**
	 * @param amount
	 * @return returns formatted string of amount
	 */
	public static String formatToString(double amount) {
		return formatToString(amount, 2);
	}

	/**
	 * @param amount
	 * @param decimalPositions
	 * @return returns formatted string of amount using decimalPositions
	 */
	public static String formatToString(double amount, int decimalPositions) {
		DecimalFormat nf = new DecimalFormat("###,###,###,##0.######");
		nf.setMaximumFractionDigits(decimalPositions);
		nf.setMinimumFractionDigits(decimalPositions);
		return nf.format(amount);
	}

	/**
	 * @param amount
	 * @param decimalPositions
	 * @return returns formatted string of amount using decimalPositions
	 */
	public static String formatToStringWithoutComma(double amount, int decimalPositions) {
		DecimalFormat nf = new DecimalFormat("###########0.######");
		nf.setMaximumFractionDigits(decimalPositions);
		nf.setMinimumFractionDigits(decimalPositions);
		return nf.format(amount);
	}

	/**
	 * @param arr
	 * @param key
	 * @return returns name from arr for key
	 */
	public static String getName(String[][] arr, String key) {
		if (arr == null || key == null)
			return "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0].equals(key)) {
				return arr[i][1];
			}
		}
		return key;
	}

	/**
	 * @param input
	 * @return returns true if input is blank, false otherwise
	 */
	public static boolean isBlank(String input) {
		if (input == null || StringConstants.BLANK.equals(input))
			return true;
		else
			return false;
	}

	/**
	 * @param str
	 * @return returns true if str is digit, false otherwise
	 */
	public static boolean isDigit(String str) {
		boolean b = false;
		if (!isEmpty(str)) {

			b = Pattern.matches("\\d*", str);
		}
		return b;
	}

	/**
	 * @param input
	 * @return returns true if input is empty, false otherwise
	 */
	public static boolean isEmpty(String input) {
		if (input == null || StringConstants.BLANK.equals(input.trim()))
			return true;
		else
			return false;
	}

	/**
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String[] input) {
		if (input == null || input.length <= 0)
			return true;
		else
			return false;
	}

	/**
	 * @param list
	 * @param delimiter
	 * @return returns string created from concatenation of values using
	 *         delimiter
	 */
	public static String toString(String[] list, String delimiter) {
		StringBuffer sbTo = new StringBuffer();
		boolean firstElement = true;
		if (list != null && list.length > 0) {
			sbTo = new StringBuffer(list.length * 40);
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null) {
					if (firstElement) {
						firstElement = false;
					} else {
						sbTo.append(delimiter);
					}
					sbTo.append(list[i]);
				}
			}
		}
		return sbTo.toString();

	}

	/**
	 * Insert the method's description here. Creation date: (11/5/2002 4:56:34
	 * PM)
	 * 
	 * @return java.lang.String
	 * @param strInput
	 *            java.lang.String
	 */
	public static String trim(String strInput) {
		String value = (strInput != null ? strInput.trim() : StringConstants.BLANK);
		value = ("null".equals(strInput) ? StringConstants.BLANK : strInput);
		value = ("undefined".equals(strInput) ? StringConstants.BLANK : strInput);
		return value;
	}

	/**
	 * Method Trim the String from right.
	 * 
	 * @param strInput
	 * @param size
	 * @return String
	 */
	public static String trim(String strInput, int size) {
		return trimRight(strInput, size);
	}

	/**
	 * @param source
	 * @return returns string array containing non-empty elements of source
	 */
	public static String[] trim(String[] source) {
		String[] target = null;
		List<String> tempDestination = new ArrayList<String>();
		if (source != null) {
			for (int k = 0; k < source.length; k++) {
				if (!isEmpty(source[k])) {
					tempDestination.add(source[k]);
				}

			}
			if (tempDestination.size() > 0) {
				target = new String[tempDestination.size()];
				tempDestination.toArray(target);
			}
		}
		return target;
	}

	/**
	 * Method Trim the String from left.
	 * 
	 * @param strInput
	 * @param size
	 * @return String
	 */
	public static String trimLeft(String strInput, int size) {
		String tempStr = trim(strInput);
		int i = tempStr.length();
		if (i > 0 && i > size) {
			tempStr = tempStr.substring(i - size, i);
		}
		return tempStr;
	}

	/**
	 * Method Trim the String from right. Creation date: (11/5/2002 4:57:16 PM)
	 * 
	 * @return java.lang.String
	 * @param strInput
	 *            java.lang.String
	 * @param size
	 *            int
	 */
	public static String trimRight(String strInput, int size) {
		String tempStr = trim(strInput);
		if (tempStr.length() > 0 && tempStr.length() > size) {
			tempStr = tempStr.substring(0, size);
		}
		return tempStr;
	}

	/**
	 * @param inputValue
	 * @return returns null if inputValue is blank after trimming, trimmed
	 *         inputValue otherwise
	 */
	public static String trimToNull(String inputValue) {
		String tempInputValue = trim(inputValue);
		if (StringConstants.BLANK.equals(tempInputValue))
			return null;
		else
			return tempInputValue;
	}

	/**
	 * @param inputValues
	 * @return returns null if inputValues elements are blank after trimming,
	 *         array of trimmed to null inputValues elements otherwise
	 */
	public static String[] trimToNull(String[] inputValues) {
		if (inputValues != null && inputValues.length > 0) {
			boolean tempArrayInit = false;
			for (int i = 0; i < inputValues.length; i++) {

				if (trimToNull(inputValues[i]) == null) {
					inputValues[i] = null;
				} else {
					tempArrayInit = true;
				}
			}
			if (!tempArrayInit) {
				return null;
			}
		}
		return inputValues;
	}

	private static double convert(String amount) {

		double returnValue = 0.00;
		try {
			if (amount.charAt(0) == '$') {
				returnValue = NumberConstants.AMOUNT_FORMATTER_1.parse(amount.substring(1)).doubleValue();
			} else {
				returnValue = NumberConstants.AMOUNT_FORMATTER_1.parse(amount).doubleValue();
			}
		} catch (Exception e) {
			LoggerUtil.error(" amount : " + amount, e);
		}
		return returnValue;
	}

	public static StringBuilder removePadding(StringBuilder srcString, String stringToRemove, int indexOfRemoveString) {
		int x = srcString.lastIndexOf(stringToRemove);
		int lengthOfQuery = srcString.length();
		if (x == lengthOfQuery - indexOfRemoveString) {
			srcString.replace(x, x + stringToRemove.length(), "");
		}
		return srcString;
	}

	public static boolean isDecimal(String strAmount) {
		char[] amount = strAmount.toCharArray();
		int i = 0;
		int k = amount.length;
		boolean dp = false;
		if (amount[i] == '-') {
			i = 1;
		}
		for (; i < k; i++) {
			if (!Character.isDigit(amount[i])) {
				if (amount[i] == '.') {
					if (dp) {
						// already saw a decimal point
						return false;
					} else {
						dp = true;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Method to convert String array to comma separated string.
	 * 
	 * @param objStringArry
	 * @return {@link String}
	 * @throws Exception
	 */
	public static String toCommaSeparatedString(String[] objStringArry) throws Exception {

		StringBuffer commaSepString = new StringBuffer();
		;
		try {
			if (objStringArry != null && objStringArry.length > 0) {
				for (int i = 0; i < objStringArry.length; i++) {
					if (i == 0) {
						commaSepString.append(objStringArry[i]);
					} else {
						commaSepString.append(",").append(objStringArry[i]);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return commaSepString.toString();
	}

	public static String trimToDefault(Object object, String defaultVal) {
		if (object == null) {
			return defaultVal;
		}
		String value = trim(object.toString());
		if (StringConstants.BLANK.equals(value)) {
			value = defaultVal;
		}
		return value;
	}

	public static boolean checkValidStringLength(String value, int validLength) {
		return ((value.trim().length()) <= validLength) ? true : false;
	}

	public static boolean isValidCharsPresent(String value, String regEx) {
		Pattern pattern = Pattern.compile(regEx);
		Matcher patternMatcher = pattern.matcher(value.subSequence(0, value.length()));
		return patternMatcher.find();
	}

	public static boolean isVulnerableCharPresent(String value, String regEx) {
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher patternMatcher = pattern.matcher(value.subSequence(0, value.length()));
		return patternMatcher.find();
	}

	private static void initForbiddenTags() {
		FORBIDDEN_TAGS = new HashSet<String>();

		FORBIDDEN_TAGS.add("onClick");
		FORBIDDEN_TAGS.add("ondblclick");
		FORBIDDEN_TAGS.add("onLoad");
		FORBIDDEN_TAGS.add("onunload");
		FORBIDDEN_TAGS.add("onMouseOver");
		FORBIDDEN_TAGS.add("onMouseUp");
		FORBIDDEN_TAGS.add("onMousedown");
		FORBIDDEN_TAGS.add("onMousemove");
		FORBIDDEN_TAGS.add("onMouseOut");
		FORBIDDEN_TAGS.add("onfocus");
		FORBIDDEN_TAGS.add("onblur");
		FORBIDDEN_TAGS.add("onkeypress");
		FORBIDDEN_TAGS.add("onkeydown");
		FORBIDDEN_TAGS.add("onkeyup");
		FORBIDDEN_TAGS.add("onsubmit");
		FORBIDDEN_TAGS.add("onreset");
		FORBIDDEN_TAGS.add("onselect");
		FORBIDDEN_TAGS.add("onchange");
		FORBIDDEN_TAGS.add("onError");
		FORBIDDEN_TAGS.add("javascript");
		FORBIDDEN_TAGS.add("vbscript");
		FORBIDDEN_TAGS.add("expression");// newly added
		FORBIDDEN_TAGS.add("script");// newly added
		FORBIDDEN_TAGS.add("window.setInterval");// newly added
		FORBIDDEN_TAGS.add("((\\%3C)|<)[^\n]+((\\%3E)|>)");// newly added
	}

	public static List<Integer> toIntegerList(String inString, String seperator) {
		List<Integer> result = new ArrayList<Integer>();
		if (isNotBlank(inString) && isNotBlank(inString)) {
			List<String> stringList = new ArrayList<String>();
			stringList.addAll(Arrays.asList(split(inString, seperator)));
			for (String item : stringList) {
				try {
					result.add((int) Double.parseDouble(item));
				} catch (NumberFormatException e) {
					// result.add(0);
				}
			}

		}
		return result;
	}

	public static boolean isInputVulnerable(String input) {
		boolean flag = false;
		// initialize all the forbidden tags and characters as a set of patterns
		initForbiddenTags();

		Iterator<String> itr = FORBIDDEN_TAGS.iterator();
		while (itr.hasNext()) {
			String pattern = (String) itr.next();
			flag = isVulnerableCharPresent(input, pattern);
			if (flag) {
				// Log.info(StringUtils.class, METHOD_NAME, "Vulnerable Input
				// Found:" + input);
				break;
			}
		}
		return flag;
	}

	public static String add(String strLeft, String strRight) throws NumberFormatException {
		return Double.toString(((!isEmpty(strLeft)) ? Double.parseDouble(strLeft) : 0)
				+ ((!isEmpty(strRight)) ? Double.parseDouble(strRight) : 0));
	}

	public static boolean containsMatch(String str1, String str2) {
		String pattern = str1 + "([a-z|A-Z]+)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str2);
		return m.find();
	}

	public static double round(double dp, int numberDecimalplaces) {
		if (numberDecimalplaces == 4) {
			dp = dp + 0.000001;
			dp = Math.round(dp * 10000);
			dp = dp / 10000;
		}
		return dp;
	}

	public static String formatTime(String time) {
		int indexLastColon = time.lastIndexOf(":");
		String tempTime = time.substring(2, indexLastColon);
		int indexColon = tempTime.indexOf(":");
		String hour = tempTime.substring(0, indexColon);
		String minutes = tempTime.substring(indexColon + 1);
		if (hour.length() == 1) {
			hour = NumberConstants.ZERO + hour;
		}
		if (minutes.length() == 1) {
			minutes = NumberConstants.ZERO + minutes;
		}
		String formattedTime = hour + ":" + minutes;
		return formattedTime;
	}

	public static String toCommaSeparatedString(List<String> objStringList) throws Exception {

		StringBuffer commaSepString = new StringBuffer();
		;
		try {
			if (objStringList != null && objStringList.size() > 0) {
				for (int i = 0; i < objStringList.size(); i++) {
					if (i == 0) {
						commaSepString.append(objStringList.get(i));
					} else {
						commaSepString.append(",").append(objStringList.get(i));
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return commaSepString.toString();
	}

	public static String formatTimeToHHMMSS(String time) {
		int indexLastColon = time.lastIndexOf(":");
		int indexDot = time.lastIndexOf(".");
		String tempTime = time.substring(2, indexLastColon);

		int indexColon = tempTime.indexOf(":");
		String hour = tempTime.substring(0, indexColon);

		String minutes = tempTime.substring(indexColon + 1);

		String sec = time.substring(indexLastColon + 1, indexDot);

		if (hour.length() == 1) {
			hour = NumberConstants.ZERO + hour;
		}
		if (minutes.length() == 1) {
			minutes = NumberConstants.ZERO + minutes;
		}
		if (sec.length() == 1) {
			sec = NumberConstants.ZERO + sec;
		}
		String formattedTime = hour + ":" + minutes + ":" + sec;
		return formattedTime;
	}

	public static String toString(Object object) {

		String objectName = null;
		if (object != null) {
			objectName = object.toString();
		}
		return objectName;
	}

	public static int compareCharacter(Character object1, Character object2) {
		int result = object1.compareTo(object2);
		return result;
	}

	public static String replaceToken(String string, String token, String value) {

		while (string.indexOf(token) != -1) {
			StringBuffer sb = new StringBuffer(string);
			sb.replace(string.indexOf(token), string.indexOf(token) + token.length(), value);
			string = sb.toString();
		}

		return string;
	}

	public static boolean isNullOrBlank(String string) {

		boolean result = false;

		if (string != null && string.trim().length() != 0) {
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	public static boolean isNumber(String number) {

		boolean result = false;

		try {
			long num = Long.valueOf(number).longValue();

			// number should be greater > 0
			if (num > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (NumberFormatException e) {
			result = false;
		}

		return result;
	}
}
