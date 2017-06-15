/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG359Info;

/**
 * <p>����:�������Ͷ�����Ϣʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG359VW implements Serializable,
	Cloneable, IG359Info {
	/** �ʲ�ID*/
	@Id
	protected Integer prassetid;
	/** �ʲ�����*/
	protected String prassetname;
	/** �¼�*/
	protected Integer incident;
	/** ����*/
	protected Integer problem;
	/** ���*/
	protected Integer change;
	/** ����*/
	protected Integer deployment;
	/** ����*/
	protected Integer work;

	/**
	 * ���ܣ��ʲ�IDȡ��
	 * @return prassetid �ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���ܣ��ʲ�ID����
	 * @param prassetid �ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���ܣ��ʲ�����ȡ��
	 * @return prassetname �ʲ�����
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ���ܣ��ʲ���������
	 * @param prassetname �ʲ�����
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * ���ܣ��¼�ȡ��
	 * @return incident �¼�
	 */
	public Integer getIncident() {
		return incident;
	}

	/** 
	 * ���ܣ��¼�����
	 * @param incident �¼�
	 */
	public void setIncident(Integer incident) {
		this.incident = incident;
	}
	
	/**
	 * ���ܣ�����ȡ��
	 * @return problem ����
	 */
	public Integer getProblem() {
		return problem;
	}

	/**
	 * ���ܣ������趨
	 * @param problem ����
	 */
	public void setProblem(Integer problem) {
		this.problem = problem;
	}

	/**
	 * ���ܣ����ȡ��
	 * @return change ���
	 */
	public Integer getChange() {
		return change;
	}

	/**
	 * ���ܣ��������
	 * @param change ���
	 */
	public void setChange(Integer change) {
		this.change = change;
	}

	/**
	 * ���ܣ�����ȡ��
	 * @return deployment ����
	 */
	public Integer getDeployment() {
		return deployment;
	}

	/**
	 * ���ܣ���������
	 * @param deployment ����
	 */
	public void setDeployment(Integer deployment) {
		this.deployment = deployment;
	}

	/**
	 * ���ܣ�����ȡ��
	 * @return work ����
	 */
	public Integer getWork() {
		return work;
	}

	/**
	 * ���ܣ���������
	 * @param work ����
	 */
	public void setWork(Integer work) {
		this.work = work;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG359VW))
			return false;
		IG359Info target = (IG359Info) obj;
		if (!(getPrassetid() == target.getPrassetid()))
			return false;

		return true;
	}

}
