/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0102DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0102TB;

/**
  * 概述: 审计资产表业务逻辑实现
  * 功能描述: 审计资产表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0102BLImpl extends BaseBLImpl implements
		SOC0102BL {

	/** 审计资产表DAO接口 */
	protected SOC0102DAO soc0102DAO;
	
	/**
	 * 审计资产表DAO接口设定
	 *
	 * @param SOC0102DAO 审计资产表DAO接口
	 */
	public void setSoc0102DAO(SOC0102DAO soc0102DAO) {
		this.soc0102DAO = soc0102DAO;
	}

	/**
	 * 审计资产表实例取得
	 *
	 * @return 审计资产表实例
	 */
	public SOC0102TB getSOC0102Instance() {
		return new SOC0102TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0102Info> searchSOC0102() {
		return soc0102DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0102Info searchSOC0102ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0102SearchCond cond) {
		return soc0102DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond) {
		return soc0102DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond, int start,
			int count) {
		return soc0102DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0102Info registSOC0102(SOC0102Info instance)
		throws BLException {
		return soc0102DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0102Info updateSOC0102(SOC0102Info instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return soc0102DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0102ByPK(Integer pk)
		throws BLException {
		soc0102DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0102(SOC0102Info instance)
		throws BLException {
		soc0102DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0102Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0102Info instance = soc0102DAO.findByPK(pk);
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
	public Integer deleteSOC0102(){
		return soc0102DAO.deleteSOC0102();
	}


}