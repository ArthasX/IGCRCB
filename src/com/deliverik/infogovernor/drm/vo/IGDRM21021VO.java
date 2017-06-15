package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

/**
 * 设备登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM21021VO extends BaseVO implements Serializable{

	private SOC0124Info entityItemVWInfo;
	
	private String planSectionTreeJson;
	
	private Boolean flag;
	private String eiorgname;

	private Map<String, SOC0509Info> treeMap;

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public String getPlanSectionTreeJson() {
		return planSectionTreeJson;
	}

	public void setPlanSectionTreeJson(String planSectionTreeJson) {
		this.planSectionTreeJson = planSectionTreeJson;
	}

	public void setTreeMap(Map<String, SOC0509Info> treeMap) {
		this.treeMap = treeMap;
	}

	public Map<String, SOC0509Info> getTreeMap() {
		return treeMap;
	}
	
}


