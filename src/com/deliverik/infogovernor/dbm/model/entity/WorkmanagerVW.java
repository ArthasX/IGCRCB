/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * ����: ��������ʵ��
  * ��������: ��������ʵ��
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class WorkmanagerVW implements Serializable {

	/** ���� */
	@Id
	protected Integer wmid;
	
	/** �������� */
	protected String wmname;

	/** ������id */
	protected String wmuserid;

	/** ���������� */
	protected String wmusername;

	/**
	 * @return the ����
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param ���� the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the ������id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * @param ������id the wmuserid to set
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * @return the ����������
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param ���������� the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the ��������
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param �������� the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

}