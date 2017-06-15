/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 存储lun实时表检索条件实现
  * 功能描述: 存储lun实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVStorageRealTimeSearchCondImpl表名改为SOC0410SearchCondImpl
  */
public class SOC0410SearchCondImpl implements
		SOC0410SearchCond {
	protected String isUsed_eq;
	protected String sName_eq;
	/**
	 * isUsed_eq取得
	 *
	 * @return isUsed_eq isUsed_eq
	 */
	public String getIsUsed_eq() {
		return isUsed_eq;
	}
	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq() {
		return sName_eq;
	}
	/**
	 * isUsed_eq设定
	 *
	 * @param isUsed_eq isUsed_eq
	 */
	public void setIsUsed_eq(String isUsed_eq) {
		this.isUsed_eq = isUsed_eq;
	}
	/**
	 * sName_eq设定
	 *
	 * @param name_eq sName_eq
	 */
	public void setSName_eq(String name_eq) {
		sName_eq = name_eq;
	}

}