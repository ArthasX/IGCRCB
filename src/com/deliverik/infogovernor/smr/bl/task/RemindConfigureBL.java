/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * 概述: 提醒配置表业务逻辑接口
  * 功能描述: 提醒配置表业务逻辑接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface RemindConfigureBL extends BaseBL {

	/**
	 * 提醒配置表实例取得
	 *
	 * @return 提醒配置表实例
	 */
	public RemindConfigureTB getRemindConfigureTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindConfigureInfo> searchRemindConfigure();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindConfigureInfo searchRemindConfigureByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RemindConfigureSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RemindConfigureInfo registRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RemindConfigureInfo updateRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRemindConfigureByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

}