package com.deliverik.infogovernor.util;

import java.text.SimpleDateFormat;

public class Common {
	
	/**
	 * get time
	 * 
	 * @param symbols
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getTime(String symbols, long timestamp) {
		SimpleDateFormat format = null;
		if (symbols == null || "".equals(symbols)) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			format = new SimpleDateFormat(symbols);
		}

		if (timestamp != 0) {
			return format.format(timestamp);
		}

		return format.format(System.currentTimeMillis());
	}
}
