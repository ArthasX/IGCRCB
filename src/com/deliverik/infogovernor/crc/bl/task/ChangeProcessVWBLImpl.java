/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;
import com.deliverik.infogovernor.crc.model.dao.ChangeProcessVWDAO;
import com.deliverik.infogovernor.crc.model.entity.ChangeProcessVWTB;

/**
  * 概述: 变更流程业务逻辑实现
  * 功能描述: 变更流程业务逻辑实现
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
public class ChangeProcessVWBLImpl extends BaseBLImpl implements
		ChangeProcessVWBL {

	/** 变更流程DAO接口 */
	protected ChangeProcessVWDAO changeProcessVWDAO;
	
	/**
	 * 变更流程DAO接口设定
	 *
	 * @param changeProcessVWDAO 变更流程DAO接口
	 */
	public void setChangeProcessVWDAO(ChangeProcessVWDAO changeProcessVWDAO) {
		this.changeProcessVWDAO = changeProcessVWDAO;
	}

	/**
	 * 变更流程实例取得
	 *
	 * @return 变更流程实例
	 */
	public ChangeProcessVWTB getChangeProcessVWTBInstance() {
		return new ChangeProcessVWTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW() {
		return changeProcessVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ChangeProcessVWInfo searchChangeProcessVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ChangeProcessVWSearchCond cond) {
		return changeProcessVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond) {
		return changeProcessVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ChangeProcessVWInfo> searchChangeProcessVW(
			ChangeProcessVWSearchCond cond, int start,
			int count) {
		return changeProcessVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ChangeProcessVWInfo registChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		return changeProcessVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ChangeProcessVWInfo updateChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrid());
		return changeProcessVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteChangeProcessVWByPK(Integer pk)
		throws BLException {
		changeProcessVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteChangeProcessVW(ChangeProcessVWInfo instance)
		throws BLException {
		changeProcessVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ChangeProcessVWInfo checkExistInstance(Integer pk)
		throws BLException {
		ChangeProcessVWInfo instance = changeProcessVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}