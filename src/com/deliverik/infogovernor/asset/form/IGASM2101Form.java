/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ��ƿ���̨��ʾFORM
 * ��������: ��ƿ���̨��ʾFORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM2101Form extends BaseForm {
	
	/** ����ѡ�� */
	protected String[] auwtids;

	/** ����״̬�Ƿ���� */
	protected String taskDone;
	
	/** �������ID */
	protected Integer autid;
	
	/**
	 * ����ѡ��ȡ��
	 * 
	 * @return ����ѡ��
	 */
	public String[] getAuwtids() {
		return auwtids;
	}

	/**
	 * ����ѡ���趨
	 * 
	 * @param auwtids ����ѡ��
	 */
	public void setAuwtids(String[] auwtids) {
		this.auwtids = auwtids;
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
		this.auwtids = null;
	}

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

}
