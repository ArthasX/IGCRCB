/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;

/**
  * 概述: 流程组实例表业务逻辑接口
  * 功能描述: 流程组实例表业务逻辑接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG483BL extends BaseBL {

	/**
	 * 流程组实例表实例取得
	 *
	 * @return 流程组实例表实例
	 */
	public IG483TB getIG483TBInstance();
	
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG483Info> searchIG483();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG483Info searchIG483ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG483SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG483Info registIG483(IG483Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG483Info updateIG483(IG483Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG483ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG483(IG483Info instance)
		throws BLException;
	
	/**
	 * 查询流程组成员列表
	 * @param pgrid 流程组ID
	 * @return 流程组成员列表
	 */
	public List<IG500Info> searchProcess(Integer pgrid);

	/**
	 * 查询流程组外发起的流程prid
	 * @param pgrid 检索条件-流程组实例ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid);
	
}