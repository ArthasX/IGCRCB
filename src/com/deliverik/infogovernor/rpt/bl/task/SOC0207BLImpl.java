/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0207DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * 概述: 报告模板业务逻辑实现
  * 功能描述: 报告模板业务逻辑实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateBLImpl表名修改为SOC0207BLImpl
  */
public class SOC0207BLImpl extends BaseBLImpl implements
		SOC0207BL {

	/** 报告模板DAO接口 */
	protected SOC0207DAO soc0207DAO;
	
	/**
	 * 报告模板DAO接口设定
	 *
	 * @param soc0207DAO 报告模板DAO接口
	 */
	public void setSoc0207DAO(SOC0207DAO soc0207DAO) {
		this.soc0207DAO = soc0207DAO;
	}

	/**
	 * 报告模板实例取得
	 *
	 * @return 报告模板实例
	 */
	public SOC0207TB getSOC0207Instance() {
		return new SOC0207TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0207Info> searchSOC0207() {
		return soc0207DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0207Info searchSOC0207ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0207SearchCond cond) {
		return soc0207DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond) {
		return soc0207DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond, int start,
			int count) {
		return soc0207DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0207Info registSOC0207(SOC0207Info instance)
		throws BLException {
		return soc0207DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0207Info updateSOC0207(SOC0207Info instance)
		throws BLException {
		checkExistInstance(instance.getRtId());
		return soc0207DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0207ByPK(Integer pk)
		throws BLException {
		soc0207DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0207(SOC0207Info instance)
		throws BLException {
		soc0207DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0207Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0207Info instance = soc0207DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}