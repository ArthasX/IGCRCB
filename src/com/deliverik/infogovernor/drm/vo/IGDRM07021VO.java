package com.deliverik.infogovernor.drm.vo;

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
public class IGDRM07021VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<SOC0124Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGDRM07021VO(List<SOC0124Info> entityDataList) {
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


