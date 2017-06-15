/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG992DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;

/**
  * 概述: 流程外部调用定义表业务逻辑实现
  * 功能描述: 流程外部调用定义表业务逻辑实现
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public class IG992BLImpl extends BaseBLImpl implements
		IG992BL {

	/** 流程外部调用定义表DAO接口 */
	protected IG992DAO ig992DAO;
	
	/**
	 * 流程外部调用定义表DAO接口设定
	 *
	 * @param ig992DAO 流程外部调用定义表DAO接口
	 */
	public void setIg992DAO(IG992DAO ig992DAO) {
		this.ig992DAO = ig992DAO;
	}

	/**
	 * 流程外部调用定义表实例取得
	 *
	 * @return 流程外部调用定义表实例
	 */
	public IG992TB getIG992TBInstance() {
		return new IG992TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG992Info> searchIG992Info() {
		return ig992DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG992Info searchIG992InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG992SearchCond cond) {
		return ig992DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond) {
		return ig992DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG992Info> searchIG992Info(
			IG992SearchCond cond, int start,
			int count) {
		return ig992DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG992Info registIG992Info(IG992Info instance)
		throws BLException {
		return ig992DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG992Info updateIG992Info(IG992Info instance)
		throws BLException {
		checkExistInstance(instance.getPedid());
		return ig992DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG992InfoByPK(Integer pk)
		throws BLException {
		ig992DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG992Info(IG992Info instance)
		throws BLException {
		ig992DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG992Info checkExistInstance(Integer pk)
		throws BLException {
		IG992Info instance = ig992DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getPedidSequenceNextValue(String psdid) {
		return ig992DAO.getPedidSequenceNextValue(psdid);
	}

}