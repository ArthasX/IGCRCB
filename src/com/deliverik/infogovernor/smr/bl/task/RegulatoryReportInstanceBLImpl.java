/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.dao.RegulatoryReportInstanceDAO;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
  * 概述: 报表填报实例表业务逻辑实现
  * 功能描述: 报表填报实例表业务逻辑实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public class RegulatoryReportInstanceBLImpl extends BaseBLImpl implements
		RegulatoryReportInstanceBL {

	/** 报表填报实例表DAO接口 */
	protected RegulatoryReportInstanceDAO regulatoryReportInstanceDAO;
	
	/**
	 * 报表填报实例表DAO接口设定
	 *
	 * @param regulatoryReportInstanceDAO 报表填报实例表DAO接口
	 */
	public void setRegulatoryReportInstanceDAO(RegulatoryReportInstanceDAO regulatoryReportInstanceDAO) {
		this.regulatoryReportInstanceDAO = regulatoryReportInstanceDAO;
	}

	/**
	 * 报表填报实例表实例取得
	 *
	 * @return 报表填报实例表实例
	 */
	public RegulatoryReportInstanceTB getRegulatoryReportInstanceTBInstance() {
		return new RegulatoryReportInstanceTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo() {
		return regulatoryReportInstanceDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportInstanceInfo searchRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond, int start,
			int count) {
		return regulatoryReportInstanceDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RegulatoryReportInstanceInfo registRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		checkKey(instance.getKey(),instance.getPrtype());
		return regulatoryReportInstanceDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RegulatoryReportInstanceInfo updateRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		checkExistInstance(instance.getInstanceID());
		return regulatoryReportInstanceDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException {
		regulatoryReportInstanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		regulatoryReportInstanceDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RegulatoryReportInstanceInfo checkExistInstance(Integer pk)
		throws BLException {
		RegulatoryReportInstanceInfo instance = regulatoryReportInstanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param key 组标识
	 * @return 实例
	 */
	public void checkKey(String key,String type) throws BLException {
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setKey_eq(key);
		cond.setStatus_eq(IGSMRCONSTANT.REPORT_STATUS_BEGIN);
		List<RegulatoryReportInstanceInfo> lst_Instance = regulatoryReportInstanceDAO.findByCond(cond);
		if (lst_Instance.size() > 0) {
			String info = IGSMRCONSTANT.PRYTPE_REPORT.equals(type) ? key + "年" : key;
			throw new BLException("IGSMR0101.E001", info);
		}
	}

	public List<AnnualReportVWInfo> findAnnualReportByCond(
			RegulatoryReportInstanceSearchCond cond, int start, int count) {
		
		return regulatoryReportInstanceDAO.findAnnualReportByCond(cond, start, count);
	}

	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			RegulatoryReportInstanceSearchCond cond,int start, int count) {
	
		return regulatoryReportInstanceDAO.findSectionAnnualReportByCond(cond,start, count);
	}

	public List<BatchExamineVWInfo> findBatchExanmie(
			RegulatoryReportInstanceSearchCond cond) {
		
		return regulatoryReportInstanceDAO.findBatchExanmie(cond);
	}

	public List<ReportHistorySearchVWInfo> findReportHistory(
			RegulatoryReportInstanceSearchCond cond, int start, int count) {
		
		return regulatoryReportInstanceDAO.findReportHistory(cond, start, count);
	}

	public int findReportHistoryCount(RegulatoryReportInstanceSearchCond cond) {
		
		return regulatoryReportInstanceDAO.findReportHistoryCount(cond);
	}
	
	/**
	 * 删除无效填报实例
	 * 当流程均停用后，报表流程会被删除
	 * 但实例还在且无效
	 */
	public void deleteTestInstance() throws BLException {
		this.regulatoryReportInstanceDAO.deleteTestInstance();
	}

	public List<AnnualReportVWInfo> lookatFillIn(
			RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.lookatFillIn(cond);
	}

}