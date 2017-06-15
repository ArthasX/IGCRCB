/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * 概述: 监控任务主表业务逻辑接口
  * 功能描述: 监控任务主表业务逻辑接口
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public interface SOC0304BL extends BaseBL {

	/**
	 * 监控任务主表实例取得
	 *
	 * @return 监控任务主表实例
	 */
	public SOC0304TB getSoc0304Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0304Info> searchSoc0304();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0304Info searchSoc0304ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0304SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0304Info registSoc0304(SOC0304Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0304Info updateSoc0304(SOC0304Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSoc0304ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSoc0304(SOC0304Info instance)
		throws BLException;

}