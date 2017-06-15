/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 存储lun实时表检索条件接口
  * 功能描述: 存储lun实时表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVStorageRealTimeSearchCond表名改为SOC0410SearchCond
  */
public interface SOC0410SearchCond {
	/**
	 * isUsed_eq取得
	 *
	 * @return isUsed_eq isUsed_eq
	 */
	public String getIsUsed_eq();
	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq();
}