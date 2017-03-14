/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG898DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;

/**
  * 概述: 表格类表单值表业务逻辑实现
  * 功能描述: 表格类表单值表业务逻辑实现
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
public class IG898BLImpl extends BaseBLImpl implements IG898BL {

	/** 表格类表单值表DAO接口 */
	protected IG898DAO ig898DAO;
	
	/**
	 * 表格类表单值表DAO接口设定
	 *
	 * @param iG898DAO 表格类表单值表DAO接口
	 */
	public void setIg898DAO(IG898DAO ig898DAO) {
		this.ig898DAO = ig898DAO;
	}

	/**
	 * 表格类表单值表实例取得
	 *
	 * @return 表格类表单值表实例
	 */
	public IG898TB getIG898TBInstance() {
		return new IG898TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG898Info> searchIG898() {
		return ig898DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG898Info searchIG898ByPK(IG898PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG898SearchCond cond) {
		return ig898DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond) {
		return ig898DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond, int start, int count) {
		return ig898DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG898Info registIG898(IG898Info instance) throws BLException {
		return ig898DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG898Info updateIG898(IG898Info instance) throws BLException {
		checkExistInstance(new IG898PK(instance.getPrid(), instance.getPidid(), instance.getPvcolpidid(), instance.getPvrownumber()));
		return ig898DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG898ByPK(IG898PK pk) throws BLException {
		ig898DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG898(IG898Info instance) throws BLException {
		ig898DAO.delete(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG898(List<IG898Info> list) throws BLException {
		ig898DAO.delete(list);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG898Info checkExistInstance(IG898PK pk) throws BLException {
		IG898Info instance = ig898DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
     * 取得表格类型表单的行数
     *
     * @param cond 检索条件
     * @return 表格表单行数
     */
	public int getTableRowCount(IG898SearchCond cond) throws BLException {
	    return ig898DAO.getTableRowCount(cond);
	}
	
}