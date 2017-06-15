/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0209VW;

/**
  * 概述: 流程来源视图业务逻辑接口
  * 功能描述: 流程来源视图业务逻辑接口
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVWBL表名改为SOC0209BL
  */
public interface SOC0209BL extends BaseBL {

	/**
	 * 流程来源视图实例取得
	 *
	 * @return 流程来源视图实例
	 */
	public SOC0209VW getSOC0209Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0209Info> searchSOC0209();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0209Info searchSOC0209ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0209SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0209Info registSOC0209(SOC0209Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0209Info updateSOC0209(SOC0209Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0209ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0209(SOC0209Info instance)
		throws BLException;

}