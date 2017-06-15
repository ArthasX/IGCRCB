/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * 初始化资产类型与角色类型关系类
 */

public class EntityCategory {

	/** 记录日志 */
	private static Log log = LogFactory.getLog(EntityCategory.class);
	
	/** 资产类型与角色类型关系信息 */
	private static HashMap<String, String> categoryMap = new HashMap<String, String>();

	/** 加载属性文件标识 */
	private static boolean init = false;
	
	/** 资产信息权限管理模式设定属性标识 */
	public final static String ENTITYITEM_PERMISSION_MODE = "ENTITYITEM_PERMISSION_MODE";
	
	/** 资产信息权限管理模式：无权限控制 */
	public final static String ENTITYITEM_PERMISSION_MODE_NO = "NO";
	
	/** 资产信息权限管理模式：资产管理人可见，资产所属模型对应的管理角色负责人可见 */
	public final static String ENTITYITEM_PERMISSION_MODE_A = "A";
	
	/** 资产信息权限管理模式：
	 *      如果是组件或者服务记录只需满足管理内容就表示该用户具有查看资产配置信息的权限
	 *      如果不是组件和服务记录需同时满足管理域与管理内容才表示该用户具有查看资产配置信息的权限 */
	public final static String ENTITYITEM_PERMISSION_MODE_B = "B";
		
	/** 角色类型（设备） */
	public final static String ROLE_TYPE_DEVICE = "IGAC01";
	
	/** 角色类型（存储配置） */
	public final static String ROLE_TYPE_STORAGE = "IGCI01";
	
	/** 角色类型（软件） */
	public final static String EROLE_TYPE_SOFTWARE = "IGAC06";

	/** 角色类型（应用） */
	public final static String ROLE_TYPE_APPLICATION = "IGAC07";
	
	/** 角色类型（数据） */
	public final static String ROLE_TYPE_DATA = "IGAC05";

	/** 角色类型（服务） */
	public final static String ROLE_TYPE_SERVICE = "IGAC04";
	
	/** 角色类型（系统） */
	public final static String ROLE_TYPE_SYSTEM = "IGAC09";
	
	/** 角色类型（人员） */
	public final static String ROLE_TYPE_PERSON = "IGAC08";
	
	/** 角色类型（合同） */
	public final static String ROLE_TYPE_CONTRACT = "IGAC02";
	
	/** 角色类型（文档） */
	public final static String ROLE_TYPE_DOCUMENT = "IGAC10";

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private EntityCategory() {

	}

	/**
	 * <p>
	 * Discription:初始化map
	 * </p>
	 * 
	 * @update maozhipeng@deliverik.com
	 */
	public static void init() {
		if (!init) {
			log.debug("＝＝＝＝＝＝资产类型与角色类型关系初始化开始＝＝＝＝＝＝");
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
			log.debug("＝＝＝＝＝＝资产类型与角色类型关系初始化结束＝＝＝＝＝＝");
		}
	}

	/**
	 * <p>
	 * Description: 获取资产类型与角色类型关系信息
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
