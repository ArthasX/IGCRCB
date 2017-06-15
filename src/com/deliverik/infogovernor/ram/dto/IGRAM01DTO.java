package com.deliverik.infogovernor.ram.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 风险评估DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM01DTO extends BaseDTO implements Serializable{
	
	/** 风险评估流程类型id */
	protected String ptid;
	
	/** 风险评估流程类型集合 */
	protected List<IG380Info> ig380List;
	
	/**工作定义集合*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**
	 * ptid取得
	 */
	public String getPtid() {
		return ptid;
	}

	/**
	 * ptid设定
	 */
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	/**
	 * ig380List取得
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 * ig380List设定
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}

	/**
	 * templateDefinitionMap取得
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}

	/**
	 * templateDefinitionMap设定
	 */
	public void setTemplateDefinitionMap(
			Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
		
}


