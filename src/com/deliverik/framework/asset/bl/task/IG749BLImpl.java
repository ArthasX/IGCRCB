/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.asset.model.dao.IG749DAO;
import com.deliverik.framework.asset.model.entity.IG749VW;

/**
  * 概述: 资产模型视图业务逻辑实现
  * 功能描述: 资产模型视图业务逻辑实现
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public class IG749BLImpl extends BaseBLImpl implements
		IG749BL {

	/** 资产模型视图DAO接口 */
	protected IG749DAO ig749DAO;
	
	/**
	 * 资产模型视图DAO接口设定
	 *
	 * @param ig749DAO资产模型视图DAO接口
	 */
	public void setIg749DAO(IG749DAO ig749DAO) {
		this.ig749DAO = ig749DAO;
	}

	/**
	 * 资产模型视图实例取得
	 *
	 * @return 资产模型视图实例
	 */
	public IG749VW getIG749VWInstance() {
		return new IG749VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG749Info> searchIG749Info() {
		return ig749DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public IG749Info searchIG749InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG749SearchCond cond) {
		return ig749DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond) {
		return ig749DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond, int start,
			int count) {
		return ig749DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public IG749Info registIG749Info(IG749Info ig749Info)
		throws BLException {
		return ig749DAO.save(ig749Info);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public IG749Info updateIG749Info(IG749Info ig749Info)
		throws BLException {
		checkExistInstance(ig749Info.getEiid());
		return ig749DAO.save(ig749Info);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteIG749InfoByPK(Integer pk)
		throws BLException {
		ig749DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteIG749Info(IG749Info ig749Info)
		throws BLException {
		ig749DAO.delete(ig749Info);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public IG749Info checkExistInstance(Integer pk)
		throws BLException {
		IG749Info instance = ig749DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}