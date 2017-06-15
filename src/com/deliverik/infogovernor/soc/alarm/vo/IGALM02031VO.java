package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;
//VO
public class IGALM02031VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//规则条件集合
	private List<CRM07TB> crm07TBList;
	
	public List<CRM07TB> getCrm07TBList() {
		return crm07TBList;
	}

	public void setCrm07TBList(List<CRM07TB> crm07TBList) {
		this.crm07TBList = crm07TBList;
	}

}
