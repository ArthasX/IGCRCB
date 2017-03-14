/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 卷组容量实时表检索条件接口
  * 功能描述: 卷组容量实时表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将VGCapacityRealTimeSearchCond表名修改为SOC0419SearchCond
  */
public interface SOC0419SearchCond {
	/**
	 * 主机名称取得
	 *
	 * @return hostName_eq 主机名称
	 */
	public String getHostName_eq();
}