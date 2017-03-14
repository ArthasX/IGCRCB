/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程定义查询Form
 * 功能描述：流程定义查询Form
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM1701Form extends BaseForm {
	
	/** 流程类型 */
	protected String pttype;

	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程类型设定
	 * @param pttype流程类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
}
