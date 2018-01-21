package com.pine.common.util;

import com.pine.common.lang.EncodingConstants;
import com.pine.common.lang.StringConstants;

public final class HtmlEncoder {

	public static String encode(String src) {
		if (src != null && src.length() > 0) {
			String tempSrc = src;
			int len = EncodingConstants.ENCODING_CHARACTERS.length - 1;
			try {
				while (len >= 0) {
					if (EncodingConstants.ENCODING_CHARACTERS[len] != " " && EncodingConstants.ENCODING_CHARACTERS[len] != "&" && EncodingConstants.ENCODING_CHARACTERS[len] != "^"
							&& tempSrc.contains(EncodingConstants.ENCODING_CHARACTERS[len])) {
						tempSrc = tempSrc.replaceAll(EncodingConstants.ENCODING_CHARACTERS[len], EncodingConstants.ENCODED_CHARACTERS[len]);
					}
					len--;
				}
				return tempSrc;
			} catch (Exception ex) {
				return tempSrc;
			}
		} else {
			return StringConstants.BLANK;
		}
	}

	public static String encodeSpaces(String src) {
		if (src != null && src.length() > 0) {
			String tempSrc = encode(src);
			try {
				tempSrc = src.replaceAll(StringConstants.CARRIAGE_RETURN + StringConstants.LINE_FEED, StringConstants.HTML_LINE_BREAK);
			} catch (Exception ex) {
				return tempSrc;
			}
			return tempSrc;
		} else {
			return StringConstants.BLANK;
		}
	}

	public static boolean isEncoded(String source, int start) {

		for (int i = 0; i < EncodingConstants.ENCODED_CHARACTERS.length; i++) {
			String enc = EncodingConstants.ENCODED_CHARACTERS[i];
			String src = "";
			try {
				src = source.substring(start, start + enc.length());
			} catch (Exception e) {
				// Empty catch block
			}
			if (enc.equalsIgnoreCase(src)) {
				return true;
			}
		}
		return false;
	}
}