/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ���չ�����ʾ���������ݱ��������ʵ��
  * ��������: ���չ�����ʾ���������ݱ��������ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class AcceptuserSearchCondImpl implements
		AcceptuserSearchCond {
	
	/** ������id */
	protected String apuserid;
	/** ���������� */
	protected String apusername;

	/** ���ջ����� */
	protected String aporgid;

	/** ���ջ������� */
	protected String aporgname;

	/** ������ʾ���� */
	protected Integer rwid;

	/**
	 * ����������ȡ��
	 * @return apusername ����������
	 */
	
	public String getApusername() {
		return apusername;
	}

	/**
	 * �����������趨
	 * @param apusername ����������
	 */
	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * ���ջ�����ȡ��
	 * @return aporgid ���ջ�����
	 */
	
	public String getAporgid() {
		return aporgid;
	}

	/**
	 * ���ջ������趨
	 * @param aporgid ���ջ�����
	 */
	public void setAporgid(String aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * ���ջ�������ȡ��
	 * @return aporgname ���ջ�������
	 */
	
	public String getAporgname() {
		return aporgname;
	}

	/**
	 * ���ջ��������趨
	 * @param aporgname ���ջ�������
	 */
	public void setAporgname(String aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * ������ʾ����ȡ��
	 * @return rwid ������ʾ����
	 */
	
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * ������ʾ�����趨
	 * @param rwid ������ʾ����
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	public String getApuserid() {
		return null;
	}

	/**
	 * ������id�趨
	 * @param apuserid ������id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}
}