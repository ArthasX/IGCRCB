/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �¼�Ӱ�췶Χ��������ʵ��
  * ��������: �¼�Ӱ�췶Χ��������ʵ��
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
public class ScopesSearchCondImpl implements
		ScopesSearchCond {
	
	 /** �¼�����ID */
    protected Integer eventid;

    /**
	 * eventid ��ȡ
	 * 
	 * @param eventid  eventid          
	 */
	public Integer getEventid() {
		return eventid;
	}
	
	/**
	 * eventid �趨
	 * 
	 * @param eventid  eventid          
	 */

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}
    

}