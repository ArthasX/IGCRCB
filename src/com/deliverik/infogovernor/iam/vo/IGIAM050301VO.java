/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������Ĺ���_��ѯVO
 * </p>
 * 
 * @author huiyongzhi
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGIAM050301VO extends BaseVO implements Serializable {

	/**
	 * �������Ķ���List
	 */
	
	protected List<IG500Info> processList;
	protected Map<String,String> nameURLMap;
	
	protected List<IG259Info> processTemplateList;
	
	protected List<IG380Info> processDefinitionList;
	
	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}
	
	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ���췽��
	 * @param processList List<ProcessRecord>
	 */
	
	public IGIAM050301VO(List<IG500Info> processList) {
		this.processList = processList;
	}
	public IGIAM050301VO() {
	}
	
	/**
	 * ��ȡ�������Ķ���List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessList() {
		return processList;
	}
}
