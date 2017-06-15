/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainrecordDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * 概述: 培训记录业务逻辑接口
  * 功能描述: 培训记录业务逻辑接口
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public interface TrainrecordBL extends BaseBL {

	
	public TrainrecordDAO getTrainrecordDAOInstance();
	/**
	 * 培训记录实例取得
	 *
	 * @return 培训记录实例
	 */
	public TrainrecordTB getTrainrecordTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainrecordInfo> searchTrainrecord();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainrecordInfo searchTrainrecordByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainrecordSearchCond cond);

	
		
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainrecordInfo registTrainrecord(TrainrecordInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainrecordInfo updateTrainrecord(TrainrecordInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainrecordByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainrecord(TrainrecordInfo instance)
		throws BLException;

}