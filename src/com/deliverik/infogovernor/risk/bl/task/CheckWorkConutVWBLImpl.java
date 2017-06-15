/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckWorkConutVWDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
  * 概述: 检查工作统计报表业务逻辑实现
  * 功能描述: 检查工作统计报表业务逻辑实现
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public class CheckWorkConutVWBLImpl extends BaseBLImpl implements
		CheckWorkConutVWBL {

	/** 检查工作统计报表DAO接口 */
	protected CheckWorkConutVWDAO checkWorkConutVWDAO;
	
	/**
	 * 检查工作统计报表DAO接口设定
	 *
	 * @param checkWorkConutVWDAO 检查工作统计报表DAO接口
	 */
	public void setCheckWorkConutVWDAO(CheckWorkConutVWDAO checkWorkConutVWDAO) {
		this.checkWorkConutVWDAO = checkWorkConutVWDAO;
	}

	/**
	 * 检查工作统计报表实例取得
	 *
	 * @return 检查工作统计报表实例
	 */
	public CheckWorkConutVW getCheckWorkConutVWTBInstance() {
		return new CheckWorkConutVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW() {
		return checkWorkConutVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckWorkConutVWInfo searchCheckWorkConutVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckWorkConutVWSearchCond cond) {
		return checkWorkConutVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond) {
		return checkWorkConutVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckWorkConutVWInfo> searchCheckWorkConutVW(
			CheckWorkConutVWSearchCond cond, int start,
			int count) {
		return checkWorkConutVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckWorkConutVWInfo registCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		return checkWorkConutVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckWorkConutVWInfo updateCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getRcid());
		return checkWorkConutVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckWorkConutVWByPK(Integer pk)
		throws BLException {
		checkWorkConutVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckWorkConutVW(CheckWorkConutVWInfo instance)
		throws BLException {
		checkWorkConutVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CheckWorkConutVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckWorkConutVWInfo instance = checkWorkConutVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}