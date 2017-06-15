/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程定义基本信息成功登录后确认画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0103Form extends BaseForm {

	/** 流程模板类型 */
	protected String pttype;
	
	/**
	 * 流程模板类型取得
	 *
	 * @return pttype 流程模板类型
	 */
	public String getPttype() {
		return pttype;
	}


	/**
	 * 流程模板类型设定
	 *
	 * @param pttype 流程模板类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

}
