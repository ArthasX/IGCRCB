/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;

/**
 * 流程与资产关系业务逻辑
 * 
 */

public interface QuartzProcessInfoEntityBL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getQuartzProcessInfoEntitySearchCount(QuartzProcessInfoEntitySearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pieid 流程状态变量前处理ID
	 * @return 流程状态变量前处理信息
	 */
	
	public QuartzProcessInfoEntity searchQuartzProcessInfoEntityByKey(Integer pieid) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntity(QuartzProcessInfoEntitySearchCond cond);

	/**
	 * 新增处理
	 * 
	 * @param QuartzProcessInfoEntity 新增数据
	 * @return 资产信息
	 */
	
	public QuartzProcessInfoEntity registQuartzProcessInfoEntity(
			QuartzProcessInfoEntity processInfoEntity) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pieid 删除流程状态变量前处理主键
	 * @return
	 */
	
	public void deleteQuartzProcessInfoEntity(Integer pieid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param processInfoEntity 变更数据
	 * @return 流程状态变量前处理
	 */
	
	public QuartzProcessInfoEntity updateQuartzProcessInfoEntity(
			QuartzProcessInfoEntity processInfoEntity) throws BLException;
	
	
	/**
	 * 条件检索处理
	 * 
	 * @param prid 检索条件
	 * @return 检索结果列表
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityByPrid(Integer prid);

}
