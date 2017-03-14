/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditConfigItemInfo;
import com.deliverik.framework.asset.model.condition.AuditConfigItemSearchCond;
import com.deliverik.framework.asset.model.dao.AuditConfigItemDAO;
import com.deliverik.framework.asset.model.entity.AuditConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 审计资产属性表业务逻辑实现
  * 功能描述: 审计资产属性表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditConfigItemBLImpl extends BaseBLImpl implements
		AuditConfigItemBL {

	/** 审计资产属性表DAO接口 */
	protected AuditConfigItemDAO auditConfigItemDAO;
	
	/**
	 * 审计资产属性表DAO接口设定
	 *
	 * @param auditConfigItemDAO 审计资产属性表DAO接口
	 */
	public void setAuditConfigItemDAO(AuditConfigItemDAO auditConfigItemDAO) {
		this.auditConfigItemDAO = auditConfigItemDAO;
	}

	/**
	 * 审计资产属性表实例取得
	 *
	 * @return 审计资产属性表实例
	 */
	public AuditConfigItemTB getAuditConfigItemTBInstance() {
		return new AuditConfigItemTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem() {
		return auditConfigItemDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditConfigItemInfo searchAuditConfigItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AuditConfigItemSearchCond cond) {
		return auditConfigItemDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem(
			AuditConfigItemSearchCond cond) {
		return auditConfigItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem(
			AuditConfigItemSearchCond cond, int start,
			int count) {
		return auditConfigItemDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AuditConfigItemInfo registAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		return auditConfigItemDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AuditConfigItemInfo updateAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return auditConfigItemDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAuditConfigItemByPK(Integer pk)
		throws BLException {
		auditConfigItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		auditConfigItemDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AuditConfigItemInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditConfigItemInfo instance = auditConfigItemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 检索资产属性及属性对比分类
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItemForAucmptype(Integer eiid){
		return auditConfigItemDAO.searchAuditConfigItemForAucmptype(eiid);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAuditConfigItem(){
		return auditConfigItemDAO.deleteAuditConfigItem();
	}

}