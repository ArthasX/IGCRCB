/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0304DAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * 概述: 监控任务主表业务逻辑实现
  * 功能描述: 监控任务主表业务逻辑实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public class SOC0304BLImpl extends BaseBLImpl implements
		SOC0304BL {

	/** 监控任务主表DAO接口 */
	protected SOC0304DAO soc0304DAO;
	
	/**
	 * 监控任务主表DAO接口设定
	 *
	 * @param soc0304DAO 监控任务主表DAO接口
	 */
	public void setSoc0304DAO(SOC0304DAO soc0304DAO) {
		this.soc0304DAO = soc0304DAO;
	}

	/**
	 * 监控任务主表实例取得
	 *
	 * @return 监控任务主表实例
	 */
	public SOC0304TB getSoc0304Instance() {
		return new SOC0304TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0304Info> searchSoc0304() {
		return soc0304DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0304Info searchSoc0304ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0304SearchCond cond) {
		return soc0304DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond) {
		return soc0304DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond, int start,
			int count) {
		return soc0304DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0304Info registSoc0304(SOC0304Info instance)
		throws BLException {
		return soc0304DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0304Info updateSoc0304(SOC0304Info instance)
		throws BLException {
		checkExistInstance(instance.getMtId());
		return soc0304DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSoc0304ByPK(Integer pk)
		throws BLException {
		soc0304DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSoc0304(SOC0304Info instance)
		throws BLException {
		soc0304DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0304Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0304Info instance = soc0304DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}