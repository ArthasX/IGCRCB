/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainplanDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * 概述: 培训计划表业务逻辑实现
  * 功能描述: 培训计划表业务逻辑实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public class TrainplanBLImpl extends BaseBLImpl implements
		TrainplanBL {

	/** 培训计划表DAO接口 */
	protected TrainplanDAO trainplanDAO;
	
	/**
	 * 培训计划表DAO接口设定
	 *
	 * @param trainplanDAO 培训计划表DAO接口
	 */
	public void setTrainplanDAO(TrainplanDAO trainplanDAO) {
		this.trainplanDAO = trainplanDAO;
	}

	/**
	 * 培训计划表实例取得
	 *
	 * @return 培训计划表实例
	 */
	public TrainplanTB getTrainplanTBInstance() {
		return new TrainplanTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainplanInfo> searchTrainplan() {
		return trainplanDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainplanInfo searchTrainplanByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainplanSearchCond cond) {
		return trainplanDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond) {
		return trainplanDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return trainplanDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainplanInfo registTrainplan(TrainplanInfo instance)
		throws BLException {
		return trainplanDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainplanInfo updateTrainplan(TrainplanInfo instance)
		throws BLException {
		checkExistInstance(instance.getTpid());
		return trainplanDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainplanByPK(Integer pk)
		throws BLException {
		trainplanDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainplan(TrainplanInfo instance)
		throws BLException {
		trainplanDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public TrainplanInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainplanInfo instance = trainplanDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}