/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG256DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;

/**
  * 概述: 流程策略提醒业务逻辑实现
  * 功能描述: 流程策略提醒业务逻辑实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG256BLImpl extends BaseBLImpl implements
		IG256BL {

	/** 流程策略提醒DAO接口 */
	protected IG256DAO ig256DAO;
	
	/**
	 * 流程策略提醒DAO接口设定
	 *
	 * @param ig256DAO 流程策略提醒DAO接口
	 */
	public void setig256DAO(IG256DAO ig256DAO) {
		this.ig256DAO = ig256DAO;
	}

	/**
	 * 流程策略提醒实例取得
	 *
	 * @return 流程策略提醒实例
	 */
	public IG256TB getIG256TBInstance() {
		return new IG256TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG256Info> searchIG256() {
		return ig256DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG256Info searchIG256ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG256SearchCond cond) {
		return ig256DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond) {
		return ig256DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond, int start,
			int count) {
		return ig256DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG256Info registIG256(IG256Info instance)
		throws BLException {
		return ig256DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG256Info updateIG256(IG256Info instance)
		throws BLException {
		checkExistInstance(instance.getFnid());
		return ig256DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG256ByPK(Integer pk)
		throws BLException {
		ig256DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG256(IG256Info instance)
		throws BLException {
		ig256DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG256Info checkExistInstance(Integer pk)
		throws BLException {
		IG256Info instance = ig256DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}