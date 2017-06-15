/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.csebank.lom.model;
import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  ��Ʊ����ʵ��ӿ�
 * 
 * @author piaow@deliverik.com
 * 
 */

public interface Invoice extends BaseModel {
	/**
	 * ��Ʊ����IDȡ��
	 * 
	 * @return ��Ʊ����ID
	 */
	public Integer getIid();

	/**
	 * ��Ʊ����ȡ��
	 * 
	 * @return ��Ʊ����
	 */
	public String getItype();
	
	/**
	 * ��Ʊ����ȡ��
	 * 
	 * @return ��Ʊ����
	 */
	public String getIdate();
	
	/**
	 * ��Ʊ����ȡ��
	 * 
	 * @return ��Ʊ����
	 */
	public String getInum();
	
	/**
	 * ���ȡ��
	 * 
	 * @return ���
	 */
	public BigDecimal getIamount();

	/**
	 * ��;˵������ȡ��
	 * 
	 * @return ��;˵������
	 */
	public String getIcomment();

	/**
	 * ��ͬ���ȡ��
	 * 
	 * @return ��ͬ���״̬
	 */
	public String getIcontractserial();
	
	/**
	 * ��ͬ����ȡ��
	 * 
	 * @return ��ͬ����
	 */
	public String getIcontractname();
		
	/**
	 * �տλ����ȡ��
	 * 
	 * @return �տλ����
	 */
	public String getIcorporation();
	
	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getIbank();
	
	/**
	 * �˺�ȡ��
	 * 
	 * @return �˺�
	 */
	public String getIaccount();
	
	/**
	 * ���벿�Ų����ȡ��
	 * 
	 * @return ���벿�Ų����
	 */
	public String getIreqemp();
	
	/**
	 * ������IDȡ��
	 * 
	 * @return ������ID
	 */
	public String getIrequser();
	
	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getIrequsername();
	
	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getIstatus();

	/**
	 * ���ʽȡ��
	 * 
	 * @return ���ʽ
	 */
	public String getIpaymenttype();
	
	/**
	 * ���ʽ����ȡ��
	 * 
	 * @return ���ʽ����
	 */
	public String getIpaymenttypecode(); 
	
	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getIpaymentdate();
	
	
	public OrganizationTB getOrganizationTB();




}