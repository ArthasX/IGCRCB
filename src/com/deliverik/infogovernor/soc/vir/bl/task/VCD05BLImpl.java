/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD05DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD05TB;

/**
  * 概述: vCloud部署模板业务逻辑实现
  * 功能描述: vCloud部署模板业务逻辑实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD05BLImpl extends BaseBLImpl implements
		VCD05BL {

	/** vCloud部署模板DAO接口 */
	protected VCD05DAO vcd05DAO;

	/**
	 * vCloud部署模板DAO接口设定
	 * @param vcd05DAO vCloud部署模板DAO接口
	 */
	public void setVcd05DAO(VCD05DAO vcd05dao) {
		vcd05DAO = vcd05dao;
	}

	/**
	 * vCloud部署模板实例取得
	 *
	 * @return vCloud部署模板实例
	 */
	public VCD05TB getVCD05TBInstance() {
		return new VCD05TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD05Info> searchVCD05() {
		return vcd05DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD05Info searchVCD05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD05SearchCond cond) {
		return vcd05DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond) {
		return vcd05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond, int start,
			int count) {
		return vcd05DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD05Info registVCD05(VCD05Info instance)
		throws BLException {
		return vcd05DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD05Info updateVCD05(VCD05Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd05DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD05ByPK(Integer pk)
		throws BLException {
		vcd05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD05(VCD05Info instance)
		throws BLException {
		vcd05DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD05Info checkExistInstance(Integer pk)
		throws BLException {
		VCD05Info instance = vcd05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}