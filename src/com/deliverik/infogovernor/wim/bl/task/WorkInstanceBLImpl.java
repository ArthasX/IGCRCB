/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkInstanceDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * 概述: workInstance业务逻辑实现
  * 功能描述: workInstance业务逻辑实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkInstanceBLImpl extends BaseBLImpl implements
		WorkInstanceBL {

	/** workInstanceDAO接口 */
	protected WorkInstanceDAO workInstanceDAO;
	
	/**
	 * workInstanceDAO接口设定
	 *
	 * @param workInstanceDAO workInstanceDAO接口
	 */
	public void setWorkInstanceDAO(WorkInstanceDAO workInstanceDAO) {
		this.workInstanceDAO = workInstanceDAO;
	}

	/**
	 * workInstance实例取得
	 *
	 * @return workInstance实例
	 */
	public WorkInstanceTB getWorkInstanceTBInstance() {
		return new WorkInstanceTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkInstanceInfo> searchWorkInstance() {
		return workInstanceDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkInstanceInfo searchWorkInstanceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkInstanceSearchCond cond) {
		return workInstanceDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond) {
		return workInstanceDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond, int start,
			int count) {
		return workInstanceDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkInstanceInfo registWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		return workInstanceDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkInstanceInfo updateWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		checkExistInstance(instance.getWiid());
		return workInstanceDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkInstanceByPK(Integer pk)
		throws BLException {
		workInstanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		workInstanceDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public WorkInstanceInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkInstanceInfo instance = workInstanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}