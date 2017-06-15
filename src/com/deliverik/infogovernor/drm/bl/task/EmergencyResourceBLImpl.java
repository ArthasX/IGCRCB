/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EmergencyResourceDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;

/**
  * 概述: EmergencyResource业务逻辑实现
  * 功能描述: EmergencyResource业务逻辑实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class EmergencyResourceBLImpl extends BaseBLImpl implements
		EmergencyResourceBL {

	/** EmergencyResourceDAO接口 */
	protected EmergencyResourceDAO emergencyResourceDAO;
	
	/**
	 * EmergencyResourceDAO接口设定
	 *
	 * @param emergencyResourceDAO EmergencyResourceDAO接口
	 */
	public void setEmergencyResourceDAO(EmergencyResourceDAO emergencyResourceDAO) {
		this.emergencyResourceDAO = emergencyResourceDAO;
	}

	/**
	 * EmergencyResource实例取得
	 *
	 * @return EmergencyResource实例
	 */
	public EmergencyResourceTB getEmergencyResourceTBInstance() {
		return new EmergencyResourceTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource() {
		return emergencyResourceDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmergencyResourceInfo searchEmergencyResourceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EmergencyResourceSearchCond cond) {
		return emergencyResourceDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource(
			EmergencyResourceSearchCond cond) {
		return emergencyResourceDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource(
			EmergencyResourceSearchCond cond, int start,
			int count) {
		return emergencyResourceDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EmergencyResourceInfo registEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		return emergencyResourceDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EmergencyResourceInfo updateEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		checkExistInstance(instance.getErid());
		return emergencyResourceDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEmergencyResourceByPK(Integer pk)
		throws BLException {
		emergencyResourceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		emergencyResourceDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public EmergencyResourceInfo checkExistInstance(Integer pk)
		throws BLException {
		EmergencyResourceInfo instance = emergencyResourceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}