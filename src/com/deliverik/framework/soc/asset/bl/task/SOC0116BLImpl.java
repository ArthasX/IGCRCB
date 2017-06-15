/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0116DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * 概述: EiWaitTaskTemp业务逻辑实现
  * 功能描述: EiWaitTaskTemp业务逻辑实现
  * 创建记录: 2012/07/30
  * 修改记录: 
  */
public class SOC0116BLImpl extends BaseBLImpl implements
		SOC0116BL {

	/** EiWaitTaskTempDAO接口 */
	protected SOC0116DAO soc0116DAO;
	


	/**
	 * EiWaitTaskTempDAO接口设定
	 *
	 * @param soc0116DAO EiWaitTaskTempDAO接口
	 */
	public void setSoc0116DAO(SOC0116DAO soc0116DAO) {
		this.soc0116DAO = soc0116DAO;
	}

	/**
	 * EiWaitTaskTemp实例取得
	 *
	 * @return EiWaitTaskTemp实例
	 */
	public SOC0116TB getEiWaitTaskTempTBInstance() {
		return new SOC0116TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp() {
		return soc0116DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0116Info searchEiWaitTaskTempByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0116SearchCond cond) {
		return soc0116DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond) {
		return soc0116DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond, int start,
			int count) {
		return soc0116DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0116Info registEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		return soc0116DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0116Info updateEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		checkExistInstance(instance.getEwtId());
		return soc0116DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiWaitTaskTempByPK(Integer pk)
		throws BLException {
		soc0116DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		soc0116DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0116Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0116Info instance = soc0116DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "instance");
		}
		return instance;
	}

}