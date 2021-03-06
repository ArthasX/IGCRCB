package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 机房信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM07011VO extends BaseVO implements Serializable{
	
	/** 机房信息检索结果 */
	protected List<IG688Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　机房信息检索结果
	 */
	public IGASM07011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 机房信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

}


