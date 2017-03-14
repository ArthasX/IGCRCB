/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 
 */

@SuppressWarnings("serial")
public class IGVIR1103Form extends BaseForm{
	
	/**项目名  */
	protected String pname_like;

	/**
	 * 项目名取得
	 * @return pname_like 项目名
	 */
	public String getPname_like() {
		return pname_like;
	}

	/**
	 * 项目名设定
	 * @param pname_like 项目名
	 */
	public void setPname_like(String pname_like) {
		this.pname_like = pname_like;
	}
}
