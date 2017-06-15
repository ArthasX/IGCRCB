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
public class IGDRM1811Form extends BaseForm {

	/**登记时间起始*/
	protected String drillTimeFrom;
	/**登记时间终止*/
	protected String drillTimeTo;
	public String getDrillTimeFrom() {
		return drillTimeFrom;
	}
	public void setDrillTimeFrom(String drillTimeFrom) {
		this.drillTimeFrom = drillTimeFrom;
	}
	public String getDrillTimeTo() {
		return drillTimeTo;
	}
	public void setDrillTimeTo(String drillTimeTo) {
		this.drillTimeTo = drillTimeTo;
	}


	
	
}
