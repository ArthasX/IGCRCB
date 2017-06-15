/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;
import com.deliverik.infogovernor.rdp.model.dao.RealtimedetailDAO;
import com.deliverik.infogovernor.rdp.model.entity.RealtimedetailTB;

/**
  * 概述: 日志信息业务逻辑实现
  * 功能描述: 日志信息业务逻辑实现
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
public class RealtimedetailBLImpl extends BaseBLImpl implements
		RealtimedetailBL {

	/** 日志信息DAO接口 */
	protected RealtimedetailDAO realtimedetailDAO;
	
	/**
	 * 日志信息DAO接口设定
	 *
	 * @param realtimedetailDAO 日志信息DAO接口
	 */
	public void setRealtimedetailDAO(RealtimedetailDAO realtimedetailDAO) {
		this.realtimedetailDAO = realtimedetailDAO;
	}

	/**
	 * 日志信息实例取得
	 *
	 * @return 日志信息实例
	 */
	public RealtimedetailTB getRealtimedetailTBInstance() {
		return new RealtimedetailTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RealtimedetailInfo> searchRealtimedetail() {
		return realtimedetailDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RealtimedetailInfo searchRealtimedetailByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RealtimedetailSearchCond cond) {
		return realtimedetailDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond) {
		return realtimedetailDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond, int start,
			int count) {
		return realtimedetailDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RealtimedetailInfo registRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		return realtimedetailDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RealtimedetailInfo updateRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return realtimedetailDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRealtimedetailByPK(Integer pk)
		throws BLException {
		realtimedetailDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		realtimedetailDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RealtimedetailInfo checkExistInstance(Integer pk)
		throws BLException {
		RealtimedetailInfo instance = realtimedetailDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}