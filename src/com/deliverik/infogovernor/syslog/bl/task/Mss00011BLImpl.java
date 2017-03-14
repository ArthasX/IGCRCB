/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.dao.Mss00011DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00011VW;

import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;

/**
  * 概述: mss00011业务逻辑实现
  * 功能描述: mss00011业务逻辑实现
  * 创建记录: 2013/04/16
  * 修改记录: 
  */
public class Mss00011BLImpl extends BaseBLImpl implements
		Mss00011BL {

	/** mss00011DAO接口 */
	protected Mss00011DAO mss00011DAO;
	
	/**
	 * mss00011DAO接口设定
	 *
	 * @param mss00011DAO mss00011DAO接口
	 */
	public void setMss00011DAO(Mss00011DAO mss00011DAO) {
		this.mss00011DAO = mss00011DAO;
	}

	/**
	 * mss00011实例取得
	 *
	 * @return mss00011实例
	 */
	public Mss00011VW getMss00011VWInstance() {
		return new Mss00011VW();
	}
	

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00011Info> searchMss00011() {
		return mss00011DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00011Info searchMss00011ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00011SearchCond cond) {
		return mss00011DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond) {
		return mss00011DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond, int start,
			int count) {
		return mss00011DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00011Info registMss00011(Mss00011Info instance)
		throws BLException {
		return mss00011DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00011Info updateMss00011(Mss00011Info instance)
		throws BLException {
		checkExistInstance(instance.getDeviceid());
		return mss00011DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00011ByPK(Integer pk)
		throws BLException {
		mss00011DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00011(Mss00011Info instance)
		throws BLException {
		mss00011DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00011Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00011Info instance = mss00011DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}


}