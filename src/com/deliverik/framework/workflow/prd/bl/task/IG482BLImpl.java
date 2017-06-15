/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG482DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG482TB;

/**
  * 概述: 流程组关联关系定义表业务逻辑实现
  * 功能描述: 流程组关联关系定义表业务逻辑实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG482BLImpl extends BaseBLImpl implements
		IG482BL {

	/** 流程组关联关系定义表DAO接口 */
	protected IG482DAO ig482DAO;
	
	/**
	 * 流程组关联关系定义表DAO接口设定
	 *
	 * @param ig482DAO 流程组关联关系定义表DAO接口
	 */
	public void setIg482DAO(IG482DAO ig482DAO) {
		this.ig482DAO = ig482DAO;
	}

	/**
	 * 流程组关联关系定义表实例取得
	 *
	 * @return 流程组关联关系定义表实例
	 */
	public IG482TB getIG482TBInstance() {
		return new IG482TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG482Info> searchIG482() {
		return ig482DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG482Info searchIG482ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG482SearchCond cond) {
		return ig482DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond) {
		return ig482DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond, int start,
			int count) {
		return ig482DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG482Info registIG482(IG482Info instance)
		throws BLException {
		return ig482DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG482Info updateIG482(IG482Info instance)
		throws BLException {
		checkExistInstance(instance.getPgreid());
		return ig482DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG482ByPK(String pk)
		throws BLException {
		ig482DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG482(IG482Info instance)
		throws BLException {
		ig482DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG482Info checkExistInstance(String pk)
		throws BLException {
		IG482Info instance = ig482DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}