/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG342Info;

/**
  * ����: IG342VWʵ��
  * ��������: IG342VWʵ��
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class IG342VW implements Serializable,Cloneable, IG342Info {

	@Id
	/** ��λ��� */
	protected Integer eiid;

	/** ��λ���� */
	protected String einame;

	/** ��ַ */
	protected String address;

	/** ��ϵ�� */
	protected String linkman;

	/** ��ϵ��ʽ */
	protected String phone;

	/** ע���ʽ� */
	protected String fund;

	/** �Ǽ�ʱ�� */
	protected String eiinsdate;
	
	/** �޸�ʱ�� */
	protected String eiupdtime;

	/** �Ƿ�������Դ�� */
	protected String civalue;

	/** ��˾���� */
	protected String aptitude;

	/** �ɹ����� */
	protected String succeedcase;

	/**
	 * ��λ���ȡ��
	 *
	 * @return ��λ���
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ��λ����趨
	 *
	 * @param eiid ��λ���
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��λ����ȡ��
	 *
	 * @return ��λ����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��λ�����趨
	 *
	 * @param einame ��λ����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��ַȡ��
	 *
	 * @return ��ַ
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * ��ַ�趨
	 *
	 * @param address ��ַ
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * ��ϵ��ȡ��
	 *
	 * @return ��ϵ��
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param linkman ��ϵ��
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * ��ϵ��ʽȡ��
	 *
	 * @return ��ϵ��ʽ
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * ��ϵ��ʽ�趨
	 *
	 * @param phone ��ϵ��ʽ
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * ע���ʽ�ȡ��
	 *
	 * @return ע���ʽ�
	 */
	public String getFund() {
		return fund;
	}

	/**
	 * ע���ʽ��趨
	 *
	 * @param fund ע���ʽ�
	 */
	public void setFund(String fund) {
		this.fund = fund;
	}

	

	public String getEiinsdate() {
		return eiinsdate;
	}

	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	
	/**
	 * �޸�ʱ��ȡ��
	 *
	 * @return �޸�ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �޸�ʱ���趨
	 *
	 * @param eiupdtime �޸�ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �Ƿ�������Դ��ȡ��
	 *
	 * @return �Ƿ�������Դ��
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * �Ƿ�������Դ���趨
	 *
	 * @param civalue �Ƿ�������Դ��
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * ��˾����ȡ��
	 *
	 * @return ��˾����
	 */
	public String getAptitude() {
		return aptitude;
	}

	/**
	 * ��˾�����趨
	 *
	 * @param aptitude ��˾����
	 */
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	/**
	 * �ɹ�����ȡ��
	 *
	 * @return �ɹ�����
	 */
	public String getSucceedcase() {
		return succeedcase;
	}

	/**
	 * �ɹ������趨
	 *
	 * @param succeedcase �ɹ�����
	 */
	public void setSucceedcase(String succeedcase) {
		this.succeedcase = succeedcase;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return this.eiid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.base.BaseModel#getFingerPrint()
	 */
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}