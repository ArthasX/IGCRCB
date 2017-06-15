package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;

public class IGPRM01011VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IG259Info processTemplate;
	
	private List<IG259Info> processTemplateList;

	public IG259Info getProcessTemplate() {
		return processTemplate;
	}

	public void setProcessTemplate(IG259Info processTemplate) {
		this.processTemplate = processTemplate;
	}

	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

}
