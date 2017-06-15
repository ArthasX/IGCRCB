package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0601Info;

/**
 * 机房信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11011VO extends BaseVO implements Serializable{
	
	/** 机房信息检索结果 */
	protected List<SOC0601Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　机房信息检索结果
	 */
	public IGASM11011VO(List<SOC0601Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 机房信息检索结果取得
	 * @return 机房信息检索结果
	 */
	public List<SOC0601Info> getEntityDataList() {
		return entityDataList;
	}

}


