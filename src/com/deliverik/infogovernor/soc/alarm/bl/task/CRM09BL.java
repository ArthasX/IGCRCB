/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;

/**
  * 概述: CRM09业务逻辑接口
  * 功能描述: CRM09业务逻辑接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM09BL extends BaseBL {

	/**
	 * CRM09实例取得
	 *
	 * @return CRM09实例
	 */
	public CRM09TB getCRM09TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM09Info> searchCRM09();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM09Info searchCRM09ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM09SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM09Info registCRM09(CRM09Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM09Info updateCRM09(CRM09Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM09ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM09(CRM09Info instance)
		throws BLException;

}