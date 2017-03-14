/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;

/**
  * 概述: 流程表单值表业务逻辑接口
  * 功能描述: 流程表单值表业务逻辑接口
  * 创建记录: 2013/08/28
  * 修改记录: 
  */
public interface IG505BL extends BaseBL {

	/**
	 * 流程表单值表实例取得
	 *
	 * @return 流程表单值表实例
	 */
	public IG505TB getIG505TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG505Info> searchIG505();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG505Info searchIG505ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG505SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG505Info> searchIG505(
			IG505SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG505Info> searchIG505(
			IG505SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG505Info registIG505(IG505Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG505Info updateIG505(IG505Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG505ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG505(IG505Info instance)
		throws BLException;
	
	/**
	 * 根据流程主键检索
	 * @param prid 流程主键
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG505Info> findByPrid(Integer prid) throws BLException;

}