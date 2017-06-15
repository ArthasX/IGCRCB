/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.ProcessTimeDAO;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;


/**
  * 概述: 流程计时表业务逻辑实现
  * 功能描述: 流程计时表业务逻辑实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public class ProcessTimeBLImpl extends BaseBLImpl implements
		ProcessTimeBL {

	/** 流程计时表DAO接口 */
	protected ProcessTimeDAO processTimeDAO;
	
	/**
	 * 流程计时表DAO接口设定
	 *
	 * @param processTimeDAO流程计时表DAO接口
	 */
	public void setProcessTimeDAO(ProcessTimeDAO processTimeDAO) {
		this.processTimeDAO = processTimeDAO;
	}

	/**
	 * 流程计时表实例取得
	 *
	 * @return 流程计时表实例
	 */
	public ProcessTimeTB getProcessTimeTBInstance() {
		return new ProcessTimeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessTimeInfo> searchProcessTime() {
		return processTimeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public ProcessTimeInfo searchProcessTimeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProcessTimeSearchCond cond) {
		return processTimeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond) {
		return processTimeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond, int start,
			int count) {
		return processTimeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public ProcessTimeInfo registProcessTime(ProcessTimeInfo instance)
		throws BLException {
		return processTimeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public ProcessTimeInfo updateProcessTime(ProcessTimeInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrtid());
		return processTimeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteProcessTimeByPK(Integer pk)
		throws BLException {
		processTimeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteProcessTime(ProcessTimeInfo instance)
		throws BLException {
		processTimeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public ProcessTimeInfo checkExistInstance(Integer pk)
		throws BLException {
		ProcessTimeInfo instance = processTimeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}