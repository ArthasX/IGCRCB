/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;
import com.deliverik.infogovernor.drm.model.dao.SOC0509DAO;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
  * 概述: 预案章节信息业务逻辑实现
  * 功能描述: 预案章节信息业务逻辑实现
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
public class SOC0509BLImpl extends BaseBLImpl implements
		SOC0509BL {

	/** 预案章节信息DAO接口 */
	protected SOC0509DAO soc0509DAO;
	
	/**
	 * 预案章节信息DAO接口设定
	 *
	 * @param sOC0509DAO 预案章节信息DAO接口
	 */

	/**
	 * 预案章节信息实例取得
	 *
	 * @return 预案章节信息实例
	 */
	public SOC0509TB getSOC0509TBInstance() {
		return new SOC0509TB();
	}

	public void setSoc0509DAO(SOC0509DAO soc0509DAO) {
		this.soc0509DAO = soc0509DAO;
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0509Info> searchSOC0509() {
		return soc0509DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0509Info searchSOC0509ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0509SearchCond cond) {
		return soc0509DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond) {
		return soc0509DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond, int start,
			int count) {
		return soc0509DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0509Info registSOC0509(SOC0509Info instance)
		throws BLException {
		return soc0509DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0509Info updateSOC0509(SOC0509Info instance)
		throws BLException {
		checkExistInstance(instance.getCid());
		return soc0509DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0509ByPK(String pk)
		throws BLException {
		soc0509DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0509(SOC0509Info instance)
		throws BLException {
		soc0509DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0509Info checkExistInstance(String pk)
		throws BLException {
		SOC0509Info instance = soc0509DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public Integer getNextCorder() {
		return soc0509DAO.getNextCorder();
	}

}