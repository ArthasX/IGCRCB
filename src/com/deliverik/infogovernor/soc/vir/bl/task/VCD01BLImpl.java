/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD01DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD01TB;

/**
  * 概述: vCloud ServiceInstance业务逻辑实现
  * 功能描述: vCloud ServiceInstance业务逻辑实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD01BLImpl extends BaseBLImpl implements
		VCD01BL {

	/** vCloud ServiceInstanceDAO接口 */
	protected VCD01DAO vcd01DAO;

	/**
	 * vCloudServiceInstanceDAO接口取得
	 * @return vcd01DAO vCloudServiceInstanceDAO接口
	 */
	public VCD01DAO getVcd01DAO() {
		return vcd01DAO;
	}

	/**
	 * vCloudServiceInstanceDAO接口设定
	 * @param vcd01DAO vCloudServiceInstanceDAO接口
	 */
	public void setVcd01DAO(VCD01DAO vcd01dao) {
		vcd01DAO = vcd01dao;
	}

	/**
	 * vCloud ServiceInstance实例取得
	 *
	 * @return vCloud ServiceInstance实例
	 */
	public VCD01TB getVCD01TBInstance() {
		return new VCD01TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD01Info> searchVCD01() {
		return vcd01DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD01Info searchVCD01ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD01SearchCond cond) {
		return vcd01DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond) {
		return vcd01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond, int start,
			int count) {
		return vcd01DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD01Info registVCD01(VCD01Info instance)
		throws BLException {
		return vcd01DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD01Info updateVCD01(VCD01Info instance)
		throws BLException {
		checkExistInstance(instance.getVcid());
		return vcd01DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD01ByPK(Integer pk)
		throws BLException {
		vcd01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD01(VCD01Info instance)
		throws BLException {
		vcd01DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD01Info checkExistInstance(Integer pk)
		throws BLException {
		VCD01Info instance = vcd01DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}