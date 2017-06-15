/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00003DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;

/**
  * 概述: 告警规则条件表业务逻辑实现
  * 功能描述: 告警规则条件表业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00003BLImpl extends BaseBLImpl implements
		Mss00003BL {

	/** 告警规则条件表DAO接口 */
	protected Mss00003DAO mss00003DAO;
	
	/**
	 * 告警规则条件表DAO接口设定
	 *
	 * @param mss00003DAO 告警规则条件表DAO接口
	 */
	public void setMss00003DAO(Mss00003DAO mss00003DAO) {
		this.mss00003DAO = mss00003DAO;
	}

	/**
	 * 告警规则条件表实例取得
	 *
	 * @return 告警规则条件表实例
	 */
	public Mss00003TB getMss00003TBInstance() {
		return new Mss00003TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00003Info> searchMss00003() {
		return mss00003DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00003Info searchMss00003ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00003SearchCond cond) {
		return mss00003DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00003Info> searchMss00003(
			Mss00003SearchCond cond) {
		return mss00003DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00003Info> searchMss00003(
			Mss00003SearchCond cond, int start,
			int count) {
		return mss00003DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00003Info registMss00003(Mss00003Info instance)
		throws BLException {
		return mss00003DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00003Info updateMss00003(Mss00003Info instance)
		throws BLException {
		checkExistInstance(instance.getRuleconditionid());
		return mss00003DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00003ByPK(Integer pk)
		throws BLException {
		mss00003DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00003(Mss00003Info instance)
		throws BLException {
		mss00003DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00003Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00003Info instance = mss00003DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}