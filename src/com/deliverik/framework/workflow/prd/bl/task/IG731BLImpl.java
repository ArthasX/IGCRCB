/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG731DAO;

/**
 * <p>概述:流程与资产关系业务逻辑实现</p>
 * <p>功能描述：1.主键检索处理</p>
 * <p>          2.条件检索处理</p>
 * <p>          3.全部检索处理</p>
 * <p>          4.新增处理</p>
 * <p>          5.删除处理</p>
 * <p>          6.变更处理</p>
 * <p>          7.通过流程ID检索处理</p>
 * <p>创建记录:</p>
 */
public class IG731BLImpl extends BaseBLImpl implements IG731BL {
	
	/** 流程与资产关系DAO操作 */
	protected IG731DAO ig731DAO;

	/**
	 * 流程与资产关系DAO
	 * @param ig731DAO流程与资产关系DAO
	 */
	public void setIg731DAO(
			IG731DAO ig731DAO) {
		this.ig731DAO = ig731DAO;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG731InfoSearchCount(IG731SearchCond cond) {
		return ig731DAO.getSearchCount(cond);
	}
	
	

	/**
	 * 功能：主键检索处理
	 * 
	 * @param pieid 流程状态跃迁规则ID
	 * @return 流程状态跃迁规则信息
	 * @throws BLException 
	 */
	
	public IG731Info searchIG731InfoByKey(Integer pieid) throws BLException {
		return ig731DAO.findByPK(pieid);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG731Info> searchIG731Info(
			IG731SearchCond cond) {
		return ig731DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG731Info> searchProcessInfoEntityAll() {
		return ig731DAO.findAll();
	}

	/**
	 * 功能：新增处理
	 * 
	 * @param IG731Info 新增数据
	 * @return 资产信息
	 * @throws BLException
	 */
	
	public IG731Info registIG731Info(
			IG731Info processInfoEntity) throws BLException {
		return ig731DAO.save(processInfoEntity);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param pieid 删除流程状态跃迁规则主键
	 * @throws BLException
	 */
	
	public void deleteIG731Info(Integer pieid) throws BLException {
		IG731Info processInfoEntity = ig731DAO.findByPK(pieid);
		ig731DAO.delete(processInfoEntity);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param ig731Info 变更数据
	 * @return 流程状态跃迁规则
	 * @throws BLException
	 */
	
	public IG731Info updateIG731Info(
			IG731Info ig731Info) throws BLException {
		return ig731DAO.save(ig731Info);
	}
	
	/**
	 * 功能：通过流程ID检索处理
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	
	public List<IG731Info> searchIG731InfoByPrid(Integer prid) {
		IG731SearchCondImpl cond = new IG731SearchCondImpl();
		cond.setPrid(prid);
		return ig731DAO.findByCond(cond, 0, 0);
	}


	/**
	 * 通过场景prid查询相关的业务系统资产
	 * @param prid
	 * @return 检索结果列表
	 */
	public List<IG731Info> searchIG731InfoBySePrid(Integer prid,String flowType){
		return ig731DAO.searchIG731InfoBySePrid(prid,flowType);
	}

	
	/**
	 * 根据流程prid查询场景的eiid
	 * @param prid 流程id
	 * @param flowType 流程类型
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid( Integer prid, String flowType){
		return ig731DAO.searchSenceBySePrid(prid,flowType);
	}
}
