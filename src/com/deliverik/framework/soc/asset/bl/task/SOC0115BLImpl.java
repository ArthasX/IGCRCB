/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0115DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;

/**
  * 概述: 待处理任务业务逻辑实现
  * 功能描述: 待处理任务业务逻辑实现
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public class SOC0115BLImpl extends BaseBLImpl implements
		SOC0115BL {

	/** 待处理任务DAO接口 */
	protected SOC0115DAO soc0115DAO;
	


	/**
	 * 待处理任务DAO接口设定
	 *
	 * @param soc0115DAO 待处理任务DAO接口
	 */
	public void setSoc0115DAO(SOC0115DAO soc0115DAO) {
		this.soc0115DAO = soc0115DAO;
	}

	/**
	 * 待处理任务实例取得
	 *
	 * @return 待处理任务实例
	 */
	public SOC0115TB getEiWaitTaskTBInstance() {
		return new SOC0115TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0115Info> searchEiWaitTask() {
		return soc0115DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0115Info searchEiWaitTaskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0115SearchCond cond) {
		return soc0115DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond) {
		return soc0115DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0115Info> searchEiWaitTask(
			SOC0115SearchCond cond, int start,
			int count) {
		return soc0115DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0115Info registEiWaitTask(SOC0115Info instance)
		throws BLException {
		return soc0115DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0115Info updateEiWaitTask(SOC0115Info instance)
		throws BLException {
		checkExistInstance(instance.getEitid());
		return soc0115DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException {
		soc0115DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiWaitTask(SOC0115Info instance)
		throws BLException {
		soc0115DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0115Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0115Info instance = soc0115DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}