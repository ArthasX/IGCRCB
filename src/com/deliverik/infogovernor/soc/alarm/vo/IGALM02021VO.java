package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
//VO
public class IGALM02021VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CRM08Info> crm08InfoList;

	public List<CRM08Info> getCrm08InfoList() {
		return crm08InfoList;
	}

	public void setCrm08InfoList(List<CRM08Info> crm08InfoList) {
		this.crm08InfoList = crm08InfoList;
	}

}
