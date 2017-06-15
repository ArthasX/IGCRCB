package com.deliverik.infogovernor.ram.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * ��������DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM01DTO extends BaseDTO implements Serializable{
	
	/** ����������������id */
	protected String ptid;
	
	/** ���������������ͼ��� */
	protected List<IG380Info> ig380List;
	
	/**�������弯��*/
	private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
	
	/**
	 * ptidȡ��
	 */
	public String getPtid() {
		return ptid;
	}

	/**
	 * ptid�趨
	 */
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	/**
	 * ig380Listȡ��
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 * ig380List�趨
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}

	/**
	 * templateDefinitionMapȡ��
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}

	/**
	 * templateDefinitionMap�趨
	 */
	public void setTemplateDefinitionMap(
			Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
		
}


