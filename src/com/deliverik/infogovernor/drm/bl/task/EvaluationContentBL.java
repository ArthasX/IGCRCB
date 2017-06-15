/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;

/**
  * 概述: 项目周报人员工作量业务逻辑接口
  * 功能描述: 项目周报人员工作量业务逻辑接口
  * 创建记录: 2016/08/11
  * 修改记录: 
  */
public interface EvaluationContentBL extends BaseBL {

	/**
	 * 项目周报人员工作量实例取得
	 *
	 * @return 项目周报人员工作量实例
	 */
	public EvaluationContentTB getEvaluationContentTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EvaluationContentInfo> searchEvaluationContent();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EvaluationContentInfo searchEvaluationContentByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EvaluationContentSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EvaluationContentInfo registEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EvaluationContentInfo updateEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEvaluationContentByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	public List<EvaluationContentInfo> saveEvaluationContent(EvaluationContentTB evaluationContentTB)throws BLException;
}