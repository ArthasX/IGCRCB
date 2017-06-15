/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * ���̶�����Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01011VO extends BaseVO implements Serializable{
	
	/** ���̶�����Ϣ������� */
	protected List<IG380Info> processDefinitionList;
	
	/**
	 * ���캯��
	 * @param processDefinition�����̶�����Ϣ�������
	 */
	public IGPRD01011VO(List<IG380Info> processDefinitionList) {
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


