package com.deliverik.infogovernor.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 配置项配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03032VO extends BaseVO implements Serializable{
	
	/** 配置项配置信息 */
	protected IG800Info entityData;

	/**
	 * 构造函数
	 * @param entityItemData　配置项配置信息
	 */
	public IGCOM03032VO(IG800Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * 配置项配置取得
	 * @return 配置项配置
	 */
	public IG800Info getEntityData() {
		return entityData;
	}
	
	/**
	 * 配置项配置附件信息标识取得
	 * @return 配置项配置附件信息标识
	 */
	public String getAttachFlag() {
		String attachFlg = "";
		
		if (entityData.getConfiguration() != null) {
			if (StringUtils.isNotEmpty(entityData.getConfiguration().getCcategory())) {
				attachFlg = entityData.getConfiguration().getCcategory().substring(0, 1);
			}
		}
		return attachFlg;
	}
}


