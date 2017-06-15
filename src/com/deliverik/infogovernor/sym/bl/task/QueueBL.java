/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;

/**
  * 概述: 短信队列表业务逻辑接口
  * 功能描述: 短信队列表业务逻辑接口
  * 创建记录: 2012/11/13
  * 修改记录: 
  */
public interface QueueBL extends BaseBL {

	/**
	 * 短信队列表实例取得
	 *
	 * @return 短信队列表实例
	 */
	public QueueTB getQueueTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<QueueInfo> searchQueueInfo();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public QueueInfo searchQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(QueueSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<QueueInfo> searchQueueInfo(
			QueueSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public QueueInfo registQueueInfo(QueueInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public QueueInfo updateQueueInfo(QueueInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteQueueInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteQueueInfo(QueueInfo instance)
		throws BLException;

}