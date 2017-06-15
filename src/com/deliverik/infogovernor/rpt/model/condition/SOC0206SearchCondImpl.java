/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 模板映射表检索条件实现
  * 功能描述: 模板映射表检索条件实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateMappingSearchCondImpl表名修改为SOC0206SearchCondImpl
  */
public class SOC0206SearchCondImpl implements
		SOC0206SearchCond {
	protected Integer rtId_eq;
	
	protected Integer rtNumber_eq;

	/**
	 * rtId_eq取得
	 *
	 * @return rtId_eq rtId_eq
	 */
	public Integer getRtId_eq() {
		return rtId_eq;
	}

	/**
	 * rtId_eq设定
	 *
	 * @param rtId_eq rtId_eq
	 */
	public void setRtId_eq(Integer rtId_eq) {
		this.rtId_eq = rtId_eq;
	}

	/**
	 * rtNumber_eq取得
	 *
	 * @return rtNumber_eq rtNumber_eq
	 */
	public Integer getRtNumber_eq() {
		return rtNumber_eq;
	}

	/**
	 * rtNumber_eq设定
	 *
	 * @param rtNumber_eq rtNumber_eq
	 */
	public void setRtNumber_eq(Integer rtNumber_eq) {
		this.rtNumber_eq = rtNumber_eq;
	}

}