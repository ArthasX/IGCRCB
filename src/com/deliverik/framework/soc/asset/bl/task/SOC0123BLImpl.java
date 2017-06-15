/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0123SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0123DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;

/**
  * 概述: 资产模型视图业务逻辑实现
  * 功能描述: 资产模型视图业务逻辑实现
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public class SOC0123BLImpl extends BaseBLImpl implements
		SOC0123BL {

	/** 资产模型视图DAO接口 */
	protected SOC0123DAO soc0123DAO;
	


	/**
	 * 资产模型视图DAO接口设定
	 *
	 * @param soc0123DAO 资产模型视图DAO接口
	 */
	public void setSoc0123DAO(SOC0123DAO soc0123DAO) {
		this.soc0123DAO = soc0123DAO;
	}

	/**
	 * 资产模型视图实例取得
	 *
	 * @return 资产模型视图实例
	 */
	public SOC0123VW getEntityItemEntityVWTBInstance() {
		return new SOC0123VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0123Info> searchEntityItemEntityVW() {
		return soc0123DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0123Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0123SearchCond cond) {
		return soc0123DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond) {
		return soc0123DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond, int start,
			int count) {
		return soc0123DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0123Info registEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		return soc0123DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0123Info updateEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return soc0123DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		soc0123DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		soc0123DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0123Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0123Info instance = soc0123DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}