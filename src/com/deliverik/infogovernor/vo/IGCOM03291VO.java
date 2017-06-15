package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * IGCOM03027VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03291VO extends BaseVO implements Serializable{
	
	/**  */
	protected List<SOC0124Info> entityDataList;
	
	protected List<SOC0118Info> soc0118List;

	/**
	 * 
	 * @param entityData
	 */
	public IGCOM03291VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	public IGCOM03291VO() {
	}
	
	/**
	 * 
	 * @return 
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

}


