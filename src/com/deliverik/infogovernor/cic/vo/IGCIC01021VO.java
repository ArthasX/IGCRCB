package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;

/**
 * 配置一致性比对
 *	对比规则查询画面VO
 * 
 */
@SuppressWarnings("serial")
public class IGCIC01021VO extends BaseVO implements Serializable{
	
	private List<CompareroleInfo> crList;
	
	private List<SOC0118Info> systemList;
	

	private CompareroleInfo compareRoleInfo;
	
	private String compareObjectListJson;
	
	private List<Map<String,String>> sourceHostList;
	private List<Map<String,String>> targetHostList;
	
	public List<Map<String, String>> getSourceHostList() {
		return sourceHostList;
	}

	public void setSourceHostList(List<Map<String, String>> sourceHostList) {
		this.sourceHostList = sourceHostList;
	}

	public List<Map<String, String>> getTargetHostList() {
		return targetHostList;
	}

	public void setTargetHostList(List<Map<String, String>> targetHostList) {
		this.targetHostList = targetHostList;
	}

	public List<SOC0118Info> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<SOC0118Info> systemList) {
		this.systemList = systemList;
	}

	public List<CompareroleInfo> getCrList() {
		return crList;
	}

	public void setCrList(List<CompareroleInfo> crList) {
		this.crList = crList;
	}

	public CompareroleInfo getCompareRoleInfo() {
		return compareRoleInfo;
	}

	public void setCompareRoleInfo(CompareroleInfo compareRoleInfo) {
		this.compareRoleInfo = compareRoleInfo;
	}

	public String getCompareObjectListJson() {
		return compareObjectListJson;
	}

	public void setCompareObjectListJson(String compareObjectListJson) {
		this.compareObjectListJson = compareObjectListJson;
	}


	
	

	
}


