/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainmissionDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * 概述: 培训任务表业务逻辑实现
  * 功能描述: 培训任务表业务逻辑实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public class TrainmissionBLImpl extends BaseBLImpl implements
		TrainmissionBL {

	/** 培训任务表DAO接口 */
	protected TrainmissionDAO trainmissionDAO;
	
	/**
	 * 培训任务表DAO接口设定
	 *
	 * @param trainmissionDAO 培训任务表DAO接口
	 */
	public void setTrainmissionDAO(TrainmissionDAO trainmissionDAO) {
		this.trainmissionDAO = trainmissionDAO;
	}

	/**
	 * 培训任务表实例取得
	 *
	 * @return 培训任务表实例
	 */
	public TrainmissionTB getTrainmissionTBInstance() {
		return new TrainmissionTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainmissionInfo> searchTrainmission() {
		return trainmissionDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainmissionInfo searchTrainmissionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TrainmissionSearchCond cond) {
		return trainmissionDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond) {
		return trainmissionDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return trainmissionDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TrainmissionInfo registTrainmission(TrainmissionInfo instance)
		throws BLException {
		return trainmissionDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TrainmissionInfo updateTrainmission(TrainmissionInfo instance)
		throws BLException {
		checkExistInstance(instance.getTmid());
		return trainmissionDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTrainmissionByPK(Integer pk)
		throws BLException {
		trainmissionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTrainmission(TrainmissionInfo instance)
		throws BLException {
		trainmissionDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public TrainmissionInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainmissionInfo instance = trainmissionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 根据主表主键查询
	 * @param tpid String
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getListByRid (String tpid) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("tpid", tpid);
		return this.trainmissionDAO.getList(new String[]{"TrainmissionDetail.View"}, paramMap);
	} // end method getListByRid 
}