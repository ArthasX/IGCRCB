/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0152DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * 概述: 资产关系表业务逻辑实现
  * 功能描述: 资产关系表业务逻辑实现
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
public class SOC0152BLImpl extends BaseBLImpl implements
		SOC0152BL {

	/** 资产关系表DAO接口 */
	protected SOC0152DAO soc0152DAO;
	
	/**
	 * 资产关系表DAO接口设定
	 *
	 * @param soc0152DAO 资产关系表DAO接口
	 */
	public void setSoc0152DAO(SOC0152DAO soc0152DAO) {
		this.soc0152DAO = soc0152DAO;
	}

	/**
	 * 资产关系表实例取得
	 *
	 * @return 资产关系表实例
	 */
	public SOC0152TB getSOC0152TBInstance() {
		return new SOC0152TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0152Info> searchSOC0152() {
		return soc0152DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0152Info searchSOC0152ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0152SearchCond cond) {
		return soc0152DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond) {
		return soc0152DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond, int start,
			int count) {
		return soc0152DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0152Info registSOC0152(SOC0152Info instance)
		throws BLException {
		return soc0152DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0152Info updateSOC0152(SOC0152Info instance)
		throws BLException {
		checkExistInstance(instance.getRlnCode());
		return soc0152DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0152ByPK(String pk)
		throws BLException {
		soc0152DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0152(SOC0152Info instance)
		throws BLException {
		soc0152DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0152Info checkExistInstance(String pk)
		throws BLException {
		SOC0152Info instance = soc0152DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}