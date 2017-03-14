package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;

public class IGPRM02011VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IG380Info processDefinition;
	
	private List<IG380Info> processDefinitionList;
	
	private List<IG259Info> processTemplateList;
	
	private Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
	
	public Map<IG259Info, List<IG380Info>> getMap() {
		return map;
	}

	public void setMap(Map<IG259Info, List<IG380Info>> map) {
		this.map = map;
	}

	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

}
