/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * 概述: 评分历史查询业务逻辑接口
  * 功能描述: 评分历史查询业务逻辑接口
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public interface AssessmentScoreVWBL extends BaseBL {

	/**
	 * 评分历史查询实例取得
	 *
	 * @return 评分历史查询实例
	 */
	public AssessmentScoreVW getAssessmentScoreTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AssessmentScoreVWInfo searchAssessmentScoreByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AssessmentScoreVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AssessmentScoreVWInfo registAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AssessmentScoreVWInfo updateAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAssessmentScoreByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;
	/**
	 * 年度评估报表检索处理
	 * @return 评估年度报表
	 */
	public List<Object[]> getAssessmentYearReport(final AssessmentScoreVWSearchCond cond);
	
	/**
	 * 部门评估报表检索处理
	 * @return 评估部门报表
	 */
	public List<Object[]> getAssessmentOrgReport(final AssessmentScoreVWSearchCond cond);

}