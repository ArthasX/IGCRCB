/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * ���ܣ�����Ͳ͵Ǽ�ʵ����
 * 
 * ���ߣ������� mail to tangxiaona@deliverik.com
 *
 */

public interface Deal extends BaseModel {
	/** ����Ͳ͹���ID */
	public Integer getRid();
	public String getRapporgid();
	
   /**
    * 
    * ��Ҫ���벿��
    */
	public String getDeptName();
	/**
	 * 
	 * ����ʱ��
	 */
	public String getDealTime();
	/**
	 * 
	 * ����������ģ
	 */
	public String getDealScale();
	/**
	 * 
	 * ������
	 */
	public BigDecimal getDealCash();
	/**
	 * 
	 * ��Ʊ���
	 */
	public String getInvoiceNumber();
	/**
	 * 
	 * �������벿����
	 */
	public String getOtherJoiner();
	/**
	 * 
	 * ��������
	 */
	public String getDealDesc();
	public OrganizationTB getOrganizationTB();

}
