package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;

/**
 * 配置一致性比对
 *	对比规则查询画面VO
 * 
 */
@SuppressWarnings("serial")
public class IGCIC01011VO extends BaseVO implements Serializable{
	
	private List<CompareroleInfo> crList;
	
	private List<SOC0118Info> systemList;
	
	private List<SOC0151Info> environmentTypeList;
	
	private List<SOC0118Info> sourceHostList;
	
	private List<SOC0118Info> targetHostList;

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

	public List<SOC0151Info> getEnvironmentTypeList() {
		return environmentTypeList;
	}

	public void setEnvironmentTypeList(List<SOC0151Info> environmentTypeList) {
		this.environmentTypeList = environmentTypeList;
	}

	public List<SOC0118Info> getSourceHostList() {
		return sourceHostList;
	}

	public void setSourceHostList(List<SOC0118Info> sourceHostList) {
		this.sourceHostList = sourceHostList;
	}

	public List<SOC0118Info> getTargetHostList() {
		return targetHostList;
	}

	public void setTargetHostList(List<SOC0118Info> targetHostList) {
		this.targetHostList = targetHostList;
	}
	
	

	
}


