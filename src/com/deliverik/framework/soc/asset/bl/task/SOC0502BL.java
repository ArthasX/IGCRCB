/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0502TB;

/**
  * 概述: SOC0502业务逻辑接口
  * 功能描述: SOC0502业务逻辑接口
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public interface SOC0502BL extends BaseBL {

	/**
	 * SOC0502实例取得
	 *
	 * @return SOC0502实例
	 */
	public SOC0502TB getSoc0502Instance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0502Info> searchSoc0502();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0502Info searchSoc0502ByPK(Integer id)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0502SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0502Info> searchSoc0502(
			SOC0502SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0502Info> searchSoc0502(
			SOC0502SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0502Info registSoc0502(SOC0502Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0502Info updateSoc0502(SOC0502Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSoc0502ByPK(Integer id)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSoc0502(Integer[] rids)
		throws BLException;

	
	public int getVWSearchCount(SOC0502SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0502Info> searchSOC0502(
			SOC0502SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}