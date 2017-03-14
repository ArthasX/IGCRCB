/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 首页设定Form
 * 功能描述：首页设定Form
 * 创建记录：崔学志    2012/11/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM1802Form extends BaseForm {
	
	/** 首页ID  */
	protected String hpid;
	
	/** 首页描述  */
	protected String hplabel;
	
	/**  首页显示名称  */
	protected String hptitle;
	
	/** 首页URL   */
	protected String hpurl;

	/** 成功返回标志 新增还是修改标识，0新增 1修改*/
	protected String mode = "0";
	
	/**
	 * 首页ID获得
	 * @return the hpid
	 */
	public String getHpid() {
		return hpid;
	}
	/**
	 *首页ID设定
	 *	
	 * @param hpid the hpid to set
	 */
	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	/**
	 * 首页描述获得
	 * @return the hplabel
	 */
	public String getHplabel() {
		return hplabel;
	}

	/**
	 *首页描述设定
	 *	
	 * @param hplabel the hplabel to set
	 */
	public void setHplabel(String hplabel) {
		this.hplabel = hplabel;
	}

	/**
	 * 首页显示名称获得
	 * @return the hptitle
	 */
	public String getHptitle() {
		return hptitle;
	}

	/**
	 *首页显示名称设定
	 *	
	 * @param hptitle the hptitle to set
	 */
	public void setHptitle(String hptitle) {
		this.hptitle = hptitle;
	}

	/**
	 * 首页URL 获得
	 * @return the hpurl
	 */
	public String getHpurl() {
		return hpurl;
	}

	/**
	 *首页URL 设定
	 *	
	 * @param hpurl the hpurl to set
	 */
	public void setHpurl(String hpurl) {
		this.hpurl = hpurl;
	}
	/**
	 * 成功返回标志 新增还是修改标识 获得
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 *成功返回标志 新增还是修改标识 设定
	 *	
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
}
