/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_�д�ͳ����ϢMODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface EentertainmentStatistics {
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate();
	
	/**
	 * �д�����
	 * @return �д�����
	 */
	public BigDecimal getEnumber();
	
	/**
	 * �д�����
	 * @param enumber �д�����
	 */
	public void setEnumber(BigDecimal enumber);
	
	/**
	 * �˼�
	 * @return �˼�
	 */
	public BigDecimal getEefoodprice();
	
	/**
	 * �Ƽ�
	 * @return �Ƽ�
	 */
	public BigDecimal getEedrinkprice();
	
	/**
	 * �̼�
	 * @return �̼�
	 */
	public BigDecimal getEesmokeprice();
	
	/**
	 * �ϼ�
	 * @return �ϼ�
	 */
	public BigDecimal getEtotal();
	public BigDecimal getEeotherprice();

}