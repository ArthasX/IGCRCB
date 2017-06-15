/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 存储容量实时表检索条件实现
  * 功能描述: 存储容量实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将StorageCapacityRealTimeSearchCondImpl表名改为SOC0411SearchCondImpl
  */
public class SOC0411SearchCondImpl implements
		SOC0411SearchCond {
	/**存储id eq*/
	protected String sName;

	/**
	 * 存储ideq取得
	 *
	 * @return sName 存储ideq
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * 存储ideq设定
	 *
	 * @param name sName
	 */
	public void setSName(String name) {
		sName = name;
	}
}