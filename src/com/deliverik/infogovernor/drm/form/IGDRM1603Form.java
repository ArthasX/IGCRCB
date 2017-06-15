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
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1603Form extends BaseForm {
	
	/** 主键ID */
	protected Integer upEventid;
	
	/**事件名称*/
	protected String upEventname;
	
	/**事件标签*/
	protected Integer upLabels;  
	
	/**事件描述*/
	protected String upEventdes;  
	
	/**标志*/
	protected String flag; 

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
	 * flag 取得
	 * 
	 * @return flag flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag 设定
	 * 
	 * @return flag flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * upEventdes 取得
	 * 
	 * @return upEventdes upEventdes
	 */
	public String getUpEventdes() {
		return upEventdes;
	}

	/**
	 * upEventdes 设定
	 * 
	 * @return upEventdes upEventdes
	 */
	public void setUpEventdes(String upEventdes) {
		this.upEventdes = upEventdes;
	}
	
	

}
