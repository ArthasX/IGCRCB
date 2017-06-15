/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.CheckToRiskRelateVWDAO;
import com.deliverik.infogovernor.asset.model.entity.CheckToRiskRelateVW;

/**
  * 概述: 检查项到风险点关系模型业务逻辑实现
  * 功能描述: 检查项到风险点关系模型业务逻辑实现
  * 创建记录: 2014/07/23
  * 修改记录: 
  */
public class CheckToRiskRelateVWBLImpl extends BaseBLImpl implements
		CheckToRiskRelateVWBL {

	/** 检查项到风险点关系模型DAO接口 */
	protected CheckToRiskRelateVWDAO checkToRiskRelateVWDAO;
	
	/**
	 * 检查项到风险点关系模型DAO接口设定
	 *
	 * @param checkToRiskRelateVWDAO 检查项到风险点关系模型DAO接口
	 */
	public void setCheckToRiskRelateVWDAO(CheckToRiskRelateVWDAO checkToRiskRelateVWDAO) {
		this.checkToRiskRelateVWDAO = checkToRiskRelateVWDAO;
	}

	/**
	 * 检查项到风险点关系模型实例取得
	 *
	 * @return 检查项到风险点关系模型实例
	 */
	public CheckToRiskRelateVW getCheckToRiskRelateVWInstance() {
		return new CheckToRiskRelateVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW() {
		return checkToRiskRelateVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckToRiskRelateVWInfo searchCheckToRiskRelateVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckToRiskRelateVWSearchCond cond) {
		return checkToRiskRelateVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond) {
		return checkToRiskRelateVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond, int start,
			int count) {
		return checkToRiskRelateVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckToRiskRelateVWInfo registCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		return checkToRiskRelateVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckToRiskRelateVWInfo updateCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return checkToRiskRelateVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckToRiskRelateVWByPK(Integer pk)
		throws BLException {
		checkToRiskRelateVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		checkToRiskRelateVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CheckToRiskRelateVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckToRiskRelateVWInfo instance = checkToRiskRelateVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}