/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.asset.model.entity.IG749VW;

/**
  * 概述: 资产模型视图业务逻辑接口
  * 功能描述: 资产模型视图业务逻辑接口
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public interface IG749BL extends BaseBL {

	/**
	 * 资产模型视图实例取得
	 *
	 * @return 资产模型视图实例
	 */
	public IG749VW getIG749VWInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG749Info> searchIG749Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public IG749Info searchIG749InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG749SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param ig749Info新增实例
	 * @return 新增实例
	 */
	public IG749Info registIG749Info(IG749Info ig749Info)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param ig749Info修改实例
	 * @return 修改实例
	 */
	public IG749Info updateIG749Info(IG749Info ig749Info)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteIG749InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteIG749Info(IG749Info ig749Info)
		throws BLException;

}