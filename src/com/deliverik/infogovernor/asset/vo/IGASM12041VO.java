package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 机柜详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM12041VO extends BaseVO implements Serializable{
	
	/** 机柜信息 */
	protected IG688Info entityItemData;
	
	/** 机柜配置信息 */
	protected List<IG002Info> configItemDataList;

	/**
	 * 构造函数
	 * @param entityItemData　机柜信息
	 * @param configItemDataList　机柜配置信息
	 */
	public IGASM12041VO(IG688Info entityItemData,List<IG002Info> configItemDataList) {
		this.entityItemData = entityItemData;
		this.configItemDataList = configItemDataList;
	}
	
	/**
	 * 机柜信息取得
	 * @return 机柜信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 机柜配置信息取得
	 * @return 机柜配置信息
	 */
	public List<IG002Info> getConfigItemDataList() {
		return configItemDataList;
	}
}


