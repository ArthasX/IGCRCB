/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485PK;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * 概述: 流程组关联关系实例表业务逻辑接口
  * 功能描述: 流程组关联关系实例表业务逻辑接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG485BL extends BaseBL {

	/**
	 * 流程组关联关系实例表实例取得
	 *
	 * @return 流程组关联关系实例表实例
	 */
	public IG485TB getIG485TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG485Info> searchIG485();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG485Info searchIG485ByPK(IG485PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG485SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG485Info registIG485(IG485Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG485Info updateIG485(IG485Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG485ByPK(IG485PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG485(IG485Info instance)
		throws BLException;
	
	/**
	 * 判断指定状态是否需要挂起
	 * @param prid 影响流程ID
	 * @param pgrid 流程组实例ID
	 * @param pgdid 流程组定义ID
	 * @param ipsdid 影响状态ID
	 * @return 是否需要挂起
	 */
	public boolean checkPend(Integer pgrid, String pgdid, String ipsdid);
	
	/**
	 * 判断指定参考状态处理完成时，其对应的影响状态相关流程是否跃迁
	 * @param prid 影响流程ID
	 * @param pgrid 流程组实例ID
	 * @param pgdid 流程组定义ID
	 * @param rpsdid 参考状态ID
	 * @param rtpsdid 参考流程目的状态ID集合
	 * @return 跃迁流程ID集合
	 */
	public List<IG224VW> searchTriggerPrid(Integer prid, Integer pgrid,
			String pgdid, String rpsdid, List<String> rtpsdids);
	
	/**
	 * 查询关联关系实例未处理记录
	 * @param prid 参考流程ID
	 * @param rpsdid 参考流程状态ID
	 * @return 未处理记录
	 */
	public List<IG485VW> searchNotDone(Integer prid, String rpsdid);

}