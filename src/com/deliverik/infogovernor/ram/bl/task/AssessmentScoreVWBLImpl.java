/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.dao.AssessmentScoreVWDAO;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * 概述: 评分历史查询业务逻辑实现
  * 功能描述: 评分历史查询业务逻辑实现
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public class AssessmentScoreVWBLImpl extends BaseBLImpl implements
		AssessmentScoreVWBL {

	/** 评分历史查询DAO接口 */
	protected AssessmentScoreVWDAO assessmentScoreVWDAO;
	
	/**
	 * 评分历史查询DAO接口设定
	 *
	 * @param assessmentScoreDAO 评分历史查询DAO接口
	 */
	public void setAssessmentScoreVWDAO(AssessmentScoreVWDAO assessmentScoreVWDAO) {
		this.assessmentScoreVWDAO = assessmentScoreVWDAO;
	}

	/**
	 * 评分历史查询实例取得
	 *
	 * @return 评分历史查询实例
	 */
	public AssessmentScoreVW getAssessmentScoreTBInstance() {
		return new AssessmentScoreVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore() {
		return assessmentScoreVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AssessmentScoreVWInfo searchAssessmentScoreByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return assessmentScoreVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AssessmentScoreVWInfo registAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		return assessmentScoreVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AssessmentScoreVWInfo updateAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getPpiid());
		return assessmentScoreVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAssessmentScoreByPK(Integer pk)
		throws BLException {
		assessmentScoreVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		assessmentScoreVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AssessmentScoreVWInfo checkExistInstance(Integer pk)
		throws BLException {
		AssessmentScoreVWInfo instance = assessmentScoreVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 部门报表条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Object[]> getAssessmentOrgReport(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.assessmentOrganizationReport(cond);
	}
	/**
	 * 年度报表条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Object[]> getAssessmentYearReport(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.assessmentYearReport(cond);
	}
}