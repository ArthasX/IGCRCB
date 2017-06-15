/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * 概述: 培训计划表业务逻辑接口
  * 功能描述: 培训计划表业务逻辑接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainplanBL extends BaseBL {

	/**
	 * 培训计划表实例取得
	 *
	 * @return 培训计划表实例
	 */
	public TrainplanTB getTrainplanTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainplanInfo> searchTrainplan();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainplanInfo searchTrainplanByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainplanSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainplanInfo registTrainplan(TrainplanInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainplanInfo updateTrainplan(TrainplanInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainplanByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainplan(TrainplanInfo instance)
		throws BLException;

}