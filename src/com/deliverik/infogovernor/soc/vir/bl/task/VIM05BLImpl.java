/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM05DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

/**
  * 概述: vim05业务逻辑实现
  * 功能描述: vim05业务逻辑实现
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
public class VIM05BLImpl extends BaseBLImpl implements
		VIM05BL {

	/** vim05DAO接口 */
	protected VIM05DAO vim05DAO;
	
	/**
	 * vim05DAO接口设定
	 *
	 * @param vim05DAO vim05DAO接口
	 */
	public void setVim05DAO(VIM05DAO vim05DAO) {
		this.vim05DAO = vim05DAO;
	}

	/**
	 * vim05实例取得
	 *
	 * @return vim05实例
	 */
	public VIM05TB getVim05TBInstance() {
		return new VIM05TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM05Info> searchVim05() {
		return vim05DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM05Info searchVim05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM05SearchCond cond) {
		return vim05DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond) {
		return vim05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond, int start,
			int count) {
		return vim05DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM05Info registVim05(VIM05Info instance)
		throws BLException {
		return vim05DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM05Info updateVim05(VIM05Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim05DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVim05ByPK(Integer pk)
		throws BLException {
		vim05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVim05(VIM05Info instance)
		throws BLException {
		vim05DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM05Info checkExistInstance(Integer pk)
		throws BLException {
		VIM05Info instance = vim05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}