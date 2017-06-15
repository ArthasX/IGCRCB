/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00014SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00014DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00014TB;

/**
  * 概述: mss00014业务逻辑实现
  * 功能描述: mss00014业务逻辑实现
  * 创建记录: 2014/01/21
  * 修改记录: 
  */
public class Mss00014BLImpl extends BaseBLImpl implements
		Mss00014BL {

	/** mss00014DAO接口 */
	protected Mss00014DAO mss00014DAO;
	
	/**
	 * mss00014DAO接口设定
	 *
	 * @param mss00014DAO mss00014DAO接口
	 */
	public void setMss00014DAO(Mss00014DAO mss00014DAO) {
		this.mss00014DAO = mss00014DAO;
	}

	/**
	 * mss00014实例取得
	 *
	 * @return mss00014实例
	 */
	public Mss00014TB getMss00014TBInstance() {
		return new Mss00014TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00014Info> searchMss00014() {
		return mss00014DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00014Info searchMss00014ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00014SearchCond cond) {
		return mss00014DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00014Info> searchMss00014(
			Mss00014SearchCond cond) {
		return mss00014DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00014Info> searchMss00014(
			Mss00014SearchCond cond, int start,
			int count) {
		return mss00014DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00014Info registMss00014(Mss00014Info instance)
		throws BLException {
		return mss00014DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00014Info updateMss00014(Mss00014Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00014DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00014ByPK(Integer pk)
		throws BLException {
		mss00014DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00014(Mss00014Info instance)
		throws BLException {
		mss00014DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00014Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00014Info instance = mss00014DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}