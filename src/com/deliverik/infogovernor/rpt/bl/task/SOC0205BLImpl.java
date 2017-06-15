/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0205DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;

/**
  * 概述: 报告管理表业务逻辑实现
  * 功能描述: 报告管理表业务逻辑实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportManageBLImpl表名修改为SOC0205BLImpl
  */
public class SOC0205BLImpl extends BaseBLImpl implements
		SOC0205BL {

	/** 报告管理表DAO接口 */
	protected SOC0205DAO soc0205DAO;
	
	/**
	 * 报告管理表DAO接口设定
	 *
	 * @param soc0205DAO 报告管理表DAO接口
	 */
	public void setSoc0205DAO(SOC0205DAO soc0205DAO) {
		this.soc0205DAO = soc0205DAO;
	}

	/**
	 * 报告管理表实例取得
	 *
	 * @return 报告管理表实例
	 */
	public SOC0205TB getSOC0205Instance() {
		return new SOC0205TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0205Info> searchSOC0205() {
		return soc0205DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0205Info searchSOC0205ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0205SearchCond cond) {
		return soc0205DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond) {
		return soc0205DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond, int start,
			int count) {
		return soc0205DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0205Info registSOC0205(SOC0205Info instance)
		throws BLException {
		return soc0205DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0205Info updateSOC0205(SOC0205Info instance)
		throws BLException {
		checkExistInstance(instance.getRmId());
		return soc0205DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0205ByPK(Integer pk)
		throws BLException {
		soc0205DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0205(SOC0205Info instance)
		throws BLException {
		soc0205DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0205Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0205Info instance = soc0205DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}