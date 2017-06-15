package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;

public class IGSVC06011VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private List<IG259Info> processTemplateList;

	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}


}
