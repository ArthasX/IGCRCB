/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM09041VO extends BaseVO implements Serializable {

	public IGDRM09041VO() {

	}

	public IGDRM09041VO(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	protected List<IG380Info> processDefinitionList;

	/**
	 * processDefinitionList ȡ��
	 * 
	 * @return processDefinitionList processDefinitionList
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * processDefinitionList �趨
	 * 
	 * @param processDefinitionList
	 *            processDefinitionList
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

}
