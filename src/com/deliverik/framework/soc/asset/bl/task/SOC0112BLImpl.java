/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0112DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;

/**
  * 概述: 资产域明细表业务逻辑实现
  * 功能描述: 资产域明细表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0112BLImpl extends BaseBLImpl implements
		SOC0112BL {

	/** 资产域明细表DAO接口 */
	protected SOC0112DAO soc0112DAO;
	


	/**
	 * 资产域明细表DAO接口设定
	 *
	 * @param soc0112DAO 资产域明细表DAO接口
	 */
	public void setSoc0112DAO(SOC0112DAO soc0112DAO) {
		this.soc0112DAO = soc0112DAO;
	}

	/**
	 * 资产域明细表实例取得
	 *
	 * @return 资产域明细表实例
	 */
	public SOC0112TB getEiDomainDetailTBInstance() {
		return new SOC0112TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0112Info> searchEiDomainDetail() {
		return soc0112DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0112Info searchEiDomainDetailByPK(SOC0112PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0112SearchCond cond) {
		return soc0112DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond) {
		return soc0112DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond, int start,
			int count) {
		return soc0112DAO.findBySQL(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0112Info registEiDomainDetail(SOC0112Info instance)
		throws BLException {
		return soc0112DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0112Info updateEiDomainDetail(SOC0112Info instance)
		throws BLException {
		checkExistInstance(new SOC0112PK(instance.getEiddid(), instance.getEiddversion(), instance.getEiname(),instance.getEiImportversion()));
		return soc0112DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiDomainDetailByPK(SOC0112PK pk)
		throws BLException {
		soc0112DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiDomainDetail(SOC0112Info instance)
		throws BLException {
		soc0112DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0112Info checkExistInstance(SOC0112PK pk)
		throws BLException {
		SOC0112Info instance = soc0112DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}