/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0411SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0411DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0411TB;

/**
  * 概述: 存储容量实时表业务逻辑实现
  * 功能描述: 存储容量实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将StorageCapacityRealTimeBLImpl表名改为SOC0411BLImpl
  */
public class SOC0411BLImpl extends BaseBLImpl implements
		SOC0411BL {

	/** 存储容量实时表DAO接口 */
	protected SOC0411DAO soc0411DAO;
	
	/**
	 * 存储容量实时表DAO接口设定
	 *
	 * @param soc0411DAO 存储容量实时表DAO接口
	 */
	public void setSoc0411DAO(SOC0411DAO soc0411DAO) {
		this.soc0411DAO = soc0411DAO;
	}

	/**
	 * 存储容量实时表实例取得
	 *
	 * @return 存储容量实时表实例
	 */
	public SOC0411TB getSOC0411Instance() {
		return new SOC0411TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0411Info> searchSOC0411() {
		return soc0411DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0411Info searchSOC0411ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0411SearchCond cond) {
		return soc0411DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond) {
		return soc0411DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond, int start,
			int count) {
		return soc0411DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0411Info registSOC0411(SOC0411Info instance)
		throws BLException {
		return soc0411DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0411Info updateSOC0411(SOC0411Info instance)
		throws BLException {
		checkExistInstance(instance.getScid());
		return soc0411DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0411ByPK(Integer pk)
		throws BLException {
		soc0411DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0411(SOC0411Info instance)
		throws BLException {
		soc0411DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0411Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0411Info instance = soc0411DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}