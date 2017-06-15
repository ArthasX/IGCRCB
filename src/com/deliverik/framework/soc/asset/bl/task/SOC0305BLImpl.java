/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0305DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0307DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
  * 概述: SOC0305业务逻辑实现
  * 功能描述: SOC0305业务逻辑实现
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public class SOC0305BLImpl extends BaseBLImpl implements
		SOC0305BL {

	/** SOC0305DAO接口 */
	protected SOC0305DAO soc0305DAO;
	
	/** SOC0307DAO接口 */
	protected SOC0307DAO soc0307DAO;
	
	/**
	 * SOC0305VWDAO接口设定
	 * @param soc0307DAO
	 */
	public void setSoc0307DAO(SOC0307DAO soc0307DAO) {
		this.soc0307DAO = soc0307DAO;
	}

	/**
	 * SOC0305DAO接口设定
	 *
	 * @param storageEventDAOSOC0305DAO接口
	 */
	public void setSoc0305DAO(SOC0305DAO soc0305DAO) {
		this.soc0305DAO = soc0305DAO;
	}

	/**
	 * SOC0305实例取得
	 *
	 * @return SOC0305实例
	 */
	public SOC0305TB getSoc0305Instance() {
		return new SOC0305TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0305Info> searchSoc0305() {
		return soc0305DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0305Info searchSoc0305ByPK(Integer id)
		throws BLException {
		return checkExistInstance(id);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0305SearchCond cond) {
		return soc0305DAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getVWSearchCount(SOC0305SearchCond cond) {
		return soc0307DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond) {
		return soc0305DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond, int start,
			int count) {
		return soc0305DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0307Info> searchSOC0307(
			SOC0305SearchCond cond, int start,
			int count) {
		return soc0307DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0305Info registSoc0305(SOC0305Info instance)
		throws BLException {
		return soc0305DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0305Info updateSoc0305(SOC0305Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0305DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSoc0305ByPK(Integer id)
		throws BLException {
		soc0305DAO.delete(checkExistInstance(id));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSoc0305(SOC0305Info instance)
		throws BLException {
		soc0305DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0305Info checkExistInstance(Integer id)
		throws BLException {
		SOC0305Info instance = soc0305DAO.findByPK(id);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}


}