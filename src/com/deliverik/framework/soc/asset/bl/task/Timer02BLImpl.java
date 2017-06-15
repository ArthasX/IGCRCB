/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;
import com.deliverik.framework.soc.asset.model.dao.Timer02DAO;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;

/**
  * 概述: timer02业务逻辑实现
  * 功能描述: timer02业务逻辑实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public class Timer02BLImpl extends BaseBLImpl implements
		Timer02BL {

	/** timer02DAO接口 */
	protected Timer02DAO timer02DAO;
	
	/**
	 * timer02DAO接口设定
	 *
	 * @param timer02DAO timer02DAO接口
	 */
	public void setTimer02DAO(Timer02DAO timer02DAO) {
		this.timer02DAO = timer02DAO;
	}

	/**
	 * timer02实例取得
	 *
	 * @return timer02实例
	 */
	public Timer02TB getTimer02TBInstance() {
		return new Timer02TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Timer02Info> searchTimer02() {
		return timer02DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Timer02Info searchTimer02ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Timer02SearchCond cond) {
		return timer02DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond) {
		return timer02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond, int start,
			int count) {
		return timer02DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Timer02Info registTimer02(Timer02Info instance)
		throws BLException {
		return timer02DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Timer02Info updateTimer02(Timer02Info instance)
		throws BLException {
		checkExistInstance(instance.getUuid());
		return timer02DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTimer02ByPK(String pk)
		throws BLException {
		timer02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTimer02(Timer02Info instance)
		throws BLException {
		timer02DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Timer02Info checkExistInstance(String pk)
		throws BLException {
		Timer02Info instance = timer02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}