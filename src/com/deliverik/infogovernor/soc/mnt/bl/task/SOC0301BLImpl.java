/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0301DAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * 概述: DMX实时监控性能表业务逻辑实现
  * 功能描述: DMX实时监控性能表业务逻辑实现
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public class SOC0301BLImpl extends BaseBLImpl implements
		SOC0301BL {

	/** DMX实时监控性能表DAO接口 */
	protected SOC0301DAO soc0301DAO;
	

	/**
	 * DMX实时监控性能表DAO接口设定
	 *
	 * @param soc0301DAO DMX实时监控性能表DAO接口
	 */
	public void setSoc0301DAO(SOC0301DAO soc0301DAO) {
		this.soc0301DAO = soc0301DAO;
	}

	/**
	 * DMX实时监控性能表实例取得
	 *
	 * @return DMX实时监控性能表实例
	 */
	public SOC0301TB getSoc0301Instance() {
		return new SOC0301TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0301Info> searchSoc0301() {
		return soc0301DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0301Info searchSoc0301ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0301SearchCond cond) {
		return soc0301DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond) {
		return soc0301DAO.findByCond(cond, 0, 0);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301OrderByTimeAndName(
			SOC0301SearchCond cond) {
		return soc0301DAO.findByCondOrderByTimeAndName(cond, 0, 0);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond, int start,
			int count) {
		return soc0301DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0301Info registSoc0301(SOC0301Info instance)
		throws BLException {
		return soc0301DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0301Info updateSoc0301(SOC0301Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0301DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSoc0301ByPK(Integer pk)
		throws BLException {
		soc0301DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSoc0301(SOC0301Info instance)
		throws BLException {
		soc0301DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0301Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0301Info instance = soc0301DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}



}