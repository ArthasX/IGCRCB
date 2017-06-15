/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 预览报表Form
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGSYM1406Form extends BaseForm {
	
	/** URL */
	protected String url;
	
	/** 报表文件名  */
	protected String rfdfilename;
	
	/** 报表版本号 */
	protected Integer rfdversion;
	
	/** 报表版本号 */
	protected String title;

	/** 主键 */
	protected Integer rfdid;
	
	
	
	/**
	 * @return the rfdid
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * @param rfdid the rfdid to set
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * URL取得
	 * 
	 * @return URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * URL设定
	 * 
	 * @param url URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 报表文件名取得
	 * @return 报表文件名
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * 报表文件名设定
	 * @param rfdfilename 报表文件名
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}
	
	/**
	 * 报表登记时间取得
	 * @return 报表登记时间
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * 报表登记时间设定
	 * @param rfdversion 报表登记时间
	 */
	public void setRfdversion(Integer rfdversion) {
		this.rfdversion = rfdversion;
	}
	
}
