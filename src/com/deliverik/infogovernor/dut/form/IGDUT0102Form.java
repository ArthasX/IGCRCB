/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

/**
 * 
 * ֵ�������form
 *
 */
public class IGDUT0102Form extends BaseForm implements DutyAuditDefSearchCond{


	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ID
	 */
	protected Integer dadid;

	/**
	 * ������
	 */
	protected String dadtype;
	
	/**
	 * �������
	 */
	protected String dadname;
	
	/**
	 * ״̬ ����:1 ͣ��:2
	 */
	protected String dadstatus;
	
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
	 * �����ID
	 * @return �����ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * �����ID
	 * @param dadid �����ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
	
	/**
	 * ֵ����״̬
	 * @return ֵ����״̬
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * ֵ����״̬
	 * @param dadstatus ֵ����״̬
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
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
