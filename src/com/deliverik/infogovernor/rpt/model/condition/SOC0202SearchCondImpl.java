/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 附加报表检索条件实现
  * 功能描述: 附加报表检索条件实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportAnnexationSearchCondImpl表名改为SOC0202SearchCondImpl
  */
public class SOC0202SearchCondImpl implements
		SOC0202SearchCond {
	/**用户名字等于*/
	protected String raUserName_eq;

	/**
	 * 用户名字等于取得
	 *
	 * @return raUserName_eq 用户名字等于
	 */
	public String getRaUserName_eq() {
		return raUserName_eq;
	}

	/**
	 * 用户名字等于设定
	 *
	 * @param raUserName_eq 用户名字等于
	 */
	public void setRaUserName_eq(String raUserName_eq) {
		this.raUserName_eq = raUserName_eq;
	}
	
	
}