/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.asset.model.dao.EiWaitTaskDAO;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;

/**
  * 概述: 待处理任务业务逻辑实现
  * 功能描述: 待处理任务业务逻辑实现
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public class EiWaitTaskBLImpl extends BaseBLImpl implements
		EiWaitTaskBL {

	/** 待处理任务DAO接口 */
	protected EiWaitTaskDAO eiWaitTaskDAO;
	
	/**
	 * 待处理任务DAO接口设定
	 *
	 * @param eiWaitTaskDAO待处理任务DAO接口
	 */
	public void setEiWaitTaskDAO(EiWaitTaskDAO eiWaitTaskDAO) {
		this.eiWaitTaskDAO = eiWaitTaskDAO;
	}

	/**
	 * 待处理任务实例取得
	 *
	 * @return 待处理任务实例
	 */
	public EiWaitTaskTB getEiWaitTaskTBInstance() {
		return new EiWaitTaskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask() {
		return eiWaitTaskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public EiWaitTaskInfo searchEiWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiWaitTaskSearchCond cond) {
		return eiWaitTaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond) {
		return eiWaitTaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond, int start,
			int count) {
		return eiWaitTaskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiWaitTaskInfo registEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		return eiWaitTaskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public EiWaitTaskInfo updateEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		checkExistInstance(instance.getEitid());
		return eiWaitTaskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException {
		eiWaitTaskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiWaitTask(EiWaitTaskInfo instance)
		throws BLException {
		eiWaitTaskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public EiWaitTaskInfo checkExistInstance(Integer pk)
		throws BLException {
		EiWaitTaskInfo instance = eiWaitTaskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}