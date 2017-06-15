/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 
 * Description: 组合场景查询VO
 * 
 */

@SuppressWarnings("serial")
public class IGDRM02011VO extends BaseVO implements Serializable {

	/** 场景资产List */
	protected List<SOC0124Info> entityItemVWInfoList ;

	/**
	 * @return the 场景资产List
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * @param 场景资产List the entityItemVWInfoList to set
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
}
