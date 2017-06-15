/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.dao.Timer01DAO;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;

/**
  * 概述: timer01业务逻辑实现
  * 功能描述: timer01业务逻辑实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public class Timer01BLImpl extends BaseBLImpl implements
		Timer01BL {

	/** timer01DAO接口 */
	protected Timer01DAO timer01DAO;
	
	/**
	 * timer01DAO接口设定
	 *
	 * @param timer01DAO timer01DAO接口
	 */
	public void setTimer01DAO(Timer01DAO timer01DAO) {
		this.timer01DAO = timer01DAO;
	}

	/**
	 * timer01实例取得
	 *
	 * @return timer01实例
	 */
	public Timer01TB getTimer01TBInstance() {
		return new Timer01TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Timer01Info> searchTimer01() {
		return timer01DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Timer01Info searchTimer01ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Timer01SearchCond cond) {
		return timer01DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond) {
		return timer01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond, int start,
			int count) {
		return timer01DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Timer01Info registTimer01(Timer01Info instance)
		throws BLException {
		return timer01DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Timer01Info updateTimer01(Timer01Info instance)
		throws BLException {
		checkExistInstance(instance.getUuid());
		return timer01DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTimer01ByPK(String pk)
		throws BLException {
		timer01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTimer01(Timer01Info instance)
		throws BLException {
		timer01DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Timer01Info checkExistInstance(String pk) {
		Timer01Info instance = timer01DAO.findByPK(pk);
		return instance;
	}

}