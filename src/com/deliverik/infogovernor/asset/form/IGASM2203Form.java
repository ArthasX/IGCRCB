/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: CI变更控制台任务查看FORM
 * 功能描述: CI变更控制台任务查看FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM2203Form extends BaseForm {
	
	/** 任务ID */
	protected Integer ciwtid;

	/**
	 * 任务ID取得
	 * 
	 * @return 任务ID
	 */
	public Integer getCiwtid() {
		return ciwtid;
	}

	/**
	 * 任务ID设定
	 * 
	 * @param ciwtid 任务ID
	 */
	public void setCiwtid(Integer ciwtid) {
		this.ciwtid = ciwtid;
	}

}
