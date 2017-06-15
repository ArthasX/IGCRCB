/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM02DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * 概述: 虚拟资源项目信息表业务逻辑实现
  * 功能描述: 虚拟资源项目信息表业务逻辑实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public class VIM02BLImpl extends BaseBLImpl implements
		VIM02BL {

	/** 虚拟资源项目信息表DAO接口 */
	protected VIM02DAO vim02DAO;
	
	/**
     * 设置虚拟资源项目信息表DAO接口
     * @param vim02DAO 虚拟资源项目信息表DAO接口
     */
    public void setVim02DAO(VIM02DAO vim02dao) {
        vim02DAO = vim02dao;
    }

    /**
	 * 虚拟资源项目信息表实例取得
	 *
	 * @return 虚拟资源项目信息表实例
	 */
	public VIM02TB getVIM02TBInstance() {
		return new VIM02TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM02Info> searchVIM02() {
		return vim02DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM02Info searchVIM02ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM02SearchCond cond) {
		return vim02DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond) {
		return vim02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond, int start,
			int count) {
		return vim02DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM02Info registVIM02(VIM02Info instance)
		throws BLException {
		return vim02DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM02Info updateVIM02(VIM02Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim02DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVIM02ByPK(Integer pk)
		throws BLException {
		vim02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVIM02(VIM02Info instance)
		throws BLException {
		vim02DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM02Info checkExistInstance(Integer pk)
		throws BLException {
		VIM02Info instance = vim02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}