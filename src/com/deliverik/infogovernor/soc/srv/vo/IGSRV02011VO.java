/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSRV02011VO extends BaseVO implements Serializable {

	/**
	 * �¼�����List
	 */
	
	protected List<IG500Info> processList;
	
	/**
	 * ��������List
	 */
	protected List<IG380Info> processDefinitionList;

	/**
	 * ���췽��
	 * @param incidentList List<ProcessRecord>
	 */
	
	public IGSRV02011VO(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	/**
	 * ��ȡ�¼�����List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessList() {
		return processList;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
}
