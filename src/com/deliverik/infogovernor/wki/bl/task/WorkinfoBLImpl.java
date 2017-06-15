/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.dao.WorkinfoDAO;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * 概述: 工作信息业务逻辑实现
  * 功能描述: 工作信息业务逻辑实现
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public class WorkinfoBLImpl extends BaseBLImpl implements
		WorkinfoBL {

	/** 工作信息DAO接口 */
	protected WorkinfoDAO workinfoDAO;
	
	/**
	 * 工作信息DAO接口设定
	 *
	 * @param workinfoDAO 工作信息DAO接口
	 */
	public void setWorkinfoDAO(WorkinfoDAO workinfoDAO) {
		this.workinfoDAO = workinfoDAO;
	}

	/**
	 * 工作信息实例取得
	 *
	 * @return 工作信息实例
	 */
	public WorkinfoTB getWorkinfoTBInstance() {
		return new WorkinfoTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkinfoInfo> searchWorkinfo() {
		return workinfoDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkinfoInfo searchWorkinfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkinfoSearchCond cond) {
		return workinfoDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond) {
		return workinfoDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond, int start,
			int count) {
		return workinfoDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkinfoInfo registWorkinfo(WorkinfoInfo instance)
		throws BLException {
		return workinfoDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkinfoInfo updateWorkinfo(WorkinfoInfo instance)
		throws BLException {
		checkExistInstance(instance.getWorkinfoid());
		return workinfoDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkinfoByPK(Integer pk)
		throws BLException {
		workinfoDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkinfo(WorkinfoInfo instance)
		throws BLException {
		workinfoDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public WorkinfoInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkinfoInfo instance = workinfoDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}