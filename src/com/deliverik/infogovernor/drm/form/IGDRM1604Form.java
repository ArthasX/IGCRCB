/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件影响范围管理
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1604Form extends BaseForm {
	
	/** 主键ID */
	protected Integer upEventid;
	
	/**事件名称*/
	protected String upEventname;
	
	/**事件标签*/
	protected Integer upLabels;
	
	/**事件影响范围*/
	protected String[] impscope; 
	
	/**业务中断机构*/
	protected String[] impbus;
	
	/**业务中断时间*/
	protected String[] imptime;
	
	/**事件ID*/
	protected String[] eventid;
	
	/** 事件名称 */
	private String eventName;
	
	/** 事件级别 */
	private Integer labels;   
	
	/** 事件描述 */
	private String eventDes;   
	
	/**
	 * upEventid 取得
	 * 
	 * @return upEventid upEventid
	 */
	public Integer getUpEventid() {
		return upEventid;
	}
	
	/**
	 * upEventid 设定
	 * 
	 * @return upEventid upEventid
	 */

	public void setUpEventid(Integer upEventid) {
		this.upEventid = upEventid;
	}
	
	/**
	 * upEventname 取得
	 * 
	 * @return upEventname upEventname
	 */

	public String getUpEventname() {
		return upEventname;
	}
	
	/**
	 * upEventname 设定
	 * 
	 * @return upEventname upEventname
	 */

	public void setUpEventname(String upEventname) {
		this.upEventname = upEventname;
	}

	/**
	 * upLabels 取得
	 * 
	 * @return upLabels upLabels
	 */
	public Integer getUpLabels() {
		return upLabels;
	}
	
	/**
	 * upLabels 设定
	 * 
	 * @return upLabels upLabels
	 */

	public void setUpLabels(Integer upLabels) {
		this.upLabels = upLabels;
	}
	
	/**
	 * impscope 取得
	 * 
	 * @return impscope impscope
	 */
	
	public String[] getImpscope() {
		return impscope;
	}

	/**
	 * impscope 设定
	 * 
	 * @return impscope impscope
	 */
	public void setImpscope(String[] impscope) {
		this.impscope = impscope;
	}
	
	/**
	 * impbus 取得
	 * 
	 * @return impbus impbus
	 */

	public String[] getImpbus() {
		return impbus;
	}
	
	/**
	 * impbus 设定
	 * 
	 * @return impbus impbus
	 */

	public void setImpbus(String[] impbus) {
		this.impbus = impbus;
	}
	
	/**
	 * imptime 取得
	 * 
	 * @return imptime imptime
	 */

	public String[] getImptime() {
		return imptime;
	}
	
	/**
	 * imptime 设定
	 * 
	 * @return imptime imptime
	 */

	public void setImptime(String[] imptime) {
		this.imptime = imptime;
	}

	/**
	 * eventid 取得
	 * 
	 * @return eventid eventid
	 */
	public String[] getEventid() {
		return eventid;
	}
	
	/**
	 * eventid 设定
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
