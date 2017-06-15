package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 资产项信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM10011VO extends BaseVO implements Serializable{
	
	/** 资产项信息检索结果 */
	protected List<IG688Info> entityDataList;
	protected List<SOC0124Info> socEntityDataList;

	/**
	 * 构造函数
	 * @param entityData　资产项信息检索结果
	 */
	public IGASM10011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	public IGASM10011VO(){
		
	}
	
	/**
	 * 资产项信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

	public List<SOC0124Info> getSocEntityDataList() {
		return socEntityDataList;
	}

	public void setSocEntityDataList(List<SOC0124Info> socEntityDataList) {
		this.socEntityDataList = socEntityDataList;
	}
	
	

}


