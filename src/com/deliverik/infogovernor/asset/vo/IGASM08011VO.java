package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 应用信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM08011VO extends BaseVO implements Serializable{
	
	/** 应用信息检索结果 */
	protected List<SOC0124Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　应用信息检索结果
	 */
	public IGASM08011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 应用信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


