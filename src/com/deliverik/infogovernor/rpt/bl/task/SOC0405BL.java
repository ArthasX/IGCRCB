/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * 概述: 逻辑卷容量实时表业务逻辑接口
  * 功能描述: 逻辑卷容量实时表业务逻辑接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeBL修改为SOC0405BL
  */
public interface SOC0405BL extends BaseBL {

	/**
	 * 逻辑卷容量实时表实例取得
	 *
	 * @return 逻辑卷容量实时表实例
	 */
	public SOC0405TB getSOC0405Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0405Info> searchSOC0405();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0405SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond, int start,
			int count);

}