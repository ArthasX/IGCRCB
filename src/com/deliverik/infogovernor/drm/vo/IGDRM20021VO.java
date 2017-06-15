/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 概述:  
 * 功能描述:  
 * 创建记录:  
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGDRM20021VO extends BaseVO implements Serializable {
	
	private String planSectionTreeJson;

	public void setPlanSectionTreeJson(String planSectionTreeJson) {
		this.planSectionTreeJson = planSectionTreeJson;
	}

	public String getPlanSectionTreeJson() {
		return planSectionTreeJson;
	}
	
}
