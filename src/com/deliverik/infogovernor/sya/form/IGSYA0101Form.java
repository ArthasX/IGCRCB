package com.deliverik.infogovernor.sya.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGSYA0101Form extends BaseForm{

	/** �ƶ�����  */	
	protected String inname;

	/** �ƶ�����  */	
	protected String indesc;
	
	/** ʱ�� */
	protected String createtime_from;
	
	protected String createtime_to;
	
	/** �Ǽ��˻������� */
	protected String paorgname;

	/** �ƶȷ���  */	
	public String intype;
	
	/**
	 * �Ǽ��˻�������ȡ��
	 * @return paorgname  �Ǽ��˻�������
	 */
	public String getPaorgname() {
		return paorgname;
	}

	/**
	 * �Ǽ��˻��������趨
	 * @param paorgname  �Ǽ��˻�������
	 */
	public void setPaorgname(String paorgname) {
		this.paorgname = paorgname;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return inname  �ƶ�����
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * �ƶ������趨
	 * @param inname  �ƶ�����
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return indesc  �ƶ�����
	 */
	public String getIndesc() {
		return indesc;
	}

	/**
	 * �ƶ������趨
	 * @param indesc  �ƶ�����
	 */
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

	/**
	 * ʱ��ȡ��
	 * @return createtime_from  ʱ��
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}

	/**
	 * ʱ���趨
	 * @param createtime_from  ʱ��
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}

	/**
	 * createtime_toȡ��
	 * @return createtime_to  createtime_to
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}

	/**
	 * createtime_to�趨
	 * @param createtime_to  createtime_to
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}

	/**
	 * �ƶȷ���ȡ��
	 * @return intype  �ƶȷ���
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * �ƶȷ����趨
	 * @param intype  �ƶȷ���
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}

	
	
}
