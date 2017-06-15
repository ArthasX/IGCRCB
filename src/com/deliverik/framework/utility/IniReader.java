package com.deliverik.framework.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IniReader {

	private static Log log = LogFactory.getLog(IniReader.class);
	private static Map<String, String> map = new HashMap<String, String>();

	public static boolean init(String filePath) {
		log.info("init configuration file started ...");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			log.error("配置文件未找到");
			return false;
		}
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.matches(".*=.*") && !line.contains("#")) {
					int i = line.indexOf("=");
					String key = line.substring(0, i);
					String value = line.substring(i + 1);
					map.put(key, value);
				}
			}
			reader.close();
		} catch (IOException e) {
			log.error("配置文件读取异常");
			return false;
		}
		log.info("init configuration file finished ...");
		return true;
	}

	public static String getValue(String key) {
		return map.get(key);
	}

}