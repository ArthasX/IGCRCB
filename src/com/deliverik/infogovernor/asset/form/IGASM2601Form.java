/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @author Administrator
 *
 */
/**
 * ����: 
 * ����������
 * �����ˣ�����
 * ������¼�� 2012-8-1
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM2601Form extends BaseForm {

	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;

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
	
	/** ��˾���� */
	protected String aptitude;

	/** �ɹ����� */
	protected String succeedcase;
	
	/**
	 * ��ȡbeginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * ����beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * ��ȡendTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * ����endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	/**
	 * ��ȡeiname
	 * @return feiname einame
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����einame
	 * @param einame  einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��ȡaddress
	 * @return faddress address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * ����address
	 * @param address  address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * ��ȡlinkman
	 * @return flinkman linkman
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * ����linkman
	 * @param linkman  linkman
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * ��ȡphone
	 * @return fphone phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * ����phone
	 * @param phone  phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * ��ȡfund
	 * @return ffund fund
	 */
	public String getFund() {
		return fund;
	}

	/**
	 * ����fund
	 * @param fund  fund
	 */
	public void setFund(String fund) {
		this.fund = fund;
	}

	/**
	 * ��ȡaptitude
	 * @return faptitude aptitude
	 */
	public String getAptitude() {
		return aptitude;
	}

	/**
	 * ����aptitude
	 * @param aptitude  aptitude
	 */
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	/**
	 * ��ȡsucceedcase
	 * @return fsucceedcase succeedcase
	 */
	public String getSucceedcase() {
		return succeedcase;
	}

	/**
	 * ����succeedcase
	 * @param succeedcase  succeedcase
	 */
	public void setSucceedcase(String succeedcase) {
		this.succeedcase = succeedcase;
	}
}
