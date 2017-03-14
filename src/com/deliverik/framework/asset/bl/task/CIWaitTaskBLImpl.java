/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.CIWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;

/**
  * 概述: CI变更待处理任务业务逻辑实现
  * 功能描述: CI变更待处理任务业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIWaitTaskBLImpl extends BaseBLImpl implements
		CIWaitTaskBL {

	/** CI变更待处理任务DAO接口 */
	protected CIWaitTaskDAO ciWaitTaskDAO;
	
	/**
	 * CI变更待处理任务DAO接口设定
	 *
	 * @param ciWaitTaskDAO CI变更待处理任务DAO接口
	 */
	public void setCiWaitTaskDAO(CIWaitTaskDAO ciWaitTaskDAO) {
		this.ciWaitTaskDAO = ciWaitTaskDAO;
	}

	/**
	 * CI变更待处理任务实例取得
	 *
	 * @return CI变更待处理任务实例
	 */
	public CIWaitTaskTB getCIWaitTaskTBInstance() {
		return new CIWaitTaskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask() {
		return ciWaitTaskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIWaitTaskInfo searchCIWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIWaitTaskSearchCond cond) {
		return ciWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond) {
		return ciWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIWaitTaskInfo> searchCIWaitTask(
			CIWaitTaskSearchCond cond, int start,
			int count) {
		return ciWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIWaitTaskInfo registCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		return ciWaitTaskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIWaitTaskInfo updateCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiwtid());
		return ciWaitTaskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIWaitTaskByPK(Integer pk)
		throws BLException {
		ciWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIWaitTask(CIWaitTaskInfo instance)
		throws BLException {
		ciWaitTaskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CIWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		CIWaitTaskInfo instance = ciWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}