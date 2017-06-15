/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * 概述: 流程记录节点提醒视图业务逻辑接口
  * 功能描述: 流程记录节点提醒视图业务逻辑接口
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public interface IG064BL extends BaseBL {

	/**
	 * 流程记录节点提醒视图实例取得
	 *
	 * @return 流程记录节点提醒视图实例
	 */
	public IG064VW getIG064VWInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG064Info> searchIG064Info();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG064SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param ig064Info 新增实例
	 * @return 新增实例
	 */
	public IG064Info registIG064Info(IG064Info ig064Info)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param ig064Info 修改实例
	 * @return 修改实例
	 */
	public IG064Info updateIG064Info(IG064Info ig064Info)
		throws BLException;


	/**
	 * 删除处理
	 *
	 * @param ig064Info 删除实例
	 */
	public void deleteIG064Info(IG064Info ig064Info)
		throws BLException;

}