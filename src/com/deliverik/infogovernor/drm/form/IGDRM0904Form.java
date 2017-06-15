/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * </p>
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0904Form extends BaseForm{
	
	private Integer ptid;
	
	/**应急演练prid*/
	private String drillPrid;
	
	/**
	 * ptid   取得
	 * @return ptid ptid
	 */
	public Integer getPtid() {
		return ptid;
	}
	/**
	 * ptid   设定
	 * @param ptid ptid
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	/**
	 * drillPrid   取得
	 * @return drillPrid drillPrid
	 */
	public String getDrillPrid() {
		return drillPrid;
	}
	/**
	 * drillPrid   设定
	 * @param drillPrid drillPrid
	 */
	public void setDrillPrid(String drillPrid) {
		this.drillPrid = drillPrid;
	}
	
}
