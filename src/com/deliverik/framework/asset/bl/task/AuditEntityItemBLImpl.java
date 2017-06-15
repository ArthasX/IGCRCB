/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.asset.model.dao.AuditEntityItemDAO;
import com.deliverik.framework.asset.model.entity.AuditEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 审计资产表业务逻辑实现
  * 功能描述: 审计资产表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditEntityItemBLImpl extends BaseBLImpl implements
		AuditEntityItemBL {

	/** 审计资产表DAO接口 */
	protected AuditEntityItemDAO auditEntityItemDAO;
	
	/**
	 * 审计资产表DAO接口设定
	 *
	 * @param auditEntityItemDAO 审计资产表DAO接口
	 */
	public void setAuditEntityItemDAO(AuditEntityItemDAO auditEntityItemDAO) {
		this.auditEntityItemDAO = auditEntityItemDAO;
	}

	/**
	 * 审计资产表实例取得
	 *
	 * @return 审计资产表实例
	 */
	public AuditEntityItemTB getAuditEntityItemTBInstance() {
		return new AuditEntityItemTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem() {
		return auditEntityItemDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditEntityItemInfo searchAuditEntityItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditEntityItemSearchCond cond) {
		return auditEntityItemDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond) {
		return auditEntityItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond, int start,
			int count) {
		return auditEntityItemDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditEntityItemInfo registAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		return auditEntityItemDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditEntityItemInfo updateAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return auditEntityItemDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditEntityItemByPK(Integer pk)
		throws BLException {
		auditEntityItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		auditEntityItemDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AuditEntityItemInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditEntityItemInfo instance = auditEntityItemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAuditEntityItem(){
		return auditEntityItemDAO.deleteAuditEntityItem();
	}

}