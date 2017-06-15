/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG506DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;

/**
  * 概述: 人员类表单值表业务逻辑实现
  * 功能描述: 人员类表单值表业务逻辑实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG506BLImpl extends BaseBLImpl implements IG506BL {

	/** 人员类表单值表DAO接口 */
	protected IG506DAO ig506DAO;
	
	/**
	 * 人员类表单值表DAO接口设定
	 *
	 * @param iG506DAO 人员类表单值表DAO接口
	 */
	public void setIg506DAO(IG506DAO ig506DAO) {
		this.ig506DAO = ig506DAO;
	}

	/**
	 * 人员类表单值表实例取得
	 *
	 * @return 人员类表单值表实例
	 */
	public IG506TB getIG506TBInstance() {
		return new IG506TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG506Info> searchIG506() {
		return ig506DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG506Info searchIG506ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG506SearchCond cond) {
		return ig506DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond) {
		return ig506DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond, int start, int count) {
		return ig506DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 根据流程主键检索
	 * @param prid 流程主键
	 * @return
	 * @throws BLException
	 */
	public List<IG506Info> findByPrid(Integer prid) throws BLException {
		if(prid == null || prid == 0) return null;
		IG506SearchCondImpl cond = new IG506SearchCondImpl();
		cond.setPrid(prid);
		return searchIG506(cond);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG506Info registIG506(IG506Info instance) throws BLException {
		return ig506DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG506Info updateIG506(IG506Info instance) throws BLException {
		checkExistInstance(instance.getPiuid());
		return ig506DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG506ByPK(Integer pk) throws BLException {
		ig506DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG506(IG506Info instance) throws BLException {
		ig506DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG506Info checkExistInstance(Integer pk) throws BLException {
		IG506Info instance = ig506DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}