/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �¼�������������ʵ��
  * ��������: �¼�������������ʵ��
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public class EventssSearchCondImpl implements
		EventssSearchCond {
	
	/** �¼�ID	 */
	protected Integer eventssid;
	
	/** �¼�����	 */
	protected String eventssname;
	
	/** �¼�����	 */
	protected Integer labels;
	
	/** �¼�����	 */
	protected String eventDes;
	
	/** �¼������޸ı�־	 */
	protected String flag;
	
	/** �����ֶ�*/
	protected String orderBy;
	
	/** ����˳��*/
	protected String order;
	
	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * eventid ��ȡ
	 * 
	 * @param eventid  eventid          
	 */

	public Integer getEventssid() {
		return eventssid;
	}

	/**
	 * eventid �趨
	 * 
	 * @param eventid  eventid          
	 */
	public void setEventssid(Integer eventssid) {
		this.eventssid = eventssid;
	}
	
	/**
	 * eventssname ��ȡ
	 * 
	 * @param eventssname  eventssname          
	 */

	public String getEventssname() {
		return eventssname;
	}
	
	/**
	 * eventssname �趨
	 * 
	 * @param eventssname  eventssname          
	 */

	public void setEventssname(String eventssname) {
		this.eventssname = eventssname;
	}
	
	/**
	 * labels ��ȡ
	 * 
	 * @param labels  labels          
	 */

	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels �趨
	 * 
	 * @param labels  labels          
	 */

	public void setLabels(Integer labels) {
		this.labels = labels;
	}

	/**
	 * flag ��ȡ
	 * 
	 * @param flag  flag          
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag �趨
	 * 
	 * @param flag  flag          
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * eventDes ��ȡ
	 * 
	 * @param eventDes  eventDes          
	 */
	public String getEventDes() {
		return eventDes;
	}

	/**
	 * eventDes �趨
	 * 
	 * @param eventDes  eventDes          
	 */
	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}
	
	

}