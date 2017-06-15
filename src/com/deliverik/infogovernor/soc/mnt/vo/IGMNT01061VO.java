package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * IGMNT01061VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGMNT01061VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<SOC0124Info> entityDataList;

	/**
	 * 
	 * @param entityData
	 */
	public IGMNT01061VO(List<SOC0124Info> entityDataList) {
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


