/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.ram.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 审计版本查询Form
 *
 * @author tangzhen@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRAM0301Form extends BaseForm {
	
	/**部门评估查询开始时间*/
	protected String propentime_from;
	
	/**部门评估查询结束时间*/
	protected String propentime_to;

	/**
	 * propentime_from取得
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * propentime_from设定
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * propentime_to取得
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * propentime_to设定
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}


}
