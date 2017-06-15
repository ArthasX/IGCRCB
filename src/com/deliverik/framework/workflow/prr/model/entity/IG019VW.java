package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG019Info;

/**
 * <p>
 * �����ϱ�ͳ����Ϣʵ�壨ƽ̨������
 * </p>
 */
@SuppressWarnings("serial")
@Entity
public class IG019VW implements Serializable,
	Cloneable, IG019Info {
	@Id
	/** ��������루�¼�����ȡ�ϱ��˻�����������������ȡ�����˻����� */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgname;

	/** �¼����̸��� */
	protected Integer incident;

	/** �����������̸��� */
	protected Integer serviceRequest;
	
	/** �������� */
	protected Integer count;
	
	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �¼����̸���ȡ��
	 * @return �¼����̸���
	 */
	public Integer getIncident() {
		return incident;
	}

	/**
	 * �¼����̸����趨
	 *
	 * @param incident �¼����̸���
	 */
	public void setIncident(Integer incident) {
		this.incident = incident;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public Integer getServiceRequest() {
		return serviceRequest;
	}

	/**
	 * ������������趨
	 *
	 * @param serviceRequest �����������
	 */
	public void setServiceRequest(Integer serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * ���������趨
	 *
	 * @param count ��������
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG019VW))
			return false;
		IG019Info target = (IG019Info) obj;
		if (!(getOrgsyscoding() == target.getOrgsyscoding()))
			return false;

		return true;
	}

}
