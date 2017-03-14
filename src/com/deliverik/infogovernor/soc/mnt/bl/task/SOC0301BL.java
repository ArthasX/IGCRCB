/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * 概述: DMX实时监控性能表业务逻辑接口
  * 功能描述: DMX实时监控性能表业务逻辑接口
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public interface SOC0301BL extends BaseBL {

	/**
	 * DMX实时监控性能表实例取得
	 *
	 * @return DMX实时监控性能表实例
	 */
	public SOC0301TB getSoc0301Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0301Info> searchSoc0301();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0301Info searchSoc0301ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0301SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0301Info registSoc0301(SOC0301Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0301Info updateSoc0301(SOC0301Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSoc0301ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSoc0301(SOC0301Info instance)
		throws BLException;
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301OrderByTimeAndName(
			SOC0301SearchCond cond);
}