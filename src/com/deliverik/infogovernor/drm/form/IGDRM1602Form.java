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
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1602Form extends BaseForm {

	/** 事件ID */
	private Integer eventId;

	/** 事件名称 */
	private String seventName;

	/** 事件级别 */
	private Integer labels;
	
	/** 事件描述 */
	private String seventDes;
	
	/** 删除一条 */
	private Integer deleteEid;
	
	/**
	 * eventId 取得
	 * 
	 * @return eventid eventid
	 */

	public Integer getEventId() {
		return eventId;
	}

	/**
	 * eventId 设定
	 * 
	 * @param eventid  eventid          
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}


	/**
	 * labels 取得
	 * 
	 * @return labels labels
	 */
	public Integer getLabels() {
		return labels;
	}

	/**
	 * labels 设定
	 * 
	 * @return labels labels
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}
	
	/**
	 * deleteEid 取得
	 * 
	 * @return deleteEid deleteEid
	 */
	
	public Integer getDeleteEid() {
		return deleteEid;
	}

	/**
	 * deleteEid 设定
	 * 
	 * @return deleteEid deleteEid
	 */
	public void setDeleteEid(Integer deleteEid) {
		this.deleteEid = deleteEid;
	}

	public String getSeventName() {
		return seventName;
	}

	public void setSeventName(String seventName) {
		this.seventName = seventName;
	}

	public String getSeventDes() {
		return seventDes;
	}

	public void setSeventDes(String seventDes) {
		this.seventDes = seventDes;
	}
	

}
