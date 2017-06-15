package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;

public class IGALM03011VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 监控对象视图列表 */
	protected List<CRM06VWInfo> crm06InfoList;
	
	protected String flag;
	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<CRM06VWInfo> getCrm06InfoList() {
		return crm06InfoList;
	}

	public void setCrm06InfoList(List<CRM06VWInfo> crm06InfoList) {
		this.crm06InfoList = crm06InfoList;
	}
	
	
}
