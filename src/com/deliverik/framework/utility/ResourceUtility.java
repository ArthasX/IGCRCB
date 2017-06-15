package com.deliverik.framework.utility;

import java.text.MessageFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Ӧ����Դ�ļ���ApplicationResources������
 *
 * @author 
 *
 */
public class ResourceUtility {

	/** Ӧ����Դ�ļ��� */
	public static final String RESOURCE_FILE = "SystemConfigResources";
	/** Ӧ����Դ�ļ� */
	public static ResourceBundle resources;
	/** Ӧ����Դ�ļ�LOG */
	static Log log = LogFactory.getLog(ResourceUtility.class);

	static {
		try {
			resources = PropertyResourceBundle.getBundle(RESOURCE_FILE);
		} catch (Exception e) {
			log.error("Ӧ����Դ�ļ���ȡ����", e);
		}
	}

	/**
	 * Ӧ����Դ�ļ�������ȡ
	 * @param key ������
	 * @return ����ֵ
	 */
	public static String getString(String key){
		return resources.getString(key);
	}

	/**
	 * Ӧ����Դ�ļ���Ϣ�����ȡ
	 * @param key ��ϢKEY
	 * @param param 
	 * @return 
	 */
	public static String getMessage(String key, String... param){
		return MessageFormat.format(resources.getString(key), (Object[])param);
	}

}
