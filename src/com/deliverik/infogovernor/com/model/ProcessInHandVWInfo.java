/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.com.model;


/**
 * �����й����ӿ�
 * 
 */
public interface ProcessInHandVWInfo {
	public Integer getPrid();
	
	/**
	 * ����������ȡ��
	 * @return prusername ����������
	 */
	public String getPrusername();

	public String getPrurgency() ;

	public String getPrserialnum() ;

	public String getPrtype() ;

	public String getPropentime();
	
	/**
	 * �ر�ʱ��ȡ��
	 * @return prclosetime �ر�ʱ��
	 */
	public String getPrclosetime();

	public String getPpusername() ;

	public String getPrstatus();
	
	/**
	 * �����ɫ����ȡ��
	 * @return pprolename �����ɫ����
	 */
	public String getPprolename();
	
	public String getPrtitle() ;

	public String getPrpdid();

	public String getPrpdname() ;
	
	public Integer getPrstrategyversion();
	
	public String getShowtype();
	
	public String getShowtitle();

	public String getPrrolename() ;
	
	public String getShowrolename() ;

	public String getShowpdname() ;

	public String getShowimg() ;
	
	public String getShowurl() ;
	
	public Integer getRid() ;

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ����״̬ȡ��
	 * @return orderstatus  ����״̬
	 */
	public String getOrderstatus();
	
}