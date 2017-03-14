/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0424TB;

/**
  * 概述: 报告类型表业务逻辑接口
  * 功能描述: 报告类型表业务逻辑接口
  * 创建记录: 2012/07/18
  * 修改记录: 2012/08/10 将ReportTypeBL表名修改为SOC0424BL
  */
public interface SOC0424BL extends BaseBL {

	/**
	 * 报告类型表实例取得
	 *
	 * @return 报告类型表实例
	 */
	public SOC0424TB getSOC0424Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0424Info> searchSOC0424();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0424SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0424Info registSOC0424(SOC0424Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0424Info updateSOC0424(SOC0424Info instance)
		throws BLException;


	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0424(SOC0424Info instance)
		throws BLException;

}