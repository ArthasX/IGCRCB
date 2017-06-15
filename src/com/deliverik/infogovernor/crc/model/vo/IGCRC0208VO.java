/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.model.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼���ѯ_��ѯVO
 * </p>
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC0208VO extends BaseVO implements Serializable {

	/**
	 * �������List
	 */
	
	protected List<IGCRC0208VWInfo> processList;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG259Info> processTemplateList;
	
	protected List<IG380Info> processDefinitionList;
	
	/** ���е�ǰ�����˵ı��¹��� */
	protected List<CurrentMonthWorkVWInfo> currentManagerList;
	
	/** �����˵����� */
	protected String actlabel;

	/**
	 * �����˵�����ȡ��
	 *
	 * @return actlabel �����˵�����
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * �����˵������趨
	 *
	 * @param actlabel �����˵�����
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

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

	/**
	 * ���췽��
	 * @param processList List<ProcessRecord>
	 */
	
	public IGCRC0208VO(List<IGCRC0208VWInfo> processList) {
		this.processList = processList;
	}
	
	public IGCRC0208VO() {
	}
	
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ��ȡ�������List
	 * @return List<ProcessRecord>
	 */
	
	public List<IGCRC0208VWInfo> getProcessList() {
		return processList;
	}
	
	/**
	 * ���е�ǰ�����˵ı��¹���ȡ��
	 * @return ���е�ǰ�����˵ı��¹���
	 */
	public List<CurrentMonthWorkVWInfo> getCurrentManagerList() {
		return currentManagerList;
	}

	/**
	 * ���е�ǰ�����˵ı��¹����趨
	 * @param currentManagerList ���е�ǰ�����˵ı��¹���
	 */
	public void setCurrentManagerList(
			List<CurrentMonthWorkVWInfo> currentManagerList) {
		this.currentManagerList = currentManagerList;
	}
}
