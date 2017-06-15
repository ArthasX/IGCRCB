/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;
import com.deliverik.infogovernor.sym.model.dao.QueueDAO;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;

/**
  * 概述: 短信队列表业务逻辑实现
  * 功能描述: 短信队列表业务逻辑实现
  * 创建记录: 2012/11/13
  * 修改记录: 
  */
public class QueueBLImpl extends BaseBLImpl implements
		QueueBL {

	/** 短信队列表DAO接口 */
	protected QueueDAO queueDAO;
	
	/**
	 * 短信队列表DAO接口设定
	 *
	 * @param queueDAO 短信队列表DAO接口
	 */
	public void setQueueDAO(QueueDAO queueDAO) {
		this.queueDAO = queueDAO;
	}

	/**
	 * 短信队列表实例取得
	 *
	 * @return 短信队列表实例
	 */
	public QueueTB getQueueTBInstance() {
		return new QueueTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<QueueInfo> searchQueueInfo() {
		return queueDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public QueueInfo searchQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(QueueSearchCond cond) {
		return queueDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond) {
		return queueDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond, int start,
			int count) {
		return queueDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public QueueInfo registQueueInfo(QueueInfo instance)
		throws BLException {
		return queueDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public QueueInfo updateQueueInfo(QueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getQid());
		return queueDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteQueueInfoByPK(Integer pk)
		throws BLException {
		queueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteQueueInfo(QueueInfo instance)
		throws BLException {
		queueDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public QueueInfo checkExistInstance(Integer pk)
		throws BLException {
		QueueInfo instance = queueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}