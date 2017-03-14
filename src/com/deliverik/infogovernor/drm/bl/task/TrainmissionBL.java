/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * 概述: 培训任务表业务逻辑接口
  * 功能描述: 培训任务表业务逻辑接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainmissionBL extends BaseBL {

	/**
	 * 培训任务表实例取得
	 *
	 * @return 培训任务表实例
	 */
	public TrainmissionTB getTrainmissionTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainmissionInfo> searchTrainmission();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainmissionInfo searchTrainmissionByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainmissionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainmissionInfo registTrainmission(TrainmissionInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainmissionInfo updateTrainmission(TrainmissionInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainmissionByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainmission(TrainmissionInfo instance)
		throws BLException;
	/**
	 * 根据主表主键查询
	 * @param tpid String
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getListByRid (String tpid);

}