package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 应急管理
 * 预案统计Form
 * 
 * @author kenZ
 *
 */
@SuppressWarnings("serial")
public class IGDRM1801Form extends BaseForm {

	/**登记时间起始*/
	protected String eiinstimeFrom;
	/**登记时间终止*/
	protected String eiinstimeTo;
	/**
	 *  eiinstimeFrom获取
	 * @return  eiinstimeFrom
	 */
	public String getEiinstimeFrom() {
		return eiinstimeFrom;
	}
	/**
	 * eiinstimeFrom设定
	 * @param eiinstimeFrom 
	 */
	public void setEiinstimeFrom(String eiinstimeFrom) {
		this.eiinstimeFrom = eiinstimeFrom;
	}
	/**
	 *  eiinstimeTo获取
	 * @return  eiinstimeTo
	 */
	public String getEiinstimeTo() {
		return eiinstimeTo;
	}
	/**
	 * eiinstimeTo设定
	 * @param eiinstimeTo 
	 */
	public void setEiinstimeTo(String eiinstimeTo) {
		this.eiinstimeTo = eiinstimeTo;
	}
	
	
}
