/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG787Info;

/**
 * <p>����:���̹�ͨ������Ϣʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG787VW implements Serializable,Cloneable, IG787Info {
	/**
	 * ���̼�¼ID
	 */
	@Id
	protected Integer prid;
	
	
	/**
	 * ��ͨ��������
	 */
	protected String generalname;
	
	/**
	 * ��ͨ����ID
	 */
	protected Integer pidgid;
	
	/**
	 * ��ͨ����ֵ
	 */
	protected String generalvalue;
	
	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return prid ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ����̼�¼ID����
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ܣ���ͨ��������ȡ��
	 * @return generalname ��ͨ��������
	 */
	public String getGeneralname() {
		return generalname;
	}

	/**
	 * ���ܣ���ͨ������������
	 * @param generalname ��ͨ��������
	 */
	public void setGeneralname(String generalname) {
		this.generalname = generalname;
	}

	/** 
	 * ���ܣ���ͨ����IDȡ��
	 * @return pidgid ��ͨ����ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}

	/**
	 * ���ܣ���ͨ����ID����
	 * @param pidgid ��ͨ����ID
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * ���ܣ���ͨ����ֵȡ��
	 * @return generalvalue ��ͨ����ֵ
	 */
	public String getGeneralvalue() {
		return generalvalue;
	}

	/**
	 * ���ܣ���ͨ����ֵ����
	 * @param generalvalue ��ͨ����ֵ
	 */
	public void setGeneralvalue(String generalvalue) {
		this.generalvalue = generalvalue;
	}

	
	
}
