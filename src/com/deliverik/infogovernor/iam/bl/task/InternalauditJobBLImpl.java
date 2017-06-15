/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;
import com.deliverik.infogovernor.iam.model.dao.InternalauditJobDAO;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
  * 概述: 内置工作表业务逻辑实现
  * 功能描述: 内置工作表业务逻辑实现
  * 创建记录: 2012/07/25
  * 修改记录: 
  */
public class InternalauditJobBLImpl extends BaseBLImpl implements
		InternalauditJobBL {

	/** 内置工作表DAO接口 */
	protected InternalauditJobDAO internalauditJobDAO;
	
	/**
	 * 内置工作表DAO接口设定
	 *
	 * @param internalauditJobDAO 内置工作表DAO接口
	 */
	public void setInternalauditJobDAO(InternalauditJobDAO internalauditJobDAO) {
		this.internalauditJobDAO = internalauditJobDAO;
	}

	/**
	 * 内置工作表实例取得
	 *
	 * @return 内置工作表实例
	 */
	public InternalauditJobTB getInternalauditJobTBInstance() {
		return new InternalauditJobTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InternalauditJobInfo> searchInternalauditJob() {
		return internalauditJobDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InternalauditJobInfo searchInternalauditJobByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(InternalauditJobSearchCond cond) {
		return internalauditJobDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond) {
		return internalauditJobDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond, int start,
			int count) {
		return internalauditJobDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public InternalauditJobInfo registInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		return internalauditJobDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public InternalauditJobInfo updateInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		checkExistInstance(instance.getIajid());
		return internalauditJobDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteInternalauditJobByPK(Integer pk)
		throws BLException {
		internalauditJobDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		internalauditJobDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public InternalauditJobInfo checkExistInstance(Integer pk)
		throws BLException {
		InternalauditJobInfo instance = internalauditJobDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}