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
public class IGRAM0401Form extends BaseForm {
	

	/**年度评估差条件*/
	protected String currentyear;

	/**
	 * currentyear取得
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear设定
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

}
