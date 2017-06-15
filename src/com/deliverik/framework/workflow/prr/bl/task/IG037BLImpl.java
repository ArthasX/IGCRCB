/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG037DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;

/**
  * 概述: 流程导入日志表业务逻辑实现
  * 功能描述: 流程导入日志表业务逻辑实现
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
public class IG037BLImpl extends BaseBLImpl implements
		IG037BL {

	/** 流程导入日志表DAO接口 */
	protected IG037DAO ig037DAO;
	
	/**
	 * 流程导入日志表DAO接口设定
	 *
	 * @param ig037DAO 流程导入日志表DAO接口
	 */
	public void setIg037DAO(IG037DAO ig037DAO) {
		this.ig037DAO = ig037DAO;
	}

	/**
	 * 流程导入日志表实例取得
	 *
	 * @return 流程导入日志表实例
	 */
	public IG037TB getIG037TBInstance() {
		return new IG037TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG037Info> searchIG037() {
		return ig037DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG037Info searchIG037ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG037SearchCond cond) {
		return ig037DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond) {
		return ig037DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond, int start,
			int count) {
		return ig037DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG037Info registIG037(IG037Info instance)
		throws BLException {
		return ig037DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG037Info updateIG037(IG037Info instance)
		throws BLException {
		checkExistInstance(instance.getIrid());
		return ig037DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG037ByPK(Integer pk)
		throws BLException {
		ig037DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG037(IG037Info instance)
		throws BLException {
		ig037DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG037Info checkExistInstance(Integer pk)
		throws BLException {
		IG037Info instance = ig037DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}