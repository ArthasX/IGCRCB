/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG001DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;

/**
  * 概述: OA角色配置表业务逻辑实现
  * 功能描述: OA角色配置表业务逻辑实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public class IG001BLImpl extends BaseBLImpl implements IG001BL {

	/** OA角色配置表DAO接口 */
	protected IG001DAO ig001DAO;
	
	/**
	 * OA角色配置表DAO接口设定
	 *
	 * @param iG001DAO OA角色配置表DAO接口
	 */
	public void setIg001DAO(IG001DAO ig001dao) {
		ig001DAO = ig001dao;
	}

	/**
	 * OA角色配置表实例取得
	 *
	 * @return OA角色配置表实例
	 */
	public IG001TB getIG001TBInstance() {
		return new IG001TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG001Info> searchIG001() {
		return ig001DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG001Info searchIG001ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG001SearchCond cond) {
		return ig001DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond) {
		return ig001DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond, int start,int count) {
		return ig001DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG001Info registIG001(IG001Info instance) throws BLException {
		return ig001DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG001Info updateIG001(IG001Info instance) throws BLException {
		checkExistInstance(instance.getProid());
		return ig001DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG001ByPK(Integer pk) throws BLException {
		ig001DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG001(IG001Info instance) throws BLException {
		ig001DAO.delete(instance);
	}
	
	/**
	 * 删除集合
	 * @param infoList
	 */
	public void deleteIG001(List<IG001Info> infoList) throws BLException {
		ig001DAO.delete(infoList);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG001Info checkExistInstance(Integer pk) throws BLException {
		IG001Info instance = ig001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}