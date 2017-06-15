/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0434DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0434TB;

/**
  * 概述: PVVIO业务逻辑实现
  * 功能描述: PVVIO业务逻辑实现
  * 创建记录: 2012/08/20
  * 修改记录: 
  */
public class SOC0434BLImpl extends BaseBLImpl implements
		SOC0434BL {

	/** PVVIODAO接口 */
	protected SOC0434DAO soc0434DAO;
	
	
	/**
	 * PVVIO实例取得
	 *
	 * @return PVVIO实例
	 */
	public SOC0434TB getPVVIOTBInstance() {
		return new SOC0434TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0434Info> searchPVVIO() {
		return soc0434DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0434Info searchPVVIOByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0434SearchCond cond) {
		return soc0434DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0434Info> searchPVVIO(
			SOC0434SearchCond cond) {
		return soc0434DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0434Info> searchPVVIO(
			SOC0434SearchCond cond, int start,
			int count) {
		return soc0434DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0434Info registPVVIO(SOC0434Info instance)
		throws BLException {
		return soc0434DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0434Info updatePVVIO(SOC0434Info instance)
		throws BLException {
		checkExistInstance(instance.getPVVID());
		return soc0434DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePVVIOByPK(Integer pk)
		throws BLException {
		soc0434DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePVVIO(SOC0434Info instance)
		throws BLException {
		soc0434DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0434Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0434Info instance = soc0434DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * PVVIODAO接口设定
	 *
	 * @param soc0434DAO PVVIODAO接口
	 */
	public void setSoc0434DAO(SOC0434DAO soc0434DAO) {
		this.soc0434DAO = soc0434DAO;
	}



}