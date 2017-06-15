/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 逻辑卷容量实时表检索条件接口
  * 功能描述: 逻辑卷容量实时表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeSearchCond表名改为SOC0405SearchCond
  */
public interface SOC0405SearchCond {
	/**
	 * 类型等于取得
	 *
	 * @return lvType_eq 类型等于
	 */
	public String getLvType_eq();
	/**
	 * 类型bu等于取得
	 *
	 * @return lvType_ne 类型等于
	 */
	public String getLvType_ne();
	/**
	 * 状态等于取得
	 *
	 * @return lvState_eq 状态等于
	 */
	public String getLvState_eq();
	/**
	 * 文件系统名字不等于取得
	 *
	 * @return fsName_neq 文件系统名字不等于
	 */
	public String getFsName_neq();
	/**
	 * vg名字等于取得
	 *
	 * @return vgName_eq vg名字等于
	 */
	public String getVgName_eq();
	/**
	 * 主机名称等于取得
	 *
	 * @return hostName_eq 主机名称等于
	 */
	public String getHostName_eq();
}