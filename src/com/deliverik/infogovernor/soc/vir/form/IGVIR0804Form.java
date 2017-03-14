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
public class IGVIR0804Form extends BaseForm{
	
	/**机构码  */
	protected String orgsyscoding;

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构码设定
	 * @param orgsyscoding 机构码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

}
