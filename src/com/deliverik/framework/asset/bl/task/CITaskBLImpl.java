/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.dao.CITaskDAO;
import com.deliverik.framework.asset.model.entity.CITaskTB;

/**
  * 概述: CI变更任务表业务逻辑实现
  * 功能描述: CI变更任务表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CITaskBLImpl extends BaseBLImpl implements
		CITaskBL {

	/** CI变更任务表DAO接口 */
	protected CITaskDAO ciTaskDAO;
	
	/**
	 * CI变更任务表DAO接口设定
	 *
	 * @param ciTaskDAO CI变更任务表DAO接口
	 */
	public void setCiTaskDAO(CITaskDAO ciTaskDAO) {
		this.ciTaskDAO = ciTaskDAO;
	}

	/**
	 * CI变更任务表实例取得
	 *
	 * @return CI变更任务表实例
	 */
	public CITaskTB getCITaskTBInstance() {
		return new CITaskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CITaskInfo> searchCITask() {
		return ciTaskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CITaskInfo searchCITaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CITaskSearchCond cond) {
		return ciTaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond) {
		return ciTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CITaskInfo> searchCITask(
			CITaskSearchCond cond, int start,
			int count) {
		return ciTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CITaskInfo registCITask(CITaskInfo instance)
		throws BLException {
		return ciTaskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CITaskInfo updateCITask(CITaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCitid());
		return ciTaskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCITaskByPK(Integer pk)
		throws BLException {
		ciTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCITask(CITaskInfo instance)
		throws BLException {
		ciTaskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CITaskInfo checkExistInstance(Integer pk)
		throws BLException {
		CITaskInfo instance = ciTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}