/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ֵ������Ϣ��ѯ�����ӿ�ʵ��
 */
public class DutyAuditDefSearchCondImpl implements DutyAuditDefSearchCond{
	
	/**
	 * ������
	 */
	protected String dadtype;
	
	/**
	 * �������
	 */
	protected String dadname;
	
	/**
	 * ֵ������
	 */
	protected String dadcategory;
	
	/**
	 * ֵ������
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * ֵ������
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ������
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * ������
	 * @param dadtype ������
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * �������
	 * @return �������
	 */
	public String getDadname() {
		return dadname;
	}

	/**
	 * �������
	 * @param dadname �������
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}

}
