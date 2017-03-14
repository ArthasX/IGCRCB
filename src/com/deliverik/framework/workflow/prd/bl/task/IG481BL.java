/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG481PK;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;

/**
  * 概述: 流程组成员表业务逻辑接口
  * 功能描述: 流程组成员表业务逻辑接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG481BL extends BaseBL {

	/**
	 * 流程组成员表实例取得
	 *
	 * @return 流程组成员表实例
	 */
	public IG481TB getIG481TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG481Info> searchIG481();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG481Info searchIG481ByPK(IG481PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG481SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG481Info registIG481(IG481Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG481Info updateIG481(IG481Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG481ByPK(IG481PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG481(IG481Info instance)
		throws BLException;
	
	/**
	 * 根据条件删除
	 * @param cond
	 */
	public void deleteByCond(IG481SearchCond cond)throws BLException;
	
	/**
	 * 根据流程定义ID查询组定义列表
	 * @param pdid 流程定义ID
	 * @return 组定义列表
	 */
	public List<IG480Info> searchIG480(String pdid);

}