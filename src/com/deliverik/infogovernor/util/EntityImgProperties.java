/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.utility.ResourceUtility;

/**
 * �ʲ�ģ��ͼƬ������Ϣ
 *
 */
public class EntityImgProperties {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(EntityImgProperties.class);

	/** �ʲ�ģ��ͼƬ������Ϣ */
	private static Properties properties;

	/** �����ʲ�ģ��ͼƬ������Ϣ��ʶ */
	private static boolean init = false;

	/**
	 * ���캯��
	 */
	private EntityImgProperties() {

	}

	/**
	 * 
	 * ��ʼ���ʲ�ģ��ͼƬ������Ϣ
	 */
	public static void init() {
		if (!init) {
			log.debug("�������������ʲ�ģ��ͼƬ���Ƽ��ϳ�ʼ����ʼ������������");
			// ȡ����λϵͳ���ò���
			properties = new Properties();
			FileInputStream inputFile = null;
			try {
				inputFile = new FileInputStream(ResourceUtility.getString("ENTITY_IMG_FILE_PATH"));
				properties.load(inputFile);
			} catch (FileNotFoundException e) {
				log.error("�ʲ�ģ��ͼƬ" + e.getMessage());
			} catch (IOException e) {
				log.error(e.getMessage());
			} finally {
				if(inputFile != null) {
					try {
						inputFile.close();
					} catch (IOException e) {
						log.error(e.getMessage());
					}
				}
			}

			init = true;
			log.debug("�������������ʲ�ģ��ͼƬ���Ƽ��ϳ�ʼ������������������");
		}
	}

	/**
	 * <p>
	 * Description: ��ȡ�ʲ�ģ��ͼƬ����
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getEntityImgInfo(String key) {
		if (!init) {
			init();
		}
		if (properties.containsKey(key)) {
			return (String) properties.get(key);
		} else {
			return "";
		}
	}

}
