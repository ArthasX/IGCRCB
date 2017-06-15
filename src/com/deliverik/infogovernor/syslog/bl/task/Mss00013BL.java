/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * 概述: mss00013业务逻辑接口
  * 功能描述: mss00013业务逻辑接口
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
public interface Mss00013BL extends BaseBL {

	/**
	 * mss00013实例取得
	 *
	 * @return mss00013实例
	 */
	public Mss00013TB getMss00013TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00013Info> searchMss00013();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00013Info searchMss00013ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00013SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00013Info registMss00013(Mss00013Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00013Info updateMss00013(Mss00013Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00013ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00013(Mss00013Info instance)
		throws BLException;

}