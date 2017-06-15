package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * IGCOM03021VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03271VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<SOC0124Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGCOM03271VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


