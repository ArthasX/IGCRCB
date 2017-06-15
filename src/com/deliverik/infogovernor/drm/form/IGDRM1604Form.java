/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�Ӱ�췶Χ����
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1604Form extends BaseForm {
	
	/** ����ID */
	protected Integer upEventid;
	
	/**�¼�����*/
	protected String upEventname;
	
	/**�¼���ǩ*/
	protected Integer upLabels;
	
	/**�¼�Ӱ�췶Χ*/
	protected String[] impscope; 
	
	/**ҵ���жϻ���*/
	protected String[] impbus;
	
	/**ҵ���ж�ʱ��*/
	protected String[] imptime;
	
	/**�¼�ID*/
	protected String[] eventid;
	
	/** �¼����� */
	private String eventName;
	
	/** �¼����� */
	private Integer labels;   
	
	/** �¼����� */
	private String eventDes;   
	
	/**
	 * upEventid ȡ��
	 * 
	 * @return upEventid upEventid
	 */
	public Integer getUpEventid() {
		return upEventid;
	}
	
	/**
	 * upEventid �趨
	 * 
	 * @return upEventid upEventid
	 */

	public void setUpEventid(Integer upEventid) {
		this.upEventid = upEventid;
	}
	
	/**
	 * upEventname ȡ��
	 * 
	 * @return upEventname upEventname
	 */

	public String getUpEventname() {
		return upEventname;
	}
	
	/**
	 * upEventname �趨
	 * 
	 * @return upEventname upEventname
	 */

	public void setUpEventname(String upEventname) {
		this.upEventname = upEventname;
	}

	/**
	 * upLabels ȡ��
	 * 
	 * @return upLabels upLabels
	 */
	public Integer getUpLabels() {
		return upLabels;
	}
	
	/**
	 * upLabels �趨
	 * 
	 * @return upLabels upLabels
	 */

	public void setUpLabels(Integer upLabels) {
		this.upLabels = upLabels;
	}
	
	/**
	 * impscope ȡ��
	 * 
	 * @return impscope impscope
	 */
	
	public String[] getImpscope() {
		return impscope;
	}

	/**
	 * impscope �趨
	 * 
	 * @return impscope impscope
	 */
	public void setImpscope(String[] impscope) {
		this.impscope = impscope;
	}
	
	/**
	 * impbus ȡ��
	 * 
	 * @return impbus impbus
	 */

	public String[] getImpbus() {
		return impbus;
	}
	
	/**
	 * impbus �趨
	 * 
	 * @return impbus impbus
	 */

	public void setImpbus(String[] impbus) {
		this.impbus = impbus;
	}
	
	/**
	 * imptime ȡ��
	 * 
	 * @return imptime imptime
	 */

	public String[] getImptime() {
		return imptime;
	}
	
	/**
	 * imptime �趨
	 * 
	 * @return imptime imptime
	 */

	public void setImptime(String[] imptime) {
		this.imptime = imptime;
	}

	/**
	 * eventid ȡ��
	 * 
	 * @return eventid eventid
	 */
	public String[] getEventid() {
		return eventid;
	}
	
	/**
	 * eventid �趨
	 * 
	 * @return eventid eventid
	 */

	public void setEventid(String[] eventid) {
		this.eventid = eventid;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getLabels() {
		return labels;
	}

	public void setLabels(Integer labels) {
		this.labels = labels;
	}

	public String getEventDes() {
		return eventDes;
	}

	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}
	
}
