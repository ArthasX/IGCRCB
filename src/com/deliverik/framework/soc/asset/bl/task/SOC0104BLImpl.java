/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0104DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;

/**
  * 概述: 审计任务表业务逻辑实现
  * 功能描述: 审计任务表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0104BLImpl extends BaseBLImpl implements
		SOC0104BL {

	/** 审计任务表DAO接口 */
	protected SOC0104DAO soc0104DAO;
	
	/**
	 * 审计任务表DAO接口设定
	 *
	 * @param soc0104DAO 审计任务表DAO接口
	 */
	public void setsoc0104DAO(SOC0104DAO soc0104DAO) {
		this.soc0104DAO = soc0104DAO;
	}

	/**
	 * 审计任务表实例取得
	 *
	 * @return 审计任务表实例
	 */
	public SOC0104TB getSOC0104Instance() {
		return new SOC0104TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0104Info> searchSOC0104() {
		return soc0104DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0104Info searchSOC0104ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0104SearchCond cond) {
		return soc0104DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0104Info> searchSOC0104(
			SOC0104SearchCond cond) {
		return soc0104DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0104Info> searchSOC0104(
			SOC0104SearchCond cond, int start,
			int count) {
		return soc0104DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0104Info registSOC0104(SOC0104Info instance)
		throws BLException {
		return soc0104DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0104Info updateSOC0104(SOC0104Info instance)
		throws BLException {
		checkExistInstance(instance.getAutid());
		return soc0104DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0104ByPK(Integer pk)
		throws BLException {
		soc0104DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0104(SOC0104Info instance)
		throws BLException {
		soc0104DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0104Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0104Info instance = soc0104DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}