/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0409DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0409TB;

/**
  * 概述: 主机pv实时表业务逻辑实现
  * 功能描述: 主机pv实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeBLImpl表名改为SOC0409BLImpl
  */
public class SOC0409BLImpl extends BaseBLImpl implements
		SOC0409BL {

	/** 主机pv实时表DAO接口 */
	protected SOC0409DAO soc0409DAO;
	

	/**
	 * 主机pv实时表实例取得
	 *
	 * @return 主机pv实时表实例
	 */
	public SOC0409TB getSOC0409Instance() {
		return new SOC0409TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0409Info> searchSOC0409() {
		return soc0409DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0409Info searchSOC0409ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0409SearchCond cond) {
		return soc0409DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond) {
		return soc0409DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond, int start,
			int count) {
		return soc0409DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0409Info registSOC0409(SOC0409Info instance)
		throws BLException {
		return soc0409DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0409Info updateSOC0409(SOC0409Info instance)
		throws BLException {
		checkExistInstance(instance.getPhId());
		return soc0409DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0409ByPK(Integer pk)
		throws BLException {
		soc0409DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0409(SOC0409Info instance)
		throws BLException {
		soc0409DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0409Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0409Info instance = soc0409DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 主机pv实时表DAO接口取得
	 *
	 * @return soc0409DAO 主机pv实时表DAO接口
	 */
	public SOC0409DAO getSoc0409DAO() {
		return soc0409DAO;
	}

	/**
	 * 主机pv实时表DAO接口设定
	 *
	 * @param soc0409DAO 主机pv实时表DAO接口
	 */
	public void setSoc0409DAO(SOC0409DAO soc0409DAO) {
		this.soc0409DAO = soc0409DAO;
	}

}