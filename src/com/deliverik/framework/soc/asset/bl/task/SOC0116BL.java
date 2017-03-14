/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * 概述: EiWaitTaskTemp业务逻辑接口
  * 功能描述: EiWaitTaskTemp业务逻辑接口
  * 创建记录: 2012/07/30
  * 修改记录: 
  */
public interface SOC0116BL extends BaseBL {

	/**
	 * EiWaitTaskTemp实例取得
	 *
	 * @return EiWaitTaskTemp实例
	 */
	public SOC0116TB getEiWaitTaskTempTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0116Info searchEiWaitTaskTempByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0116SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0116Info registEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0116Info updateEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiWaitTaskTempByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

}