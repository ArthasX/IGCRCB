/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: 合同资产信息视图业务逻辑接口
  * 功能描述: 合同资产信息视图业务逻辑接口
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public interface IG499BL extends BaseBL {

	/**
	 * 合同资产信息视图实例取得
	 *
	 * @return 合同资产信息视图实例
	 */
	public IG499VW getIG499VWInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG499Info> searchIG499Info();

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG499SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond, int start,
			int count);
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchImprestCount(IG499SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG499Info> findImprestByCond(IG499SearchCond cond, 
			int start, int count);
}