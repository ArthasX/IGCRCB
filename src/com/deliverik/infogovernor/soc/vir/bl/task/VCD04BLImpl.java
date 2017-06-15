/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD04DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;

/**
  * 概述: vCloud部署日志业务逻辑实现
  * 功能描述: vCloud部署日志业务逻辑实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD04BLImpl extends BaseBLImpl implements
		VCD04BL {

	/** vCloud部署日志DAO接口 */
	protected VCD04DAO vcd04DAO;

	/**
	 * vCloud部署日志DAO接口设定
	 * @param vcd04DAO vCloud部署日志DAO接口
	 */
	public void setVcd04DAO(VCD04DAO vcd04dao) {
		vcd04DAO = vcd04dao;
	}

	/**
	 * vCloud部署日志实例取得
	 *
	 * @return vCloud部署日志实例
	 */
	public VCD04TB getVCD04TBInstance() {
		return new VCD04TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD04Info> searchVCD04() {
		return vcd04DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD04Info searchVCD04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD04SearchCond cond) {
		return vcd04DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond) {
		return vcd04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond, int start,
			int count) {
		return vcd04DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD04Info registVCD04(VCD04Info instance)
		throws BLException {
		return vcd04DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD04Info updateVCD04(VCD04Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd04DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD04ByPK(Integer pk)
		throws BLException {
		vcd04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD04(VCD04Info instance)
		throws BLException {
		vcd04DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD04Info checkExistInstance(Integer pk)
		throws BLException {
		VCD04Info instance = vcd04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}