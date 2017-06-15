/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程策略通知人查询Form
 * 功能描述: 流程策略通知人查询Form
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0160Form extends BaseForm {
	
	/** 行索引 */
	protected String rowIndex;
	
	/**
	 * 行索引取得
	 * 
	 * @return 行索引
	 */
	public String getRowIndex() {
		return rowIndex;
	}

	/**
	 * 行索引设定
	 * 
	 * @param rowIndex 行索引
	 */
	public void setRowIndex(String rowIndex) {
		this.rowIndex = rowIndex;
	}

}
