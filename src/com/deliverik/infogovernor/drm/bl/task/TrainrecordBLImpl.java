/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainrecordDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * 概述: 培训记录业务逻辑实现
  * 功能描述: 培训记录业务逻辑实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainrecordBLImpl extends BaseBLImpl implements
		TrainrecordBL {

	
	/** 培训记录DAO接口 */
	protected TrainrecordDAO trainrecordDAO;
	
	/**
	 * 培训记录DAO接口设定
	 *
	 * @param trainrecordDAO 培训记录DAO接口
	 */
	public void setTrainrecordDAO(TrainrecordDAO trainrecordDAO) {
		this.trainrecordDAO = trainrecordDAO;
	}

	/**
	 * 培训记录实例取得
	 *
	 * @return 培训记录实例
	 */
	public TrainrecordTB getTrainrecordTBInstance() {
		return new TrainrecordTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainrecordInfo> searchTrainrecord() {
		return trainrecordDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainrecordInfo searchTrainrecordByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainrecordSearchCond cond) {
		return trainrecordDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond) {
		return trainrecordDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return trainrecordDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainrecordInfo registTrainrecord(TrainrecordInfo instance)
		throws BLException {
		return trainrecordDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainrecordInfo updateTrainrecord(TrainrecordInfo instance)
		throws BLException {
		checkExistInstance(instance.getTrid());
		return trainrecordDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainrecordByPK(Integer pk)
		throws BLException {
		trainrecordDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainrecord(TrainrecordInfo instance)
		throws BLException {
		trainrecordDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public TrainrecordInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainrecordInfo instance = trainrecordDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public TrainrecordDAO getTrainrecordDAOInstance() {
		// TODO Auto-generated method stub
		return null;
	}


}