/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ��Ʒ��ѯ�ӿ�
 *
 */
public interface GstockSearchCond {
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getGsid();
	
	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGscategory();
	
	/**
	 * ��Ʒ����ȡ��
	 * @return ��Ʒ����
	 */
	public String getGsname();
	
	/**
	 * ��Ʒ���ȡ��
	 * @return ��Ʒ���
	 */
	public String getGscode();
	
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getGsorg();
	
	public Integer getGsnum() ;
	public String getGsavgprice() ;
	public Integer getGsfreezenum();
	public String getGsuserid();
	public String getGsusername();
	public String getGsdate() ;
}
