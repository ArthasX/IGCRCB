/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 模态页Form
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGSMR0200Form extends BaseForm {
	
	/** URL */
	protected String url;
	
	/** 流程表单定义主键 */
	protected String pidid;
	
	/** 流程主键 */
	protected Integer prid;
	
	/** 表格类表单行号 */
	protected String rownumber;

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
	 * 流程表单定义主键取得
	 *
	 * @return pidid 流程表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * 流程表单定义主键设定
	 *
	 * @param pidid 流程表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程主键取得
	 *
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 表格类表单行号取得
	 * @return rownumber 表格类表单行号
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * 表格类表单行号设定
	 * @param rownumber 表格类表单行号
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

}
