/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 服务工单快捷发起弹出流程类型列表Form
 * @Author masai
 * @History 
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class IGPRM0004Form extends BaseForm {

	/** 流程ID */
	protected Integer prid;
	
	/** 流程类型 */
	protected String prtype;

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * 
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * 
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
}
