/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;


/**
  * ����: cicollecttask�ӿ�
  * ��������: cicollecttask�ӿ�
  * ������¼: 2013/07/05 ��ʡ
  * �޸ļ�¼: 
  */
public interface CicollecttaskInfo{

	public String getTypename();

	public String getUuid();

	public String getName();

	public String getStartrule();

	public String getStoprule();

	public String getStarttime();

	public String getStoptime();

	public String getNewstarttime();

	public String getNewstoptime();

	public String getExecutstatus();

	public String getPeriodtype();
	
	public String getPlatformname();
	
	public String getServername();
	
	public Integer getResourceid();

}