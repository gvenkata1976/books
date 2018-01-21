package com.pine.common.lang;

import java.nio.charset.StandardCharsets;

public interface EncodingConstants {
	String CHARACTER_SET_8859_1 = StandardCharsets.ISO_8859_1.name();
	String CHARACTER_SET_UTF8 =  StandardCharsets.UTF_8.name();
	// Both the arrays are tightly coupled.
	String[] ENCODED_CHARACTERS = { "&nbsp;", "&amp;", "&quot;", "&lt;", "&gt;", "&circ;", "&tilde;", "&prime;", "&euro;",
			"&ldquo;", "&rdquo;", "&#8482;", "&#8230;", "&copy;", "&reg;", "&#8216;", "&#8217;", "&#8211;",
			"&#8212;", "&#8222;", "&#8224;", "&#8225;", "&#8226;" };
	String[] ENCODING_CHARACTERS = { " ", "&", "\"", "<", ">", "^", "~", "'", "€", "“", "”", "™", "…", "©", "®", "‘",
			"’", "–", "—", "„", "†", "‡", "•" };
}
