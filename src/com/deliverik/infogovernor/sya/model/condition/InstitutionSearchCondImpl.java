/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model.condition;

/**
  * ����: ��Ч���˼�������ʵ��
  * ��������: ��Ч���˼�������ʵ��
  * ������¼: 2015/01/05
  * �޸ļ�¼: 
  */
public class InstitutionSearchCondImpl implements
		InstitutionSearchCond {

	/** �ƶ�����  */	
	protected String inname;

	/** ʱ�� */
	protected String createtime_from;
	
	protected String createtime_to;
	
	protected String niuserid;
	
	/** �Ǽ��˻������� */
	protected String niorgname;
	
	/** �ƶȷ���  */	
	public String intype;
	
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
	 * niuseridȡ��
	 * @return niuserid  niuserid
	 */
	public String getNiuserid() {
		return niuserid;
	}

	/**
	 * niuserid�趨
	 * @param niuserid  niuserid
	 */
	public void setNiuserid(String niuserid) {
		this.niuserid = niuserid;
	}

	/**
	 * �Ǽ��˻�������ȡ��
	 * @return niorgname  �Ǽ��˻�������
	 */
	public String getNiorgname() {
		return niorgname;
	}

	/**
	 * �Ǽ��˻��������趨
	 * @param niorgname  �Ǽ��˻�������
	 */
	public void setNiorgname(String niorgname) {
		this.niorgname = niorgname;
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