/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;
import com.deliverik.plugin.change.model.dao.InitiateChangLogDAO;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
  * 概述: 发起变更流程日志业务逻辑实现
  * 功能描述: 发起变更流程日志业务逻辑实现
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
public class InitiateChangLogBLImpl extends BaseBLImpl implements
		InitiateChangLogBL {

	/** 发起变更流程日志DAO接口 */
	protected InitiateChangLogDAO initiateChangLogDAO;
	
	/**
	 * 发起变更流程日志DAO接口设定
	 *
	 * @param initiateChangLogDAO 发起变更流程日志DAO接口
	 */
	public void setInitiateChangLogDAO(InitiateChangLogDAO initiateChangLogDAO) {
		this.initiateChangLogDAO = initiateChangLogDAO;
	}

	/**
	 * 发起变更流程日志实例取得
	 *
	 * @return 发起变更流程日志实例
	 */
	public InitiateChangLogTB getInitiateChangLogTBInstance() {
		return new InitiateChangLogTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog() {
		return initiateChangLogDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InitiateChangLogInfo searchInitiateChangLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(InitiateChangLogSearchCond cond) {
		return initiateChangLogDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond) {
		return initiateChangLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond, int start,
			int count) {
		return initiateChangLogDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public InitiateChangLogInfo registInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		return initiateChangLogDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public InitiateChangLogInfo updateInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getIcid());
		return initiateChangLogDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteInitiateChangLogByPK(Integer pk)
		throws BLException {
		initiateChangLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException {
		initiateChangLogDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public InitiateChangLogInfo checkExistInstance(Integer pk)
		throws BLException {
		InitiateChangLogInfo instance = initiateChangLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}