package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * 设备配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11162VO extends BaseVO implements Serializable{
	
	/** 设备配置信息 */
	protected SOC0107Info entityData;

	/**
	 * 构造函数
	 * @param entityItemData　设备配置信息
	 */
	public IGASM11162VO(SOC0107Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * 设备配置取得
	 * @return 设备配置
	 */
	public SOC0107Info getEntityData() {
		return entityData;
	}
	
	/**
	 * 设备配置附件信息标识取得
	 * @return 设备配置附件信息标识
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


