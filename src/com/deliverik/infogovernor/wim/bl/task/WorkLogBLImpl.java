/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkLogDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;

/**
  * 概述: workLog业务逻辑实现
  * 功能描述: workLog业务逻辑实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkLogBLImpl extends BaseBLImpl implements
		WorkLogBL {

	/** workLogDAO接口 */
	protected WorkLogDAO workLogDAO;
	
	/**
	 * workLogDAO接口设定
	 *
	 * @param workLogDAO workLogDAO接口
	 */
	public void setWorkLogDAO(WorkLogDAO workLogDAO) {
		this.workLogDAO = workLogDAO;
	}

	/**
	 * workLog实例取得
	 *
	 * @return workLog实例
	 */
	public WorkLogTB getWorkLogTBInstance() {
		return new WorkLogTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkLogInfo> searchWorkLog() {
		return workLogDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkLogInfo searchWorkLogByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkLogSearchCond cond) {
		return workLogDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkLogInfo> searchWorkLog(
			WorkLogSearchCond cond) {
		return workLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkLogInfo> searchWorkLog(
			WorkLogSearchCond cond, int start,
			int count) {
		return workLogDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkLogInfo registWorkLog(WorkLogInfo instance)
		throws BLException {
		return workLogDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkLogInfo updateWorkLog(WorkLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getWlid());
		return workLogDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkLogByPK(Integer pk)
		throws BLException {
		workLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkLog(WorkLogInfo instance)
		throws BLException {
		workLogDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public WorkLogInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkLogInfo instance = workLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}