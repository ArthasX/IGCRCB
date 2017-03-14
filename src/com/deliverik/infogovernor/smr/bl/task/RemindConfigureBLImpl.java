/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RemindConfigureDAO;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * 概述: 提醒配置表业务逻辑实现
  * 功能描述: 提醒配置表业务逻辑实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class RemindConfigureBLImpl extends BaseBLImpl implements
		RemindConfigureBL {

	/** 提醒配置表DAO接口 */
	protected RemindConfigureDAO remindConfigureDAO;
	
	/**
	 * 提醒配置表DAO接口设定
	 *
	 * @param remindConfigureDAO 提醒配置表DAO接口
	 */
	public void setRemindConfigureDAO(RemindConfigureDAO remindConfigureDAO) {
		this.remindConfigureDAO = remindConfigureDAO;
	}

	/**
	 * 提醒配置表实例取得
	 *
	 * @return 提醒配置表实例
	 */
	public RemindConfigureTB getRemindConfigureTBInstance() {
		return new RemindConfigureTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindConfigureInfo> searchRemindConfigure() {
		return remindConfigureDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindConfigureInfo searchRemindConfigureByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RemindConfigureSearchCond cond) {
		return remindConfigureDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond) {
		return remindConfigureDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond, int start,
			int count) {
		return remindConfigureDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RemindConfigureInfo registRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		return remindConfigureDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RemindConfigureInfo updateRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		checkExistInstance(instance.getRcid());
		return remindConfigureDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRemindConfigureByPK(Integer pk)
		throws BLException {
		remindConfigureDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRemindConfigure(RemindConfigureInfo instance)
		throws BLException {
		remindConfigureDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RemindConfigureInfo checkExistInstance(Integer pk)
		throws BLException {
		RemindConfigureInfo instance = remindConfigureDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}