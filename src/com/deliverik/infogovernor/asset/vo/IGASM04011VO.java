package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 合同信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM04011VO extends BaseVO implements Serializable{
	
	/** 合同信息检索结果 */
	protected List<IG688Info> entityDataList;
	
	/** 合同信息检索结果 */
	protected List<IG499Info> entityItemCompactVWInfoList;
	
	/**
	 * 构造方法
	 */
	public IGASM04011VO() {
		super();
	}

	public List<IG499Info> getEntityItemCompactVWInfoList() {
		return entityItemCompactVWInfoList;
	}

	public void setEntityItemCompactVWInfoList(
			List<IG499Info> entityItemCompactVWInfoList) {
		this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
	}

	/**
	 * 构造函数
	 * @param entityData　合同信息检索结果
	 */
	public IGASM04011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 合同信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

}


