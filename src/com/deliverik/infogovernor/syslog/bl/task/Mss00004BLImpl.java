/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00004DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;

/**
  * 概述: 告警规则模板表业务逻辑实现
  * 功能描述: 告警规则模板表业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00004BLImpl extends BaseBLImpl implements
		Mss00004BL {

	/** 告警规则模板表DAO接口 */
	protected Mss00004DAO mss00004DAO;
	
	/**
	 * 告警规则模板表DAO接口设定
	 *
	 * @param mss00004DAO 告警规则模板表DAO接口
	 */
	public void setMss00004DAO(Mss00004DAO mss00004DAO) {
		this.mss00004DAO = mss00004DAO;
	}

	/**
	 * 告警规则模板表实例取得
	 *
	 * @return 告警规则模板表实例
	 */
	public Mss00004TB getMss00004TBInstance() {
		return new Mss00004TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00004Info> searchMss00004() {
		return mss00004DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00004Info searchMss00004ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00004SearchCond cond) {
		return mss00004DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00004Info> searchMss00004(
			Mss00004SearchCond cond) {
		return mss00004DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00004Info> searchMss00004(
			Mss00004SearchCond cond, int start,
			int count) {
		return mss00004DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00004Info registMss00004(Mss00004Info instance)
		throws BLException {
		return mss00004DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00004Info updateMss00004(Mss00004Info instance)
		throws BLException {
		checkExistInstance(instance.getRuletempid());
		return mss00004DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00004ByPK(Integer pk)
		throws BLException {
		mss00004DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00004(Mss00004Info instance)
		throws BLException {
		mss00004DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00004Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00004Info instance = mss00004DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 
	 * 查询模板视图
	 *
	 * @作者 zhaoyong
	 */
	public List<Mss00004VWInfo> findByCondVW(Mss00004SearchCond cond,int start, int end) {
		return mss00004DAO.findByCondVW(cond,start,end);
	}

}