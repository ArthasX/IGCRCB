package com.deliverik.infogovernor.util;

public class StringEncrypt {
	
	public static String asciiToChar(String strAscii) {// ASCIIת��Ϊ�ַ���
		String[] chars = strAscii.split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append((char)Integer.parseInt(chars[i],16));
		}
		return sb.toString();
	}

	public static String charToAscii(String str) {// �ַ���ת��ΪASCII��
		char[] chars = str.toCharArray(); // ���ַ���ת��Ϊ�ַ�����
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
	
	public static boolean notNull(String str){
		
		if(str == null || "".equals(str)){
			return false;
		}
		return true;
	}
	
}
