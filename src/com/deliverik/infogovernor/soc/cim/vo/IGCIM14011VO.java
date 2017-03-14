package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 人员信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM14011VO extends BaseVO implements Serializable{
	
	/** 人员信息检索结果 */
	protected List<SOC0124Info> entityDataList;
	

	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

	public void setEntityDataList(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}


}


