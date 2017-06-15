/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: XML����������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class XMLUtils {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(XMLUtils.class);
	
	/**
	 * ��ȡָ��XML
	 * @param filename �ļ���
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
			log.error("XML�ļ���" + filename + "������ʧ��", e);
			throw e;
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("XML�ļ���" + filename + "������ʧ��", e);
					throw e;
				}
			}
		}
		return doc;
	}
}
