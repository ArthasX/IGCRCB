package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 机房历史纪录信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM07051VO extends BaseVO implements Serializable{
	
	/** 机房信息 */
	protected IG688Info entityItemData;
	
	/** 机房配置信息 */
	protected List<IG800Info> voDataList;

	/**
	 * 构造函数
	 * @param entityItemData　机房信息
	 * @param configItemDataList　机房配置信息
	 */
	public IGASM07051VO(IG688Info entityItemData,List<IG800Info> configItemDataList) {
		this.entityItemData = entityItemData;
		this.voDataList = configItemDataList;
	}
	
	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 机房配置信息取得
	 * @return 机房配置信息
	 */
	public List<IG800Info> getVoDataList() {
		return voDataList;
	}
}


