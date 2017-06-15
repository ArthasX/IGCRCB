/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import com.deliverik.framework.base.BLException;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: XML解析工具类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class XMLUtils {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(XMLUtils.class);
	
	/**
	 * 读取指定XML
	 * @param filename 文件名
	 * @return Document
	 * @throws BLException
	 */
	public static Document readXmlJdom(String filename) throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document doc = null;
		InputStreamReader is = null;
		try {
			is = new InputStreamReader(new FileInputStream(filename));
			doc = sb.build(is);
		} catch (Exception e) {
			log.error("XML文件（" + filename + "）解析失败", e);
			throw e;
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("XML文件（" + filename + "）解析失败", e);
					throw e;
				}
			}
		}
		return doc;
	}
}
