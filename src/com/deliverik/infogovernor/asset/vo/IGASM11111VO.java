package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * 机柜信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11111VO extends BaseVO implements Serializable{
	
	/** 机柜信息检索结果 */
	protected List<SOC0603Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　机柜信息检索结果
	 */
	public IGASM11111VO(List<SOC0603Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 机柜信息检索结果取得
	 * @return 机柜信息检索结果
	 */
	public List<SOC0603Info> getEntityDataList() {
		return entityDataList;
	}

}


