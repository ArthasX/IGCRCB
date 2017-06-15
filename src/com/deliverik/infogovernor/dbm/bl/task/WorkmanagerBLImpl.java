/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.WorkmanagerDAO;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * 概述: 工作管理业务逻辑实现
  * 功能描述: 工作管理业务逻辑实现
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public class WorkmanagerBLImpl extends BaseBLImpl implements
		WorkmanagerBL {

	/** 工作管理DAO接口 */
	protected WorkmanagerDAO workmanagerDAO;
	
	/**
	 * 工作管理DAO接口设定
	 *
	 * @param workmanagerDAO 工作管理DAO接口
	 */
	public void setWorkmanagerDAO(WorkmanagerDAO workmanagerDAO) {
		this.workmanagerDAO = workmanagerDAO;
	}

	/**
	 * 工作管理实例取得
	 *
	 * @return 工作管理实例
	 */
	public WorkmanagerTB getWorkmanagerTBInstance() {
		return new WorkmanagerTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkmanagerInfo> searchWorkmanager() {
		return workmanagerDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkmanagerInfo searchWorkmanagerByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkmanagerSearchCond cond) {
		return workmanagerDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond) {
		return workmanagerDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond, int start,
			int count) {
		return workmanagerDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkmanagerInfo registWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		return workmanagerDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkmanagerInfo updateWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		checkExistInstance(instance.getWmid());
		return workmanagerDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkmanagerByPK(Integer pk)
		throws BLException {
		workmanagerDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkmanager(WorkmanagerInfo instance)
		throws BLException {
		workmanagerDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public WorkmanagerInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkmanagerInfo instance = workmanagerDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 查询当前工作复制版本中最新的一条
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchNewWorkmanager(WorkmanagerSearchCond cond) {
		return workmanagerDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 统计待处理工作
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerVW> searchSumByCond(WorkmanagerSearchCond cond) {
		return workmanagerDAO.searchSumByCond(cond);
	}
}