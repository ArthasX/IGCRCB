/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.RecptionGuest;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ����˵ǼǱ��Form
 *
 */
public class IGLOM0102Form extends BaseForm  implements RecptionGuest {
	
	
	private static final long serialVersionUID = 1L;

	/** �Ӵ�����ID */
	protected Integer rgid;

	/** �Ӵ�����ID */
	public Integer rid;
	
	/** �Ӵ��������� */
	public String rgname;
	
	/** �Ӵ�����ְ�� */
	public String rgpost;
	
	/** �Ӵ����˵�λ */
	public String rgunit;
	
	/** �Ӵ�������ϵ��ʽ */
	public String rgtel;
	
	/** �Ǽ����� */
	public String rgdate;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";

	
	


	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRgid() {
		return rgid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rgid �Ӵ�����ID
	 */
	public void setRgid(Integer rgid) {
		this.rgid = rgid;
	}

	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rgid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * �Ӵ���������ȡ��
	 * @return �Ӵ���������
	 */
	public String getRgname() {
		return rgname;
	}

	/**
	 * �Ӵ����������趨
	 * @param rgname �Ӵ���������
	 */
	public void setRgname(String rgname) {
		this.rgname = rgname;
	}

	/**
	 * �Ӵ�����ְ��ȡ��
	 * @return �Ӵ�����ְ��
	 */
	public String getRgpost() {
		return rgpost;
	}

	/**
	 * �Ӵ�����ְ���趨
	 * @param rgpost �Ӵ�����ְ��
	 */
	public void setRgpost(String rgpost) {
		this.rgpost = rgpost;
	}

	/**
	 * �Ӵ����˵�λȡ��
	 * @return �Ӵ����˵�λ
	 */
	public String getRgunit() {
		return rgunit;
	}

	/**
	 * �Ӵ����˵�λ�趨
	 * @param rgunit �Ӵ����˵�λ
	 */
	public void setRgunit(String rgunit) {
		this.rgunit = rgunit;
	}

	/**
	 * �Ӵ�������ϵ��ʽȡ��
	 * @return �Ӵ�������ϵ��ʽ
	 */
	public String getRgtel() {
		return rgtel;
	}

	/**
	 * �Ӵ�������ϵ��ʽ�趨
	 * @param rgtel �Ӵ�������ϵ��ʽ
	 */
	public void setRgtel(String rgtel) {
		this.rgtel = rgtel;
	}

	/**
	 * �Ǽ�����ȡ��
	 * @return �Ǽ�����
	 */
	public String getRgdate() {
		return rgdate;
	}

	/**
	 * �Ǽ������趨
	 * @param rgdate �Ǽ�����
	 */
	public void setRgdate(String rgdate) {
		this.rgdate = rgdate;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ҳ�������ʾȡ��
	 * @return ҳ�������ʾ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ�������ʾ�趨
	 * @param mode ҳ�������ʾ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}



}
