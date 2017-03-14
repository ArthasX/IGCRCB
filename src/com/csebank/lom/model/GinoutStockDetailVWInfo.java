/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * 
 * ��Ʒ������Ϣ��ͼʵ��ӿ�
 *
 */
public interface GinoutStockDetailVWInfo {

	public Integer getGiodid();
	
	public String getGiodtype();
	
	public String getGiodorg();
	
	public String getGiodcategory();
	
	public String getGiodname();
	
	public String getGiodcode();
	
	public Integer getGiodinnum();
	
	public String getGiodreliefnum();
	
	public BigDecimal getGiodhavocnum();
	
	public String getGiodreqnum();
	
	public Integer getGiodoutnum();
	
	public String getGiodunit();
	
	public BigDecimal getGiodinprice();
	
	/**
	 * GStock����ȡ��
	 * @return ����ID
	 */
	public Integer getGsid();
	
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public Integer getGsnum();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg();
	
	/**
	 * �ɹ�ƽ����ȡ��
	 * @return �ɹ�ƽ����
	 */
	public BigDecimal getGsavgprice();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getGsfreezenum();

}
