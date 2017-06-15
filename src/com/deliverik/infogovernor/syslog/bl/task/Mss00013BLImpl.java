/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00013DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * 概述: mss00013业务逻辑实现
  * 功能描述: mss00013业务逻辑实现
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
public class Mss00013BLImpl extends BaseBLImpl implements
		Mss00013BL {

	/** mss00013DAO接口 */
	protected Mss00013DAO mss00013DAO;
	
	/**
	 * mss00013DAO接口设定
	 *
	 * @param mss00013DAO mss00013DAO接口
	 */
	public void setMss00013DAO(Mss00013DAO mss00013DAO) {
		this.mss00013DAO = mss00013DAO;
	}

	/**
	 * mss00013实例取得
	 *
	 * @return mss00013实例
	 */
	public Mss00013TB getMss00013TBInstance() {
		return new Mss00013TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00013Info> searchMss00013() {
		return mss00013DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00013Info searchMss00013ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00013SearchCond cond) {
		return mss00013DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond) {
		return mss00013DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond, int start,
			int count) {
		return mss00013DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00013Info registMss00013(Mss00013Info instance)
		throws BLException {
		return mss00013DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00013Info updateMss00013(Mss00013Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00013DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00013ByPK(Integer pk)
		throws BLException {
		mss00013DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00013(Mss00013Info instance)
		throws BLException {
		mss00013DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00013Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00013Info instance = mss00013DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}