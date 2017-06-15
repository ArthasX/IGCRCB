/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵���DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR10DTO extends BaseDTO{

	/** ���̶�����Ϣ���� */
	protected List<IG380Info> processDefinitionList;
	
	/** ��Ӧ���� */
	protected HttpServletResponse response;

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

	/**
	 * ��Ӧ����ȡ��
	 * @return response ��Ӧ����
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * ��Ӧ�����趨
	 * @param response ��Ӧ����
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
