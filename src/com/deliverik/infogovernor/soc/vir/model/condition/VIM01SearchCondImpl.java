/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: vCenter ServiceInstance检索条件实现
  * 功能描述: vCenter ServiceInstance检索条件实现
  * 创建记录: 2014/02/12
  * 修改记录: 
  */
public class VIM01SearchCondImpl implements
		VIM01SearchCond {
	
	/** URL */
	protected String vcurl;

	/**
	 * URL取得
	 * @return vcurl URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL设定
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}
	
}