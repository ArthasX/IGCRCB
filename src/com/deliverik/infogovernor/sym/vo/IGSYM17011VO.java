/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * ����: ���̶�����Ϣ��������֣�
 * �������������̶�����Ϣ��������֣�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM17011VO extends BaseVO implements Serializable{
	
	/** ���̶�����Ϣ������� */
	protected List<IG380Info> processDefinitionList;

	/**
	 * ���캯��
	 * @param processDefinition�����̶�����Ϣ�������
	 */
	public IGSYM17011VO(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
	
	/**
	 * ���̶�����Ϣ�������ȡ��
	 * @return ���̶�����Ϣ�������
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

}


