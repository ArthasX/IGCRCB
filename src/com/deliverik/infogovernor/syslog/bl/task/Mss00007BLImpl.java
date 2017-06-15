/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00007SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00007DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00007TB;

/**
  * 概述: 告警信息历史表业务逻辑实现
  * 功能描述: 告警信息历史表业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00007BLImpl extends BaseBLImpl implements
		Mss00007BL {

	/** 告警信息历史表DAO接口 */
	protected Mss00007DAO mss00007DAO;
	
	/**
	 * 告警信息历史表DAO接口设定
	 *
	 * @param mss00007DAO 告警信息历史表DAO接口
	 */
	public void setMss00007DAO(Mss00007DAO mss00007DAO) {
		this.mss00007DAO = mss00007DAO;
	}

	/**
	 * 告警信息历史表实例取得
	 *
	 * @return 告警信息历史表实例
	 */
	public Mss00007TB getMss00007TBInstance() {
		return new Mss00007TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00007Info> searchMss00007() {
		return mss00007DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00007Info searchMss00007ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws Exception 
	 */
	public int getSearchCount(Mss00007SearchCond cond) throws Exception {
		return mss00007DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond) throws Exception {
		return mss00007DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws Exception 
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond, int start,
			int count) throws Exception {
		return mss00007DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00007Info registMss00007(Mss00007Info instance)
		throws BLException {
		return mss00007DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00007Info updateMss00007(Mss00007Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return mss00007DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00007ByPK(Integer pk)
		throws BLException {
		mss00007DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00007(Mss00007Info instance)
		throws BLException {
		mss00007DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00007Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00007Info instance = mss00007DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}