/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0204DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * 概述: 报表自定链接业务逻辑实现
  * 功能描述: 报表自定链接业务逻辑实现
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/10 将ReportCustomLinkBLImpl表名修改为SOC0204BLImpl
  */
public class SOC0204BLImpl extends BaseBLImpl implements
		SOC0204BL {

	/** 报表自定链接DAO接口 */
	protected SOC0204DAO soc0204DAO;
	
	/**
	 * 报表自定链接DAO接口设定
	 *
	 * @param soc0204DAO 报表自定链接DAO接口
	 */
	public void setSoc0204DAO(SOC0204DAO soc0204DAO) {
		this.soc0204DAO = soc0204DAO;
	}

	/**
	 * 报表自定链接实例取得
	 *
	 * @return 报表自定链接实例
	 */
	public SOC0204TB getSOC0204Instance() {
		return new SOC0204TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0204Info> searchSOC0204() {
		return soc0204DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0204Info searchSOC0204ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0204SearchCond cond) {
		return soc0204DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond) {
		return soc0204DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond, int start,
			int count) {
		return soc0204DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0204Info registSOC0204(SOC0204Info instance)
		throws BLException {
		return soc0204DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0204Info updateSOC0204(SOC0204Info instance)
		throws BLException {
		checkExistInstance(instance.getRclId());
		return soc0204DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0204ByPK(Integer pk)
		throws BLException {
		soc0204DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0204(SOC0204Info instance)
		throws BLException {
		soc0204DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0204Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0204Info instance = soc0204DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}