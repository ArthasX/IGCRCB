/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RegulatoryReportDetailDAO;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * 概述: 报表填报明细表业务逻辑实现
  * 功能描述: 报表填报明细表业务逻辑实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public class RegulatoryReportDetailBLImpl extends BaseBLImpl implements
		RegulatoryReportDetailBL {

	/** 报表填报明细表DAO接口 */
	protected RegulatoryReportDetailDAO regulatoryReportDetailDAO;
	
	/**
	 * 报表填报明细表DAO接口设定
	 *
	 * @param regulatoryReportDetailDAO 报表填报明细表DAO接口
	 */
	public void setRegulatoryReportDetailDAO(RegulatoryReportDetailDAO regulatoryReportDetailDAO) {
		this.regulatoryReportDetailDAO = regulatoryReportDetailDAO;
	}

	/**
	 * 报表填报明细表实例取得
	 *
	 * @return 报表填报明细表实例
	 */
	public RegulatoryReportDetailTB getRegulatoryReportDetailTBInstance() {
		return new RegulatoryReportDetailTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo() {
		return regulatoryReportDetailDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportDetailInfo searchRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RegulatoryReportDetailSearchCond cond) {
		return regulatoryReportDetailDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond) {
		return regulatoryReportDetailDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond, int start,
			int count) {
		return regulatoryReportDetailDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RegulatoryReportDetailInfo registRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		return regulatoryReportDetailDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RegulatoryReportDetailInfo updateRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		checkExistInstance(instance.getDetailID());
		return regulatoryReportDetailDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException {
		regulatoryReportDetailDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		regulatoryReportDetailDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RegulatoryReportDetailInfo checkExistInstance(Integer pk)
		throws BLException {
		RegulatoryReportDetailInfo instance = regulatoryReportDetailDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}