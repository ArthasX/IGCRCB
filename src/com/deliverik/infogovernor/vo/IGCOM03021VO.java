package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * IGCOM03021VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03021VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<IG688Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGCOM03021VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}	

}


