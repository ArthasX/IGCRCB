/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵���ģ�嵼������VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR10011VO extends BaseVO {

	/** ���̶�����Ϣ���� */
	protected List<IG380Info> processDefinitionList;

	/**
	 * ���̶�����Ϣ����ȡ��
	 * @return processDefinitionList ���̶�����Ϣ����
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * ���̶�����Ϣ�����趨
	 * @param processDefinitionList ���̶�����Ϣ����
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
}
