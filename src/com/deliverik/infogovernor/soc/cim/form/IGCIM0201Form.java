/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����̨��ʾFORM
 * ��������: ����̨��ʾFORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0201Form extends BaseForm {
	
	/** ����ѡ�� */
	protected String[] eitids;

	/** ����״̬�Ƿ���� */
	protected String taskDone;
	
	/** ��ѯ״̬ */
	protected String status;

	/** ��ѯ�����ۼ� */
	protected boolean taskError; 

	protected boolean taskToDos; 
	
	protected boolean taskBeing; 
	
	protected boolean taskDoness; 
	
	protected boolean taskAgnore;
	
	/** ���²ɼ�ʱ�� */
	protected String impcreatetime_s;
	
	/** ���²ɼ�ʱ�� */
	protected String impcreatetime_e;
	
	/**
	 * ����ѡ��ȡ��
	 * 
	 * @return ����ѡ��
	 */
	public String[] getEitids() {
		return eitids;
	}

	/**
	 * ����ѡ���趨
	 * 
	 * @param eitids ����ѡ��
	 */
	public void setEitids(String[] eitids) {
		this.eitids = eitids;
	}

	/**
	 * ����״̬�Ƿ����ȡ��
	 * 
	 * @return ����״̬�Ƿ����
	 */
	public String getTaskDone() {
		return taskDone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean getTaskError() {
		return taskError;
	}

	public void setTaskError(boolean taskError) {
		this.taskError = taskError;
	}

	public boolean getTaskToDos() {
		return taskToDos;
	}

	public void setTaskToDos(boolean taskToDos) {
		this.taskToDos = taskToDos;
	}

	public boolean getTaskBeing() {
		return taskBeing;
	}

	public void setTaskBeing(boolean taskBeing) {
		this.taskBeing = taskBeing;
	}

	public boolean getTaskDoness() {
		return taskDoness;
	}

	public void setTaskDoness(boolean taskDoness) {
		this.taskDoness = taskDoness;
	}

	public boolean getTaskAgnore() {
		return taskAgnore;
	}

	public void setTaskAgnore(boolean taskAgnore) {
		this.taskAgnore = taskAgnore;
	}
	
	public String getImpcreatetime_s() {
		return impcreatetime_s;
	}

	public void setImpcreatetime_s(String impcreatetime_s) {
		this.impcreatetime_s = impcreatetime_s;
	}

	public String getImpcreatetime_e() {
		return impcreatetime_e;
	}

	public void setImpcreatetime_e(String impcreatetime_e) {
		this.impcreatetime_e = impcreatetime_e;
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
		this.status = "1,2";
		this.eitids = null;
	}

}
