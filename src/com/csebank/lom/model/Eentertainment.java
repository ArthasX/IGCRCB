/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 *
 */
public interface Eentertainment extends BaseModel {

	/** �������������� */
	public Integer getEeid();
	
	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** ������ */
	public String getEeuser();
	
	/** ÿ���˼۸� */
	public BigDecimal getEetableprice();
	
	/** ���� */
	public Integer getEetablenum();
	
	/** �Ƽ� */
	public BigDecimal getEedrinkprice();
	
	/** �̼� */
	public BigDecimal getEesmokeprice();
	
	/** ������Ʒ�۸� */
	public BigDecimal getEeotherprice();
	
	/** ���� */
	public String getEedate();
	
	public RecptionTB getRecptionTB();

}
