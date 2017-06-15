/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;
import com.deliverik.infogovernor.iam.model.dao.InternalauditprjDAO;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
  * 概述: 内审项目业务逻辑实现
  * 功能描述: 内审项目业务逻辑实现
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
public class InternalauditprjBLImpl extends BaseBLImpl implements
		InternalauditprjBL {

	/** 内审项目DAO接口 */
	protected InternalauditprjDAO internalauditprjDAO;
	
	/**
	 * 内审项目DAO接口设定
	 *
	 * @param internalauditprjDAO 内审项目DAO接口
	 */
	public void setInternalauditprjDAO(InternalauditprjDAO internalauditprjDAO) {
		this.internalauditprjDAO = internalauditprjDAO;
	}

	/**
	 * 内审项目实例取得
	 *
	 * @return 内审项目实例
	 */
	public InternalauditprjTB getInternalauditprjTBInstance() {
		return new InternalauditprjTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InternalauditprjInfo> searchInternalauditprj() {
		return internalauditprjDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InternalauditprjInfo searchInternalauditprjByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(InternalauditprjSearchCond cond) {
		return internalauditprjDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond) {
		return internalauditprjDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond, int start,
			int count) {
		return internalauditprjDAO.findByCond(cond, start, count);
	}
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(
			InternalauditprjSearchCond cond, int start,
			int count) {
		return internalauditprjDAO.auditProjectHelpSearch(cond, start, count);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond){
		return internalauditprjDAO.auditProjectHelpSearchConut(cond);
	}
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public InternalauditprjInfo registInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		return internalauditprjDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public InternalauditprjInfo updateInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		checkExistInstance(instance.getIapId());
		return internalauditprjDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteInternalauditprjByPK(Integer pk)
		throws BLException {
		internalauditprjDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		internalauditprjDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public InternalauditprjInfo checkExistInstance(Integer pk)
		throws BLException {
		InternalauditprjInfo instance = internalauditprjDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}