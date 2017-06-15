/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM07DAO;

/**
  * 概述: 虚机调整信息表业务逻辑实现
  * 功能描述: 虚机调整信息表业务逻辑实现
  * 创建记录: 2014/03/24
  * 修改记录: 
  */
public class VIM07BLImpl extends BaseBLImpl implements
		VIM07BL {

	/** 虚机调整信息表DAO接口 */
	protected VIM07DAO vim07DAO;
	
	/**
	 * 虚机调整信息表DAO接口设定
	 *
	 * @param vim07DAO 虚机调整信息表DAO接口
	 */
	public void setVim07DAO(VIM07DAO vim07DAO) {
		this.vim07DAO = vim07DAO;
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM07Info searchVim07ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM07SearchCond cond) {
		return vim07DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond) {
		return vim07DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond, int start, int count) {
		return vim07DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM07Info registVim07(VIM07Info instance) throws BLException {
		return vim07DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM07Info updateVim07(VIM07Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return vim07DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVim07ByPK(Integer pk) throws BLException {
		vim07DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVim07(VIM07Info instance) throws BLException {
		vim07DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM07Info checkExistInstance(Integer pk) throws BLException {
		VIM07Info instance = vim07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}