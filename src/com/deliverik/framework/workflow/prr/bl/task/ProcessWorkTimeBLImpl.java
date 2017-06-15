/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.ProcessWorkTimeDAO;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;


/**
  * 概述: 用户作息时间定义表业务逻辑实现
  * 功能描述: 用户作息时间定义表业务逻辑实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public class ProcessWorkTimeBLImpl extends BaseBLImpl implements
		ProcessWorkTimeBL {

	/** 用户作息时间定义表DAO接口 */
	protected ProcessWorkTimeDAO processWorkTimeDAO;
	
	/**
	 * 用户作息时间定义表DAO接口设定
	 *
	 * @param processWorkTimeDAO用户作息时间定义表DAO接口
	 */
	public void setProcessWorkTimeDAO(ProcessWorkTimeDAO processWorkTimeDAO) {
		this.processWorkTimeDAO = processWorkTimeDAO;
	}

	/**
	 * 用户作息时间定义表实例取得
	 *
	 * @return 用户作息时间定义表实例
	 */
	public ProcessWorkTimeTB getProcessWorkTimeTBInstance() {
		return new ProcessWorkTimeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime() {
		return processWorkTimeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public ProcessWorkTimeInfo searchProcessWorkTimeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProcessWorkTimeSearchCond cond) {
		return processWorkTimeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime(
			ProcessWorkTimeSearchCond cond) {
		return processWorkTimeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessWorkTimeInfo> searchProcessWorkTime(
			ProcessWorkTimeSearchCond cond, int start,
			int count) {
		return processWorkTimeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public ProcessWorkTimeInfo registProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		return processWorkTimeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public ProcessWorkTimeInfo updateProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		checkExistInstance(instance.getPwId());
		return processWorkTimeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteProcessWorkTimeByPK(Integer pk)
		throws BLException {
		processWorkTimeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteProcessWorkTime(ProcessWorkTimeInfo instance)
		throws BLException {
		processWorkTimeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public ProcessWorkTimeInfo checkExistInstance(Integer pk)
		throws BLException {
		ProcessWorkTimeInfo instance = processWorkTimeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}