/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ����: Priorityʵ������
 * �������������ȼ�priorityTBʵ������
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class PriorityTBPK extends BasePK implements Serializable{

	/***
	 * ��Ӧ��������
	 */
	protected String pprtype;
	/***
	 * �����̶�KEY
	 */
	protected String uvalue;
	/***
	 * Ӱ���KEY	
	 */
	protected String ivalue;
	
	
	/**
	 * ʵ���������캯��
	 * 
	 */
	public PriorityTBPK() {
	}

	/**
	 * ʵ���������캯��
	 * 
	 * @param pprtype��������
	 * @param uvalue������
	 * @param ivalueӰ���
	 */
	public PriorityTBPK(String pprtype, String uvalue, String ivalue) {
		super();
		this.pprtype = pprtype;
		this.uvalue = uvalue;
		this.ivalue = ivalue;
	}

	public String getPprtype() {
		return pprtype;
	}

	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

	public String getUvalue() {
		return uvalue;
	}

	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}

	public String getIvalue() {
		return ivalue;
	}

	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}

}
