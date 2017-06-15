/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG484PK;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * 概述: 流程组成员实例业务逻辑接口
  * 功能描述: 流程组成员实例业务逻辑接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG484BL extends BaseBL {

	/**
	 * 流程组成员实例实例取得
	 *
	 * @return 流程组成员实例实例
	 */
	public IG484TB getIG484TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG484Info> searchIG484();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG484Info searchIG484ByPK(IG484PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG484SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG484Info registIG484(IG484Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG484Info updateIG484(IG484Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG484ByPK(IG484PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG484(IG484Info instance)
		throws BLException;
	
	/**
	 * 通过单一流程查询组合流程实例pgrid
	 *
	 * @param prid 流程id
	 * @return 检索结果pgrid 如果返回空则当前流程不在流程组中运行
	 */
	public Integer searchIG484PgridByPrid(Integer prid);

}