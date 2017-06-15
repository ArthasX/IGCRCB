/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.dao.AuditResultDAO;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 审计对比结果信息表业务逻辑实现
  * 功能描述: 审计对比结果信息表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditResultBLImpl extends BaseBLImpl implements
		AuditResultBL {

	/** 审计对比结果信息表DAO接口 */
	protected AuditResultDAO auditResultDAO;
	
	/**
	 * 审计对比结果信息表DAO接口设定
	 *
	 * @param auditResultDAO 审计对比结果信息表DAO接口
	 */
	public void setAuditResultDAO(AuditResultDAO auditResultDAO) {
		this.auditResultDAO = auditResultDAO;
	}

	/**
	 * 审计对比结果信息表实例取得
	 *
	 * @return 审计对比结果信息表实例
	 */
	public AuditResultTB getAuditResultTBInstance() {
		return new AuditResultTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditResultInfo> searchAuditResult() {
		return auditResultDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditResultInfo searchAuditResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditResultSearchCond cond) {
		return auditResultDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond) {
		return auditResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond, int start,
			int count) {
		return auditResultDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditResultInfo registAuditResult(AuditResultInfo instance)
		throws BLException {
		return auditResultDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditResultInfo updateAuditResult(AuditResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getAurid());
		return auditResultDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditResultByPK(Integer pk)
		throws BLException {
		auditResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditResult(AuditResultInfo instance)
		throws BLException {
		auditResultDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AuditResultInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditResultInfo instance = auditResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateAuditResultWithout(AuditResultSearchCond cond)
		throws BLException{
		return auditResultDAO.updateAuditResultWithout(cond);
	}

}