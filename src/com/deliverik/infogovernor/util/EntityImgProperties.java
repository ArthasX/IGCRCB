/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 资产模型图片名称信息
 *
 */
public class EntityImgProperties {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(EntityImgProperties.class);

	/** 资产模型图片名称信息 */
	private static Properties properties;

	/** 加载资产模型图片名称信息标识 */
	private static boolean init = false;

	/**
	 * 构造函数
	 */
	private EntityImgProperties() {

	}

	/**
	 * 
	 * 初始化资产模型图片名称信息
	 */
	public static void init() {
		if (!init) {
			log.debug("＝＝＝＝＝＝资产模型图片名称集合初始化开始＝＝＝＝＝＝");
			// 取出单位系统配置参数
			properties = new Properties();
			FileInputStream inputFile = null;
			try {
				inputFile = new FileInputStream(ResourceUtility.getString("ENTITY_IMG_FILE_PATH"));
				properties.load(inputFile);
			} catch (FileNotFoundException e) {
				log.error("资产模型图片" + e.getMessage());
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
			log.debug("＝＝＝＝＝＝资产模型图片名称集合初始化结束＝＝＝＝＝＝");
		}
	}

	/**
	 * <p>
	 * Description: 获取资产模型图片名称
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
