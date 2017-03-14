/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.drm.model.EventssInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
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

	/** 事件ID */
	private String  eventId ; 
    
	/** 事件名称 */
	private String eventName;
	
	/** 事件级别 */
	private Integer labels;   
	
	/** 事件描述 */
	private String eventDes;   
	
	/** 获取事件一条数据 */
    private EventssInfo info;
    
    /**影响范围id*/
    private Integer[] scopeid;
    
    /**事件影响范围*/
	protected String[] impscope; 
	
	/**业务中断机构*/
	protected String[] impbus;
	
	/**业务中断时间*/
	protected String[] imptime;
    
	/**
	 * eventId   取得
	 * @return eventid eventid
	 */

	public String getEventId() {
		return eventId;
	}
	
	/**
	 * eventId  设定
	 * @param eventid eventid
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	/**
	 * eventName   取得
	 * @return eventname eventname
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * eventName   设定
	 * @return eventname eventname
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * labels   取得
	 * @return labels labels
	 */
	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels   设定
	 * @return labels labels
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * info   取得
	 * @return info info
	 */
	public EventssInfo getInfo() {
		return info;
	}
	
	/**
	 * info   设定
	 * @return info info
	 */
	public void setInfo(EventssInfo info) {
		this.info = info;
	}

	/**
	 * eventDes   取得
	 * @return eventDes eventDes
	 */
	public String getEventDes() {
		return eventDes;
	}

	/**
	 * eventDes   设定
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
