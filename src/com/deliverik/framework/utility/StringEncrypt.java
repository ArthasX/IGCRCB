package com.deliverik.framework.utility;

public class StringEncrypt {
	
	public static String asciiToChar(String strAscii) {// ASCII转换为字符串
		String[] chars = strAscii.split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append((char)Integer.parseInt(chars[i],16));
		}
		return sb.toString();
	}

	public static String charToAscii(String str) {// 字符串转换为ASCII码
		char[] chars = str.toCharArray(); // 把字符中转换为字符数组
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if(0 == i){
				sb.append(Integer.toHexString(chars[i]));
			} else {
				sb.append("," + Integer.toHexString(chars[i]));
			}
		}
		return sb.toString();
	}
	
}
