/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;
import com.deliverik.plugin.sms.model.dao.SendSmsLogDAO;
import com.deliverik.plugin.sms.model.entity.SendSmsLogTB;

/**
  * 概述: 短信队列表业务逻辑实现
  * 功能描述: 短信队列表业务逻辑实现
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public class SendSmsLogImpl extends BaseBLImpl implements SendSmsLogBL {

	/** 短信队列表DAO接口 */
	protected SendSmsLogDAO sendSmsLogDAO;
	


	/**
	 * 短信队列表实例取得
	 *
	 * @return 短信队列表实例
	 */
	public SendSmsLogTB getSendSmsLogTBInstance() {
		return new SendSmsLogTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo() {
		return sendSmsLogDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SendSmsLogInfo searchSendSmsLogInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SendSmsLogSearchCond cond) {
		return sendSmsLogDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(
			SendSmsLogSearchCond cond) {
		return sendSmsLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SendSmsLogInfo> searchSendSmsLogInfo(
			SendSmsLogSearchCond cond, int start,
			int count) {
		return sendSmsLogDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SendSmsLogInfo registSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		return sendSmsLogDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SendSmsLogInfo updateSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return sendSmsLogDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSendSmsLogInfoByPK(Integer pk)
		throws BLException {
		sendSmsLogDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSendSmsLogInfo(SendSmsLogInfo instance)
		throws BLException {
		sendSmsLogDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SendSmsLogInfo checkExistInstance(Integer pk)
		throws BLException {
		SendSmsLogInfo instance = sendSmsLogDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public SendSmsLogDAO getSendSmsLogDAO() {
		return sendSmsLogDAO;
	}

	public void setSendSmsLogDAO(SendSmsLogDAO sendSmsLogDAO) {
		this.sendSmsLogDAO = sendSmsLogDAO;
	}

}