/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;
import com.deliverik.infogovernor.sym.model.dao.CustomConfigurationDAO;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;

/**
  * 概述: 自定义流程配置表业务逻辑实现
  * 功能描述: 自定义流程配置表业务逻辑实现
  * 创建记录: 2012/11/05
  * 修改记录: 
  */
public class CustomConfigurationBLImpl extends BaseBLImpl implements
		CustomConfigurationBL {

	/** 自定义流程配置表DAO接口 */
	protected CustomConfigurationDAO customConfigurationDAO;
	
	/**
	 * 自定义流程配置表DAO接口设定
	 *
	 * @param customConfigurationDAO 自定义流程配置表DAO接口
	 */
	public void setCustomConfigurationDAO(CustomConfigurationDAO customConfigurationDAO) {
		this.customConfigurationDAO = customConfigurationDAO;
	}

	/**
	 * 自定义流程配置表实例取得
	 *
	 * @return 自定义流程配置表实例
	 */
	public CustomConfigurationTB getCustomConfigurationTBInstance() {
		return new CustomConfigurationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration() {
		return customConfigurationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CustomConfigurationInfo searchCustomConfigurationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CustomConfigurationSearchCond cond) {
		return customConfigurationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration(
			CustomConfigurationSearchCond cond) {
		return customConfigurationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration(
			CustomConfigurationSearchCond cond, int start,
			int count) {
		return customConfigurationDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CustomConfigurationInfo registCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		return customConfigurationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CustomConfigurationInfo updateCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		checkExistInstance(instance.getRfdid());
		return customConfigurationDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCustomConfigurationByPK(Integer pk)
		throws BLException {
		customConfigurationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		customConfigurationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CustomConfigurationInfo checkExistInstance(Integer pk)
		throws BLException {
		CustomConfigurationInfo instance = customConfigurationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}