/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �¼��������������ӿ�
  * ��������: �¼��������������ӿ�
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public interface EventssSearchCond {
	
	/**��ȡeventssId*/
	public Integer getEventssid();
	
	/**��ȡeventssname*/
	public String getEventssname();
	
	/**��ȡlabels*/
	public Integer getLabels();
	
	/**��ȡflag*/
	public String getFlag();
	
	/**��ȡeventDes*/
	public String getEventDes();
	/**
	 * @return the orderBy
	 */
	public String getOrderBy();
	/**
	 * @return the order
	 */
	public String getOrder();
	

}