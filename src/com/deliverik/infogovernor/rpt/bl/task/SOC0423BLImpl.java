/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0423DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;

/**
  * 概述: 容量对象表业务逻辑实现
  * 功能描述: 容量对象表业务逻辑实现
  * 创建记录: 2012/07/17
  * 修改记录: 2012/08/09 将CapacityObjectListBLImpl表名改为SOC0423BLImpl
  */
public class SOC0423BLImpl extends BaseBLImpl implements
		SOC0423BL {

	/** 容量对象表DAO接口 */
	protected SOC0423DAO soc0423DAO;
	
	/**
	 * 容量对象表DAO接口设定
	 *
	 * @param soc0423DAO 容量对象表DAO接口
	 */
	public void setSoc0423DAO(SOC0423DAO soc0423DAO) {
		this.soc0423DAO = soc0423DAO;
	}

	/**
	 * 容量对象表实例取得
	 *
	 * @return 容量对象表实例
	 */
	public SOC0423TB getSOC0423Instance() {
		return new SOC0423TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0423Info> searchSOC0423() {
		return soc0423DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0423Info searchSOC0423ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0423SearchCond cond) {
		return soc0423DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond) {
		return soc0423DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond, int start,
			int count) {
		return soc0423DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0423Info registSOC0423(SOC0423Info instance)
		throws BLException {
		return soc0423DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0423Info updateSOC0423(SOC0423Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0423DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0423ByPK(Integer pk)
		throws BLException {
		soc0423DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0423(SOC0423Info instance)
		throws BLException {
		soc0423DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0423Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0423Info instance = soc0423DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}