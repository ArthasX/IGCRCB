/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.drm.model.EventssInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1601Form extends BaseForm {
	private static final long serialVersionUID = 1L;

	/** �¼�ID */
	private String  eventId ; 
    
	/** �¼����� */
	private String eventName;
	
	/** �¼����� */
	private Integer labels;   
	
	/** �¼����� */
	private String eventDes;   
	
	/** ��ȡ�¼�һ������ */
    private EventssInfo info;
    
    /**Ӱ�췶Χid*/
    private Integer[] scopeid;
    
    /**�¼�Ӱ�췶Χ*/
	protected String[] impscope; 
	
	/**ҵ���жϻ���*/
	protected String[] impbus;
	
	/**ҵ���ж�ʱ��*/
	protected String[] imptime;
    
	/**
	 * eventId   ȡ��
	 * @return eventid eventid
	 */

	public String getEventId() {
		return eventId;
	}
	
	/**
	 * eventId  �趨
	 * @param eventid eventid
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	/**
	 * eventName   ȡ��
	 * @return eventname eventname
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * eventName   �趨
	 * @return eventname eventname
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * labels   ȡ��
	 * @return labels labels
	 */
	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels   �趨
	 * @return labels labels
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * info   ȡ��
	 * @return info info
	 */
	public EventssInfo getInfo() {
		return info;
	}
	
	/**
	 * info   �趨
	 * @return info info
	 */
	public void setInfo(EventssInfo info) {
		this.info = info;
	}

	/**
	 * eventDes   ȡ��
	 * @return eventDes eventDes
	 */
	public String getEventDes() {
		return eventDes;
	}

	/**
	 * eventDes   �趨
	 * @return eventDes eventDes
	 */
	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}

	public Integer[] getScopeid() {
		return scopeid;
	}

	public void setScopeid(Integer[] scopeid) {
		this.scopeid = scopeid;
	}

	public String[] getImpscope() {
		return impscope;
	}

	public void setImpscope(String[] impscope) {
		this.impscope = impscope;
	}

	public String[] getImpbus() {
		return impbus;
	}

	public void setImpbus(String[] impbus) {
		this.impbus = impbus;
	}

	public String[] getImptime() {
		return imptime;
	}

	public void setImptime(String[] imptime) {
		this.imptime = imptime;
	}
	

}
