/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM01DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM01TB;

/**
  * 概述: vCenter ServiceInstance业务逻辑实现
  * 功能描述: vCenter ServiceInstance业务逻辑实现
  * 创建记录: 2014/02/12
  * 修改记录: 
  */
public class VIM01BLImpl extends BaseBLImpl implements
		VIM01BL {

	/** vCenter ServiceInstanceDAO接口 */
	protected VIM01DAO vim01DAO;
	
	/**
	 * vCenter ServiceInstanceDAO接口设定
	 *
	 * @param vIM01DAO vCenter ServiceInstanceDAO接口
	 */
	public void setVim01DAO(VIM01DAO vim01DAO) {
		this.vim01DAO = vim01DAO;
	}

	/**
	 * vCenter ServiceInstance实例取得
	 *
	 * @return vCenter ServiceInstance实例
	 */
	public VIM01TB getVIM01TBInstance() {
		return new VIM01TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM01Info> searchVIM01() {
		return vim01DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM01Info searchVIM01ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM01SearchCond cond) {
		return vim01DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond) {
		return vim01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond, int start,
			int count) {
		return vim01DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM01Info registVIM01(VIM01Info instance)
		throws BLException {
		return vim01DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM01Info updateVIM01(VIM01Info instance)
		throws BLException {
		checkExistInstance(instance.getVcid());
		return vim01DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVIM01ByPK(Integer pk)
		throws BLException {
		vim01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVIM01(VIM01Info instance)
		throws BLException {
		vim01DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM01Info checkExistInstance(Integer pk)
		throws BLException {
		VIM01Info instance = vim01DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}