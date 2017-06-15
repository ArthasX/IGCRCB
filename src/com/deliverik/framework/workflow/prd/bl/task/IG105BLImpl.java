/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG105DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;

/**
 * 概述: 流程策略设定信息业务逻辑实现
 * 功能描述：流程策略设定信息业务逻辑实现
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public class IG105BLImpl extends BaseBLImpl implements
	IG105BL {

	/** 流程事件定义DAO */
	protected IG105DAO ig105DAO;

	/**
	 * 流程事件定义DAO
	 * 
	 * @param processStrategyDefDAO流程事件定义DAO
	 */
	public void setIg105DAO(
			IG105DAO ig105DAO) {
		this.ig105DAO = ig105DAO;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG105SearchCond cond) {
		return ig105DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param pk流程策略设定信息主键
	 * @return 流程策略设定信息
	 */
	public IG105Info searchIG105InfoByKey(IG105PK pk)
			throws BLException {

		return ig105DAO.findByPK(pk);
	}

	/**
	 * 功能：全部检索处理
	 * 
	 * @return 全部流程策略设定信息
	 */
	public List<IG105Info> searchIG105InfoAll() {
		return ig105DAO.findAll();
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG105Info> searchIG105Info(
			IG105SearchCond cond, int start, int count) {
		return ig105DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG105Info> searchIG105Info(IG105SearchCond cond) {
		return ig105DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 功能：登录处理
	 * 
	 * @param processStrategyDef登录数据
	 * @return 流程策略设定信息
	 */
	public IG105Info registIG105Info(IG105Info ig105Info)
			throws BLException {
		return ig105DAO.save(ig105Info);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param pk流程策略设定信息主键
	 */
	public void deleteIG105Info(IG105PK pk) throws BLException {

		IG105Info processStrategyDef = checkExistIG105Info(pk);

		ig105DAO.delete(processStrategyDef);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param processStrategyDef变更数据
	 * @return 流程策略设定信息
	 */
	public IG105Info updateIG105Info(IG105Info ig105Info)
			throws BLException {
		IG105PK pk = new IG105PK(ig105Info.getPdid(), ig105Info.getPrstatus(), 
				ig105Info.getPrurgency(), ig105Info.getPsdversion());
		checkExistIG105Info(pk);
		return ig105DAO.save(ig105Info);
	}

	/**
	 * 功能：流程策略设定信息存在检查
	 * 
	 * @param pk流程策略设定信息主键
	 * @return 流程策略设定信息
	 * @throws BLException
	 */
	protected IG105Info checkExistIG105Info(IG105PK pk)
			throws BLException {
		IG105Info info = ig105DAO.findByPK(pk);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "流程策略设定基本");
		}
		return info;
	}
	
	/**
	 * 功能：获取指定流程定义ID当前策略最大版本号
	 * @param pdid流程定义ID
	 * @return 当前策略最大版本号
	 */
	public Integer getMaxgPsdversion(String pdid) {
		return ig105DAO.getMaxgPsdversion(pdid);
	}
	
}
