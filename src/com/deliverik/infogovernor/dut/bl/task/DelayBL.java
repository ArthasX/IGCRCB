/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;
import com.deliverik.infogovernor.dut.model.entity.DelayTB;

/**
  * 概述: 延时解锁信息表业务逻辑接口
  * 功能描述: 延时解锁信息表业务逻辑接口
  * 创建记录: 2012/04/05
  * 修改记录: 
  */
public interface DelayBL extends BaseBL {

	/**
	 * 延时解锁信息表实例取得
	 *
	 * @return 延时解锁信息表实例
	 */
	public DelayTB getDelayTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DelayInfo> searchDelay();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DelayInfo searchDelayByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(DelaySearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public DelayInfo registDelay(DelayInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public DelayInfo updateDelay(DelayInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteDelayByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteDelay(DelayInfo instance)
		throws BLException;

}