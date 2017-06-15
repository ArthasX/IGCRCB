/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD02DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
  * 概述: 虚拟资源项目信息业务逻辑实现
  * 功能描述: 虚拟资源项目信息业务逻辑实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD02BLImpl extends BaseBLImpl implements
		VCD02BL {

	/** 虚拟资源项目信息DAO接口 */
	protected VCD02DAO vcd02DAO;

	/**
	 * 虚拟资源项目信息DAO接口设定
	 * @param vcd02DAO 虚拟资源项目信息DAO接口
	 */
	public void setVcd02DAO(VCD02DAO vcd02dao) {
		vcd02DAO = vcd02dao;
	}

	/**
	 * 虚拟资源项目信息实例取得
	 *
	 * @return 虚拟资源项目信息实例
	 */
	public VCD02TB getVCD02TBInstance() {
		return new VCD02TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD02Info> searchVCD02() {
		return vcd02DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD02Info searchVCD02ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD02SearchCond cond) {
		return vcd02DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond) {
		return vcd02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond, int start,
			int count) {
		return vcd02DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD02Info registVCD02(VCD02Info instance)
		throws BLException {
		return vcd02DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD02Info updateVCD02(VCD02Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd02DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD02ByPK(Integer pk)
		throws BLException {
		vcd02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD02(VCD02Info instance)
		throws BLException {
		vcd02DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD02Info checkExistInstance(Integer pk)
		throws BLException {
		VCD02Info instance = vcd02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}