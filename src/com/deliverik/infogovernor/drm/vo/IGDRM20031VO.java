/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * 概述:  
 * 功能描述:  
 * 创建记录:  
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGDRM20031VO extends BaseVO implements Serializable {
	
	private List<SOC0117Info> entityDataList;

	public List<SOC0117Info> getEntityDataList() {
		return entityDataList;
	}

	public void setEntityDataList(List<SOC0117Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
}
