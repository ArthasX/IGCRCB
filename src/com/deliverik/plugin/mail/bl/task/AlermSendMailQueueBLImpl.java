/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.mail.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;
import com.deliverik.plugin.mail.model.dao.AlermSendMailQueueDAO;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
  * 概述: 邮件队列表业务逻辑实现
  * 功能描述: 邮件队列表业务逻辑实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class AlermSendMailQueueBLImpl extends BaseBLImpl implements AlermSendMailQueueBL {

	/** 邮件队列表DAO接口 */
	protected AlermSendMailQueueDAO alermSendMailQueueDAO;
	

	/**
	 * 短信队列表实例取得
	 *
	 * @return 短信队列表实例
	 */
	public AlermSendMailQueueTB getAlermSendMailQueueTBInstance() {
		return new AlermSendMailQueueTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo() {
		return alermSendMailQueueDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AlermSendMailQueueInfo searchAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AlermSendMailQueueSearchCond cond) {
		return alermSendMailQueueDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo(
			AlermSendMailQueueSearchCond cond) {
		return alermSendMailQueueDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AlermSendMailQueueInfo> searchAlermSendMailQueueInfo(
			AlermSendMailQueueSearchCond cond, int start,
			int count) {
		return alermSendMailQueueDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AlermSendMailQueueInfo registAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		return alermSendMailQueueDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AlermSendMailQueueInfo updateAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getMid());
		return alermSendMailQueueDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAlermSendMailQueueInfoByPK(Integer pk)
		throws BLException {
		alermSendMailQueueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAlermSendMailQueueInfo(AlermSendMailQueueInfo instance)
		throws BLException {
		alermSendMailQueueDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AlermSendMailQueueInfo checkExistInstance(Integer pk)
		throws BLException {
		AlermSendMailQueueInfo instance = alermSendMailQueueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public AlermSendMailQueueDAO getAlermSendMailQueueDAO() {
		return alermSendMailQueueDAO;
	}

	public void setAlermSendMailQueueDAO(AlermSendMailQueueDAO alermSendMailQueueDAO) {
		this.alermSendMailQueueDAO = alermSendMailQueueDAO;
	}

}