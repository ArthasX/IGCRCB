/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 * 
 * @author songhaiyang@deliverik.com
 *
 */
public interface RecptionCost extends BaseModel {

	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** �Ӵ��������� */
	public String getRname();
	
	/** ��Ҫ���벿�Ų���� */
//	public String getRapporgid();
	
	/** �Ӵ��������� */
	public String getRetime();
	
	/** �Ӵ���ʼ���� */
	public String getRstime();
	
	/** �Ӵ�������ģ */
//	public String getRscale();
	
	/** �Ӵ���׼ */
//	public String getRstandard();
	
	/** �������벿������ */
//	public String getRpporg();
	
	/** �Ӵ��������� */
//	public String getRdescription();
	
	/** �Ǽ����� */
	public String getRdate();
	
	/** ״̬��1�����У�2������ */
	public String getRstatus();
	
	/** ��Ʒ����ͳ�� */
	public BigDecimal getStockSum();
	
	/** ���ͳ�� */
	public BigDecimal getLoanSum();
	
	/** ʳ�÷���ͳ�� */
	public BigDecimal getEntertainmentSum();
	
	/** ���úϼ�*/
	public BigDecimal getCost();
	
	public OrganizationTB getOrganizationTB();

}
