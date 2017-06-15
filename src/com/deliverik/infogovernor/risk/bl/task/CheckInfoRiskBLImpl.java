/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckInfoRiskDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;

/**
  * 概述: 检查策略关联检查项表业务逻辑实现
  * 功能描述: 检查策略关联检查项表业务逻辑实现
  * 创建记录: 2014/09/03
  * 修改记录: 
  */
public class CheckInfoRiskBLImpl extends BaseBLImpl implements
		CheckInfoRiskBL {

	/** 检查策略关联检查项表DAO接口 */
	protected CheckInfoRiskDAO checkInfoRiskDAO;
	
	/**
	 * 检查策略关联检查项表DAO接口设定
	 *
	 * @param checkInfoRiskDAO 检查策略关联检查项表DAO接口
	 */
	public void setCheckInfoRiskDAO(CheckInfoRiskDAO checkInfoRiskDAO) {
		this.checkInfoRiskDAO = checkInfoRiskDAO;
	}

	/**
	 * 检查策略关联检查项表实例取得
	 *
	 * @return 检查策略关联检查项表实例
	 */
	public CheckInfoRiskTB getCheckInfoRiskTBInstance() {
		return new CheckInfoRiskTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk() {
		return checkInfoRiskDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckInfoRiskInfo searchCheckInfoRiskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckInfoRiskSearchCond cond) {
		return checkInfoRiskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk(
			CheckInfoRiskSearchCond cond) {
		return checkInfoRiskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk(
			CheckInfoRiskSearchCond cond, int start,
			int count) {
		return checkInfoRiskDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckInfoRiskInfo registCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		return checkInfoRiskDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckInfoRiskInfo updateCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCieid());
		return checkInfoRiskDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckInfoRiskByPK(Integer pk)
		throws BLException {
		checkInfoRiskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		checkInfoRiskDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CheckInfoRiskInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckInfoRiskInfo instance = checkInfoRiskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}