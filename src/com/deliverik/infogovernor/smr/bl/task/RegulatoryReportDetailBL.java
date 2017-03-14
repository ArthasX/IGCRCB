/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * 概述: 报表填报明细表业务逻辑接口
  * 功能描述: 报表填报明细表业务逻辑接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportDetailBL extends BaseBL {

	/**
	 * 报表填报明细表实例取得
	 *
	 * @return 报表填报明细表实例
	 */
	public RegulatoryReportDetailTB getRegulatoryReportDetailTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportDetailInfo searchRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RegulatoryReportDetailSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RegulatoryReportDetailInfo registRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RegulatoryReportDetailInfo updateRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

}