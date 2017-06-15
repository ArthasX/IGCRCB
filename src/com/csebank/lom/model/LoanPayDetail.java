/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * �軹����ϸʵ��ӿ�
 * 
 */
public interface LoanPayDetail extends BaseModel {

	/** �軹����ϸIDȡ�� */
	public Integer getLpdid();

	/** �軹������ȡ�� */
	public String getLpdtype();

	/** �軹����ȡ�� */
	public String getLpduser();

	/** �軹������ȡ�� */
	public String getLpddate();

	/** �軹����ȡ�� */
	public BigDecimal getLpdamount();

	/** ��;ȡ�� */
	public String getLpdcomment();

	/** ״̬ȡ�� */
	public String getLpdstatus();

	/** ������IDȡ�� */
	public String getLpdpersion();

	/** ����������ȡ�� */
	public String getLpdpersionname();

	/** ��Ʊ����ȡ�� */
	public String getLpdinvoicedate();

	/** ��Ʊ��ȡ�� */
	public String getLpdinvoicenum();

	/** ��Ʊǩ����λȡ�� */
	public String getLpdinvoicecor();

	/** ��Ʊ���ȡ�� */
	public BigDecimal getLpdinvoiceamount();

	/** ʵ����;˵��ȡ�� */
	public String getLpdinvoicecomment();

	/** ���IDȡ�� */
	public Integer getLdid();
	
	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** Ԥ֧����IDȡ�� */
	public Integer getAcid();
	
	/**�����ȡ��*/
	public BigDecimal getLpdstockamount();
	
	/** ����˻���ȡ�� */
	public String getLpduserorg();
	
	/** ���� */
	public OrganizationTB getOrganizationTB();
	
	/** ʵ�ʷ�Ʊ��� */
	public BigDecimal getLpdactinvoice();
	
	/** ʵ�ʻ����� */
	public String getLpdactuser();
	
	/** �軹��ʱ��ȡ�� */
	public String getLpdtime();

}
