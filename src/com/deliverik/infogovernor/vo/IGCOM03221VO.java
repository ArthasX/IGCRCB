package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 配置项配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03221VO extends BaseVO implements Serializable{
	
	/** 配置项信息 */
	protected IG688Info entityItemData;
		
	private Map<String,String> configItem;
			
	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	
	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGCOM03221VO(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 配置项信息取得
	 * @return 配置项信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	public Map<String, String> getConfigItem() {
		return configItem;
	}

	public void setConfigItem(Map<String, String> configItem) {
		this.configItem = configItem;
	}	
}


