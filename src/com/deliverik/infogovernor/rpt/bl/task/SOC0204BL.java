/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * 概述: 报表自定链接业务逻辑接口
  * 功能描述: 报表自定链接业务逻辑接口
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/10 将ReportCustomLinkBL表名修改为SOC0204BL
  */
public interface SOC0204BL extends BaseBL {

	/**
	 * 报表自定链接实例取得
	 *
	 * @return 报表自定链接实例
	 */
	public SOC0204TB getSOC0204Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0204Info> searchSOC0204();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0204Info searchSOC0204ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0204SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0204Info registSOC0204(SOC0204Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0204Info updateSOC0204(SOC0204Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0204ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0204(SOC0204Info instance)
		throws BLException;

}