/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RemindInfoDAO;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
  * 概述: 提醒信息表业务逻辑实现
  * 功能描述: 提醒信息表业务逻辑实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class RemindInfoBLImpl extends BaseBLImpl implements
		RemindInfoBL {

	/** 提醒信息表DAO接口 */
	protected RemindInfoDAO remindInfoDAO;
	
	/**
	 * 提醒信息表DAO接口设定
	 *
	 * @param remindInfoDAO 提醒信息表DAO接口
	 */
	public void setRemindInfoDAO(RemindInfoDAO remindInfoDAO) {
		this.remindInfoDAO = remindInfoDAO;
	}

	/**
	 * 提醒信息表实例取得
	 *
	 * @return 提醒信息表实例
	 */
	public RemindInfoTB getRemindInfoTBInstance() {
		return new RemindInfoTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindInfoInfo> searchRemindInfo() {
		return remindInfoDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindInfoInfo searchRemindInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RemindInfoSearchCond cond) {
		return remindInfoDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond) {
		return remindInfoDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond, int start,
			int count) {
		return remindInfoDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RemindInfoInfo registRemindInfo(RemindInfoInfo instance)
		throws BLException {
		return remindInfoDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RemindInfoInfo updateRemindInfo(RemindInfoInfo instance)
		throws BLException {
		checkExistInstance(instance.getRiid());
		return remindInfoDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRemindInfoByPK(Integer pk)
		throws BLException {
		remindInfoDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRemindInfo(RemindInfoInfo instance)
		throws BLException {
		remindInfoDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RemindInfoInfo checkExistInstance(Integer pk)
		throws BLException {
		RemindInfoInfo instance = remindInfoDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}