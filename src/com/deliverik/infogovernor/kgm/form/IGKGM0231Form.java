/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 知识贡献数量统计FORM
 * 
 */

@SuppressWarnings("serial")
public class IGKGM0231Form extends BaseForm {
	
	/**
	 * 返回数据xml
	 */
	private String svcxml;

	/**
	 * 返回数据xml取得
	 * @return svcxml 返回数据xml
	 */
	public String getSvcxml() {
		return svcxml;
	}

	/**
	 * 返回数据xml设定
	 * @param svcxml 返回数据xml
	 */
	public void setSvcxml(String svcxml) {
		this.svcxml = svcxml;
	}

}
