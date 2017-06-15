/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM06DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM06TB;

/**
  * 概述: vim06业务逻辑实现
  * 功能描述: vim06业务逻辑实现
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
public class VIM06BLImpl extends BaseBLImpl implements
		VIM06BL {

	/** vim06DAO接口 */
	protected VIM06DAO vim06DAO;
	
	/**
	 * vim06DAO接口设定
	 *
	 * @param vim06DAO vim06DAO接口
	 */
	public void setVim06DAO(VIM06DAO vim06DAO) {
		this.vim06DAO = vim06DAO;
	}

	/**
	 * vim06实例取得
	 *
	 * @return vim06实例
	 */
	public VIM06TB getVim06TBInstance() {
		return new VIM06TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM06Info> searchVim06() {
		return vim06DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM06Info searchVim06ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM06SearchCond cond) {
		return vim06DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond) {
		return vim06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond, int start,
			int count) {
		return vim06DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM06Info registVim06(VIM06Info instance)
		throws BLException {
		return vim06DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM06Info updateVim06(VIM06Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim06DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVim06ByPK(Integer pk)
		throws BLException {
		vim06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVim06(VIM06Info instance)
		throws BLException {
		vim06DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM06Info checkExistInstance(Integer pk)
		throws BLException {
		VIM06Info instance = vim06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}



}