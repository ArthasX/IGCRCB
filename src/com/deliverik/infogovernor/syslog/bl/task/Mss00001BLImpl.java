/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00001DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;

/**
  * 概述: 设备信息表业务逻辑实现
  * 功能描述: 设备信息表业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00001BLImpl extends BaseBLImpl implements
		Mss00001BL {

	/** 设备信息表DAO接口 */
	protected Mss00001DAO mss00001DAO;
	
	/**
	 * 设备信息表DAO接口设定
	 *
	 * @param mss00001DAO 设备信息表DAO接口
	 */
	public void setMss00001DAO(Mss00001DAO mss00001DAO) {
		this.mss00001DAO = mss00001DAO;
	}

	/**
	 * 设备信息表实例取得
	 *
	 * @return 设备信息表实例
	 */
	public Mss00001TB getMss00001TBInstance() {
		return new Mss00001TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00001Info> searchMss00001() {
		return mss00001DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00001Info searchMss00001ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00001SearchCond cond) {
		return mss00001DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond) {
		return mss00001DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond, int start,
			int count) {
		return mss00001DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00001Info registMss00001(Mss00001Info instance)
		throws BLException {
		return mss00001DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00001Info updateMss00001(Mss00001Info instance)
		throws BLException {
		checkExistInstance(instance.getDeviceid());
		return mss00001DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00001ByPK(Integer pk)
		throws BLException {
		mss00001DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00001(Mss00001Info instance)
		throws BLException {
		mss00001DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00001Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00001Info instance = mss00001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}