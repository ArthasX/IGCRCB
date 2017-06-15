/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;

/**
  * 概述: 参与者按钮定义信息表视图业务逻辑接口
  * 功能描述: 参与者按钮定义信息表视图业务逻辑接口
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
public interface IG221BL extends BaseBL {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG221Info> searchIG221Info();

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG221SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221InfoVW(
			IG221SearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG221Info registIG221Info(IG221Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG221Info updateIG221Info(IG221Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG221Info(IG221Info instance)
		throws BLException;

}