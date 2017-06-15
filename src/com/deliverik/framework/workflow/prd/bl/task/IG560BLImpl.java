/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG560DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;

/**
  * 概述: 流程状态级私有表单默认值表业务逻辑实现
  * 功能描述: 流程状态级私有表单默认值表业务逻辑实现
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public class IG560BLImpl extends BaseBLImpl implements
		IG560BL {

	/** 流程状态级私有表单默认值表DAO接口 */
	protected IG560DAO ig560DAO;
	
	/**
	 * 流程状态级私有表单默认值表DAO接口设定
	 *
	 * @param ig560DAO 流程状态级私有表单默认值表DAO接口
	 */
	public void setIg560DAO(IG560DAO ig560DAO) {
		this.ig560DAO = ig560DAO;
	}

	/**
	 * 流程状态级私有表单默认值表实例取得
	 *
	 * @return 流程状态级私有表单默认值表实例
	 */
	public IG560TB getIG560TBInstance() {
		return new IG560TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG560Info> searchIG560() {
		return ig560DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG560Info searchIG560ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG560SearchCond cond) {
		return ig560DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond) {
		return ig560DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond, int start,
			int count) {
		return ig560DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG560Info registIG560(IG560Info instance)
		throws BLException {
		return ig560DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG560Info updateIG560(IG560Info instance)
		throws BLException {
		checkExistInstance(instance.getDvid());
		return ig560DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG560ByPK(Integer pk)
		throws BLException {
		ig560DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG560(IG560Info instance)
		throws BLException {
		ig560DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG560Info checkExistInstance(Integer pk)
		throws BLException {
		IG560Info instance = ig560DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	public List<IG560VWInfo> searchIG560VW(IG560SearchCondImpl cond)throws BLException{
		return this.ig560DAO.searchIG560VW(cond);
	}
	
	public void saveOrUpdateAll(List<IG560Info> list)throws BLException{
		this.ig560DAO.saveOrUpdateAll(list);
	}

}