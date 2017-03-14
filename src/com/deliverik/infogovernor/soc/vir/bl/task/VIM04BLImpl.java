/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM04DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;

/**
  * 概述: 日志表业务逻辑实现
  * 功能描述: 日志表业务逻辑实现
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
public class VIM04BLImpl extends BaseBLImpl implements
		VIM04BL {

	/** 日志表DAO接口 */
	protected VIM04DAO vim04DAO;
	
	/**
     * 设置日志表DAO接口
     * @param vim04DAO 日志表DAO接口
     */
    public void setVim04DAO(VIM04DAO vim04dao) {
        vim04DAO = vim04dao;
    }

    /**
	 * 日志表实例取得
	 *
	 * @return 日志表实例
	 */
	public VIM04TB getVIM04TBInstance() {
		return new VIM04TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM04Info> searchVIM04() {
		return vim04DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM04Info searchVIM04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM04SearchCond cond) {
		return vim04DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond) {
		return vim04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond, int start,
			int count) {
		return vim04DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM04Info registVIM04(VIM04Info instance)
		throws BLException {
		return vim04DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM04Info updateVIM04(VIM04Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim04DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVIM04ByPK(Integer pk)
		throws BLException {
		vim04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVIM04(VIM04Info instance)
		throws BLException {
		vim04DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM04Info checkExistInstance(Integer pk)
		throws BLException {
		VIM04Info instance = vim04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}