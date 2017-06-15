/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainparticipateDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;

/**
  * 概述: 培训参与人业务逻辑实现
  * 功能描述: 培训参与人业务逻辑实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainparticipateBLImpl extends BaseBLImpl implements
		TrainparticipateBL {

	/** 培训参与人DAO接口 */
	protected TrainparticipateDAO trainparticipateDAO;
	
	/**
	 * 培训参与人DAO接口设定
	 *
	 * @param trainparticipateDAO 培训参与人DAO接口
	 */
	public void setTrainparticipateDAO(TrainparticipateDAO trainparticipateDAO) {
		this.trainparticipateDAO = trainparticipateDAO;
	}

	/**
	 * 培训参与人实例取得
	 *
	 * @return 培训参与人实例
	 */
	public TrainparticipateTB getTrainparticipateTBInstance() {
		return new TrainparticipateTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainparticipateInfo> searchTrainparticipate() {
		return trainparticipateDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainparticipateInfo searchTrainparticipateByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainparticipateSearchCond cond) {
		return trainparticipateDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainparticipateInfo> searchTrainparticipate(
			TrainparticipateSearchCond cond) {
		return trainparticipateDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TrainparticipateInfo> searchTrainparticipate(
			TrainparticipateSearchCond cond, int start,
			int count) {
		return trainparticipateDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainparticipateInfo registTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		return trainparticipateDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainparticipateInfo updateTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		checkExistInstance(instance.getTpaid());
		return trainparticipateDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainparticipateByPK(Integer pk)
		throws BLException {
		trainparticipateDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		trainparticipateDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public TrainparticipateInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainparticipateInfo instance = trainparticipateDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}