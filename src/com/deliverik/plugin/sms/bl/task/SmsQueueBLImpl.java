/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;
import com.deliverik.plugin.sms.model.dao.SmsQueueDAO;
import com.deliverik.plugin.sms.model.entity.SmsQueueTB;

/**
  * 概述: 短信队列表业务逻辑实现
  * 功能描述: 短信队列表业务逻辑实现
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public class SmsQueueBLImpl extends BaseBLImpl implements SmsQueueBL {

	/** 短信队列表DAO接口 */
	protected SmsQueueDAO smsQueueDAO;
	

	/**
	 * 短信队列表实例取得
	 *
	 * @return 短信队列表实例
	 */
	public SmsQueueTB getSmsQueueTBInstance() {
		return new SmsQueueTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo() {
		return smsQueueDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SmsQueueInfo searchSmsQueueInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SmsQueueSearchCond cond) {
		return smsQueueDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo(
			SmsQueueSearchCond cond) {
		return smsQueueDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SmsQueueInfo> searchSmsQueueInfo(
			SmsQueueSearchCond cond, int start,
			int count) {
		return smsQueueDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SmsQueueInfo registSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		return smsQueueDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SmsQueueInfo updateSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		checkExistInstance(instance.getQid());
		return smsQueueDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSmsQueueInfoByPK(Integer pk)
		throws BLException {
		smsQueueDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSmsQueueInfo(SmsQueueInfo instance)
		throws BLException {
		smsQueueDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SmsQueueInfo checkExistInstance(Integer pk)
		throws BLException {
		SmsQueueInfo instance = smsQueueDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public SmsQueueDAO getSmsQueueDAO() {
		return smsQueueDAO;
	}

	public void setSmsQueueDAO(SmsQueueDAO smsQueueDAO) {
		this.smsQueueDAO = smsQueueDAO;
	}

}