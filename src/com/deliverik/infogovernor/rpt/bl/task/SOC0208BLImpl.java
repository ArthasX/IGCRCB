/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0208DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208PK;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;

/**
  * 概述: 事件变更服务效率业务逻辑实现
  * 功能描述: 事件变更服务效率业务逻辑实现
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/10 将ServeEfficiencyBLImpl表名修改为SOC0208BLImpl
  */
public class SOC0208BLImpl extends BaseBLImpl implements
		SOC0208BL {

	/** 事件变更服务效率DAO接口 */
	protected SOC0208DAO soc0208DAO;
	
	/**
	 * 事件变更服务效率DAO接口设定
	 *
	 * @param soc0208DAO 事件变更服务效率DAO接口
	 */
	public void setSoc0208DAO(SOC0208DAO soc0208DAO) {
		this.soc0208DAO = soc0208DAO;
	}

	/**
	 * 事件变更服务效率实例取得
	 *
	 * @return 事件变更服务效率实例
	 */
	public SOC0208TB getSOC0208Instance() {
		return new SOC0208TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0208Info> searchSOC0208() {
		return soc0208DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0208Info searchSOC0208ByPK(SOC0208PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0208SearchCond cond) {
		return soc0208DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond) {
		return soc0208DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond, int start,
			int count) {
		return soc0208DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0208Info registSOC0208(SOC0208Info instance)
		throws BLException {
		return soc0208DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0208Info updateSOC0208(SOC0208Info instance)
		throws BLException {
		checkExistInstance(new SOC0208PK(instance.getPrtype(), instance.getPivaralue(), instance.getEfficiencyTime()));
		return soc0208DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0208ByPK(SOC0208PK pk)
		throws BLException {
		soc0208DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0208(SOC0208Info instance)
		throws BLException {
		soc0208DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0208Info checkExistInstance(SOC0208PK pk)
		throws BLException {
		SOC0208Info instance = soc0208DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}