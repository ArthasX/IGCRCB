/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskcaseVWTB;

/**
  * 概述: 风险事件业务逻辑接口
  * 功能描述: 风险事件业务逻辑接口
  * 创建记录: 2014/07/18
  * 修改记录: 
  */
public interface RiskcaseVWBL extends BaseBL {

	/**
	 * 风险事件实例取得
	 *
	 * @return 风险事件实例
	 */
	public RiskcaseVWTB getRiskcaseVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskcaseVWInfo searchRiskcaseVWByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskcaseVWSearchCond cond);

	/**
	 * 风险事件应对策略查询
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond);
	
	/**
	 * 风险事件版本查询
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskcaseVWInfo> searchRiskcaseByVersion(
			RiskcaseVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond, int start,
			int count);

}