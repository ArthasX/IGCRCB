/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * ��ʼ���ʲ��������ɫ���͹�ϵ��
 */

public class EntityCategory {

	/** ��¼��־ */
	private static Log log = LogFactory.getLog(EntityCategory.class);
	
	/** �ʲ��������ɫ���͹�ϵ��Ϣ */
	private static HashMap<String, String> categoryMap = new HashMap<String, String>();

	/** ���������ļ���ʶ */
	private static boolean init = false;
	
	/** �ʲ���ϢȨ�޹���ģʽ�趨���Ա�ʶ */
	public final static String ENTITYITEM_PERMISSION_MODE = "ENTITYITEM_PERMISSION_MODE";
	
	/** �ʲ���ϢȨ�޹���ģʽ����Ȩ�޿��� */
	public final static String ENTITYITEM_PERMISSION_MODE_NO = "NO";
	
	/** �ʲ���ϢȨ�޹���ģʽ���ʲ������˿ɼ����ʲ�����ģ�Ͷ�Ӧ�Ĺ����ɫ�����˿ɼ� */
	public final static String ENTITYITEM_PERMISSION_MODE_A = "A";
	
	/** �ʲ���ϢȨ�޹���ģʽ��
	 *      �����������߷����¼ֻ������������ݾͱ�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
	 *      �����������ͷ����¼��ͬʱ�����������������ݲű�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ�� */
	public final static String ENTITYITEM_PERMISSION_MODE_B = "B";
		
	/** ��ɫ���ͣ��豸�� */
	public final static String ROLE_TYPE_DEVICE = "IGAC01";
	
	/** ��ɫ���ͣ��洢���ã� */
	public final static String ROLE_TYPE_STORAGE = "IGCI01";
	
	/** ��ɫ���ͣ������ */
	public final static String EROLE_TYPE_SOFTWARE = "IGAC06";

	/** ��ɫ���ͣ�Ӧ�ã� */
	public final static String ROLE_TYPE_APPLICATION = "IGAC07";
	
	/** ��ɫ���ͣ����ݣ� */
	public final static String ROLE_TYPE_DATA = "IGAC05";

	/** ��ɫ���ͣ����� */
	public final static String ROLE_TYPE_SERVICE = "IGAC04";
	
	/** ��ɫ���ͣ�ϵͳ�� */
	public final static String ROLE_TYPE_SYSTEM = "IGAC09";
	
	/** ��ɫ���ͣ���Ա�� */
	public final static String ROLE_TYPE_PERSON = "IGAC08";
	
	/** ��ɫ���ͣ���ͬ�� */
	public final static String ROLE_TYPE_CONTRACT = "IGAC02";
	
	/** ��ɫ���ͣ��ĵ��� */
	public final static String ROLE_TYPE_DOCUMENT = "IGAC10";

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private EntityCategory() {

	}

	/**
	 * <p>
	 * Discription:��ʼ��map
	 * </p>
	 * 
	 * @update maozhipeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("�������������ʲ��������ɫ���͹�ϵ��ʼ����ʼ������������");
			categoryMap.clear();
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_DEVICE, ROLE_TYPE_DEVICE);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_MODULE, ROLE_TYPE_DEVICE);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_SOFTWARE, EROLE_TYPE_SOFTWARE);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION, ROLE_TYPE_APPLICATION);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_DATA, ROLE_TYPE_DATA);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_SERVICE, ROLE_TYPE_SERVICE);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD, ROLE_TYPE_SERVICE);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_SYSTEM, ROLE_TYPE_SYSTEM);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_PERSON, ROLE_TYPE_PERSON);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT, ROLE_TYPE_CONTRACT);
			categoryMap.put(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT, ROLE_TYPE_DOCUMENT);
			init = true;
			log.debug("�������������ʲ��������ɫ���͹�ϵ��ʼ������������������");
		}
	}

	/**
	 * <p>
	 * Description: ��ȡ�ʲ��������ɫ���͹�ϵ��Ϣ
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update maozhipeng@deliverik.com
	 */
	public static String getRoleType(String key) {
		if (!init) {
			init();
		}
		if (categoryMap != null && !categoryMap.isEmpty()) {
			return (String) categoryMap.get(key);
		}
		return "";
	}

}
