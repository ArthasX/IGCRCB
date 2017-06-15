/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00006SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00006TB;

/**
  * 概述: 告警信息月表业务逻辑接口
  * 功能描述: 告警信息月表业务逻辑接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00006BL extends BaseBL {

	/**
	 * 告警信息月表实例取得
	 *
	 * @return 告警信息月表实例
	 */
	public Mss00006TB getMss00006TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00006Info> searchMss00006();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00006Info searchMss00006ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00006SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond, int start,
			int count) throws Exception;

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00006Info registMss00006(Mss00006Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00006Info updateMss00006(Mss00006Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00006ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00006(Mss00006Info instance)
		throws BLException;

}