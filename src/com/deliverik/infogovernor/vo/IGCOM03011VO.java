package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.base.BaseVO;

/**
 * IGCOM03011VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03011VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<IG117Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGCOM03011VO(List<IG117Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<IG117Info> getEntityDataList() {
		return entityDataList;
	}

}


