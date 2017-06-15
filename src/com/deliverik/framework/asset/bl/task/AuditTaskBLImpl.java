/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.dao.AuditTaskDAO;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;

/**
  * 概述: 审计任务表业务逻辑实现
  * 功能描述: 审计任务表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditTaskBLImpl extends BaseBLImpl implements
		AuditTaskBL {

	/** 审计任务表DAO接口 */
	protected AuditTaskDAO auditTaskDAO;
	
	/**
	 * 审计任务表DAO接口设定
	 *
	 * @param auditTaskDAO 审计任务表DAO接口
	 */
	public void setAuditTaskDAO(AuditTaskDAO auditTaskDAO) {
		this.auditTaskDAO = auditTaskDAO;
	}

	/**
	 * 审计任务表实例取得
	 *
	 * @return 审计任务表实例
	 */
	public AuditTaskTB getAuditTaskTBInstance() {
		return new AuditTaskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditTaskInfo> searchAuditTask() {
		return auditTaskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditTaskInfo searchAuditTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditTaskSearchCond cond) {
		return auditTaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond) {
		return auditTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditTaskInfo> searchAuditTask(
			AuditTaskSearchCond cond, int start,
			int count) {
		return auditTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditTaskInfo registAuditTask(AuditTaskInfo instance)
		throws BLException {
		return auditTaskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditTaskInfo updateAuditTask(AuditTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getAutid());
		return auditTaskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditTaskByPK(Integer pk)
		throws BLException {
		auditTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditTask(AuditTaskInfo instance)
		throws BLException {
		auditTaskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AuditTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditTaskInfo instance = auditTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}