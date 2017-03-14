/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 知识批量导出Form
 * 功能描述：知识批量导出Form
 * 创建记录：杨盛楠	2011-3-28
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM0228Form extends BaseForm {
	
	/** ID数组 */
	protected String[] knids;

	/**
	 * ID数组取得
	 * @return ID数组
	 */
	public String[] getKnids() {
		return knids;
	}

	/**
	 * ID数组设定
	 * @param knids ID数组
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}

}
