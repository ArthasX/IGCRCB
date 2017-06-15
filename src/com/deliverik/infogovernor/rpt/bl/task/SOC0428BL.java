/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;

/**
  * 概述: 业务系统视图业务逻辑接口
  * 功能描述: 业务系统视图业务逻辑接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将表名BusinessCapacityRealTimeVWBL表名改为SOC0428BL
  * 					将方法名中BusinessCapacityRealTimeVW改为SOC0428
  */
public interface SOC0428BL extends BaseBL {


	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0428Info> searchSOC0428();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0428SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond, int start,
			int count);
	/**
	 * 主键检索
	 */
	public SOC0428Info searchSOC0428ByPK(Integer pk);

}