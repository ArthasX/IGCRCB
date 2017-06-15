/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00005SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00005DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;

/**
  * 概述: 告警信息天表业务逻辑实现
  * 功能描述: 告警信息天表业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00005BLImpl extends BaseBLImpl implements
		Mss00005BL {

	/** 告警信息天表DAO接口 */
	protected Mss00005DAO mss00005DAO;
	
	/**
	 * 告警信息天表DAO接口设定
	 *
	 * @param mss00005DAO 告警信息天表DAO接口
	 */
	public void setMss00005DAO(Mss00005DAO mss00005DAO) {
		this.mss00005DAO = mss00005DAO;
	}

	/**
	 * 告警信息天表实例取得
	 *
	 * @return 告警信息天表实例
	 */
	public Mss00005TB getMss00005TBInstance() {
		return new Mss00005TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00005Info> searchMss00005() {
		return mss00005DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00005Info searchMss00005ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00005SearchCond cond) throws Exception{
		return mss00005DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00005Info> searchMss00005(
			Mss00005SearchCond cond) throws Exception{
		return mss00005DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00005Info> searchMss00005(
			Mss00005SearchCond cond, int start,
			int count) throws Exception{
		return mss00005DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00005Info registMss00005(Mss00005Info instance)
		throws BLException {
		return mss00005DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00005Info updateMss00005(Mss00005Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return mss00005DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00005ByPK(Integer pk)
		throws BLException {
		mss00005DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00005(Mss00005Info instance)
		throws BLException {
		mss00005DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00005Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00005Info instance = mss00005DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}