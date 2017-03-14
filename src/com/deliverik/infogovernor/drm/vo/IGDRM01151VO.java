/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 
 * 应急制度管理VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01151VO extends BaseVO implements Serializable {

	
	private String nodeMapJson;
	
	private SOC0118Info soc0118Info;
	
	private List<SOC0117Info> entityList;

	public List<SOC0117Info> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}

	public String getNodeMapJson() {
		return nodeMapJson;
	}

	public void setNodeMapJson(String nodeMapJson) {
		this.nodeMapJson = nodeMapJson;
	}
	
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}

}
