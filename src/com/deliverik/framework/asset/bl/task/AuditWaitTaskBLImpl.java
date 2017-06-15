/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.AuditWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;

/**
  * 概述: 审计待处理任务业务逻辑实现
  * 功能描述: 审计待处理任务业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditWaitTaskBLImpl extends BaseBLImpl implements
		AuditWaitTaskBL {

	/** 审计待处理任务DAO接口 */
	protected AuditWaitTaskDAO auditWaitTaskDAO;
	
	/**
	 * 审计待处理任务DAO接口设定
	 *
	 * @param auditWaitTaskDAO 审计待处理任务DAO接口
	 */
	public void setAuditWaitTaskDAO(AuditWaitTaskDAO auditWaitTaskDAO) {
		this.auditWaitTaskDAO = auditWaitTaskDAO;
	}

	/**
	 * 审计待处理任务实例取得
	 *
	 * @return 审计待处理任务实例
	 */
	public AuditWaitTaskTB getAuditWaitTaskTBInstance() {
		return new AuditWaitTaskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask() {
		return auditWaitTaskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditWaitTaskInfo searchAuditWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditWaitTaskSearchCond cond) {
		return auditWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond) {
		return auditWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditWaitTaskInfo> searchAuditWaitTask(
			AuditWaitTaskSearchCond cond, int start,
			int count) {
		return auditWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditWaitTaskInfo registAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		return auditWaitTaskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditWaitTaskInfo updateAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getAuwtid());
		return auditWaitTaskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditWaitTaskByPK(Integer pk)
		throws BLException {
		auditWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditWaitTask(AuditWaitTaskInfo instance)
		throws BLException {
		auditWaitTaskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AuditWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditWaitTaskInfo instance = auditWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}