/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;

/**
  * 概述: 流程外部调用定义表业务逻辑接口
  * 功能描述: 流程外部调用定义表业务逻辑接口
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public interface IG992BL extends BaseBL {

	/**
	 * 流程外部调用定义表实例取得
	 *
	 * @return 流程外部调用定义表实例
	 */
	public IG992TB getIG992TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG992Info> searchIG992Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG992Info searchIG992InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG992SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG992Info registIG992Info(IG992Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG992Info updateIG992Info(IG992Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG992InfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG992Info(IG992Info instance)
		throws BLException;
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getPedidSequenceNextValue(String psdid);

}