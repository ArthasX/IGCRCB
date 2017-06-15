/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD03DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;

/**
  * 概述: 资源申请虚机信息业务逻辑实现
  * 功能描述: 资源申请虚机信息业务逻辑实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD03BLImpl extends BaseBLImpl implements
		VCD03BL {

	/** 资源申请虚机信息DAO接口 */
	protected VCD03DAO vcd03DAO;

	/**
	 * 资源申请虚机信息DAO接口设定
	 * @param vcd03DAO 资源申请虚机信息DAO接口
	 */
	public void setVcd03DAO(VCD03DAO vcd03dao) {
		vcd03DAO = vcd03dao;
	}

	/**
	 * 资源申请虚机信息实例取得
	 *
	 * @return 资源申请虚机信息实例
	 */
	public VCD03TB getVCD03TBInstance() {
		return new VCD03TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD03Info> searchVCD03() {
		return vcd03DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD03Info searchVCD03ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD03SearchCond cond) {
		return vcd03DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond) {
		return vcd03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond, int start,
			int count) {
		return vcd03DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD03Info registVCD03(VCD03Info instance)
		throws BLException {
		return vcd03DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD03Info updateVCD03(VCD03Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd03DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD03ByPK(Integer pk)
		throws BLException {
		vcd03DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD03(VCD03Info instance)
		throws BLException {
		vcd03DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD03Info checkExistInstance(Integer pk)
		throws BLException {
		VCD03Info instance = vcd03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}