/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
 * 
 * 场景资产查询页面VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01041VO extends BaseVO implements Serializable {

	private List<SOC0109Info> configItemList;
	
	private List<List<CodeDetail>> codeList;
	
	private List<PlanInfo> planList;
	
	private List<LabelValueBean> planTypeValues;
	
	private String nodeMapJson;
	
	private SOC0118Info soc0118Info;
	
	private String cycleTime;
	/** 设备ID */
	private String eiid;

	public void setPlanList(List<PlanInfo> planList) {
		this.planList = planList;
	}

	public List<List<CodeDetail>> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<List<CodeDetail>> codeList) {
		this.codeList = codeList;
	}

	public List<SOC0109Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0109Info> configItemList) {
		this.configItemList = configItemList;
	}

	public List<LabelValueBean> getPlanTypeValues() {
		return planTypeValues;
	}

	public void setPlanTypeValues(List<LabelValueBean> planTypeValues) {
		this.planTypeValues = planTypeValues;
	}

	public List<PlanInfo> getPlanList() {
		return planList;
	}

	public String getNodeMapJson() {
		return nodeMapJson;
	}

	public void setNodeMapJson(String nodeMapJson) {
		this.nodeMapJson = nodeMapJson;
	}
	
	public String getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(String cycleTime) {
		this.cycleTime = cycleTime;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}

}
