/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: CI�������̨��ʾFORM
 * ��������: CI�������̨��ʾFORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM2201Form extends BaseForm {
	
	/** ����ѡ�� */
	protected String[] ciwtids;

	/** ����״̬�Ƿ���� */
	protected String taskDone;
	
	/**
	 * ����ѡ��ȡ��
	 * 
	 * @return ����ѡ��
	 */
	public String[] getCiwtids() {
		return ciwtids;
	}

	/**
	 * ����ѡ���趨
	 * 
	 * @param ciwtids ����ѡ��
	 */
	public void setCiwtids(String[] ciwtids) {
		this.ciwtids = ciwtids;
	}

	/**
	 * ����״̬�Ƿ����ȡ��
	 * 
	 * @return ����״̬�Ƿ����
	 */
	public String getTaskDone() {
		return taskDone;
	}

	/**
	 * ����״̬�Ƿ�����趨
	 * 
	 * @param ����״̬�Ƿ����
	 */
	public void setTaskDone(String taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.taskDone = "0";//Ĭ�ϲ�ѯδ���
		this.ciwtids = null;
	}

}
