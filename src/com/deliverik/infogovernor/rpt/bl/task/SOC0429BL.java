/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;

/**
  * 概述: 主机容量视图业务逻辑接口
  * 功能描述: 主机容量视图业务逻辑接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWBL表名改为SOC0429BL
  */
public interface SOC0429BL extends BaseBL {


	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0429Info> searchSOC0429();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0429SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond, int start,
			int count);

}