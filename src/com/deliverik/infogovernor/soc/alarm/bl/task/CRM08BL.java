/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;

/**
  * 概述: CRM08业务逻辑接口
  * 功能描述: CRM08业务逻辑接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM08BL extends BaseBL {

	/**
	 * CRM08实例取得
	 *
	 * @return CRM08实例
	 */
	public CRM08TB getCRM08TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM08Info> searchCRM08();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM08Info searchCRM08ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM08SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM08Info registCRM08(CRM08Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM08Info updateCRM08(CRM08Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM08ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM08(CRM08Info instance)
		throws BLException;

}