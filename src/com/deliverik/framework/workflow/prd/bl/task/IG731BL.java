/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;

/**
 * 流程与资产关系业务逻辑
 * 
 */

public interface IG731BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG731InfoSearchCount(IG731SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pieid 流程状态变量前处理ID
	 * @return 流程状态变量前处理信息
	 */
	
	public IG731Info searchIG731InfoByKey(Integer pieid) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG731Info> searchIG731Info(IG731SearchCond cond);

	/**
	 * 新增处理
	 * 
	 * @param IG731Info 新增数据
	 * @return 资产信息
	 */
	
	public IG731Info registIG731Info(
			IG731Info processInfoEntity) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pieid 删除流程状态变量前处理主键
	 * @return
	 */
	
	public void deleteIG731Info(Integer pieid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig731Info 变更数据
	 * @return 流程状态变量前处理
	 */
	
	public IG731Info updateIG731Info(
			IG731Info ig731Info) throws BLException;
	
	
	/**
	 * 条件检索处理
	 * 
	 * @param prid 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG731Info> searchIG731InfoByPrid(Integer prid);
	
	/**
	 * 通过场景prid查询相关的业务系统资产
	 * @param prid
	 * @return 检索结果列表
	 */
	public List<IG731Info> searchIG731InfoBySePrid(Integer prid,String flowType);

	/**
	 * 根据流程prid查询场景的eiid
	 * @param prid 流程id
	 * @param flowType 流程类型
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid( Integer prid, String flowType);
}
