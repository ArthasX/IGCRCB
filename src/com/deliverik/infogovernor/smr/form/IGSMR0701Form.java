/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �����ڱ�����Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0701Form extends BaseForm{

	/** �����ʱ�� */
	protected String limittime;

	/** ��ע */
	protected String remark;
	
	/** Ҫ���������id���� */
	protected String pdids;
	
	/** �Ƿ���Է��� */
	protected String test;

	/**
	 *�����ʱ��ȡ��
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 *�����ʱ���趨
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 *��עȡ��
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 *��ע�趨
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 *Ҫ���������id����ȡ��
	 */
	public String getPdids() {
		return pdids;
	}

	/**
	 *Ҫ���������id�����趨
	 */
	public void setPdids(String pdids) {
		this.pdids = pdids;
	}

	/**
	 * �Ƿ���Է���ȡ��
	 * 
	 * @return �Ƿ���Է���
	 */
	public String getTest() {
		return test;
	}

	/**
	 * �Ƿ���Է����趨
	 * 
	 * @param test �Ƿ���Է���
	 */
	public void setTest(String test) {
		this.test = test;
	}
	
}
