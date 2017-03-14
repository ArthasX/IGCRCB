/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EventssDAO;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;

/**
  * 概述: 事件级别表业务逻辑实现
  * 功能描述: 事件级别表业务逻辑实现
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
public class EventssBLImpl extends BaseBLImpl implements
		EventssBL {

	/** 事件级别表DAO接口 */
	protected EventssDAO eventssDAO;
	
	/**
	 * 事件级别表DAO接口设定
	 *
	 * @param eventssDAO 事件级别表DAO接口
	 */
	public void setEventssDAO(EventssDAO eventssDAO) {
		this.eventssDAO = eventssDAO;
	}

	/**
	 * 事件级别表实例取得
	 *
	 * @return 事件级别表实例
	 */
	public EventssTB getEventssTBInstance() {
		return new EventssTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EventssInfo> searchEventss() {
		return eventssDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EventssInfo searchEventssByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EventssSearchCond cond) {
		return eventssDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EventssInfo> searchEventss(
			EventssSearchCond cond) {
		return eventssDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EventssInfo> searchEventss(
			EventssSearchCond cond, int start,
			int count) {
		return eventssDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EventssInfo registEventss(EventssInfo instance)
		throws BLException {
		return eventssDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EventssInfo updateEventss(EventssInfo instance)
		throws BLException {
		checkExistInstance(instance.getEventid());
		return eventssDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEventssByPK(Integer pk)
		throws BLException {
		eventssDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEventss(EventssInfo instance)
		throws BLException {
		eventssDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public EventssInfo checkExistInstance(Integer pk)
		throws BLException {
		EventssInfo instance = eventssDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}