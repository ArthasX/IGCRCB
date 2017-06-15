/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG160Info;

/**
 * <p>����:���������Ա����ͳ����ͼʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG160VW implements Serializable,
	Cloneable, IG160Info {
	@Id
	/** �û�ID*/
	protected String ppuserid;
	/** �û���*/
	protected String ppusername;
	/** ����id*/
	protected String orgid;
	/** ��������*/
	protected String orgname;
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
	/** ����*/
	protected Integer ask;
	/**
	 * ���ܣ���������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���ܣ����������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * ���ܣ�����趨
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
	 * ���ܣ������趨
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
	 * ���ܣ������趨
	 * @param work ����
	 */
	public void setWork(Integer work) {
		this.work = work;
	}
	/**
	 * ���ܣ�����ȡ��
	 * @return ask ����
	 */
	public Integer getAsk() {
		return ask;
	}
	/**
	 * ���ܣ���������
	 * @return ask ����
	 */
	public void setAsk(Integer ask) {
		this.ask = ask;
	}
	/**
	 * ���ܣ�����IDȡ��
	 * @return orgid ����ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ���ܣ�����ID�趨
	 * @param orgid ����ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ���ܣ��û�IDȡ��
	 * @return ppuserid �û�ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���ܣ��û�ID�趨
	 * @param ppuserid �û�ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ���ܣ��û�����ȡ��
	 * @return ppusername �û�����
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * ���ܣ��û������趨
	 * @param ppusername �û�����
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG160VW))
			return false;
		IG160Info target = (IG160Info) obj;
		if (!(getPpuserid() == target.getPpuserid()))
			return false;

		return true;
	}

}
