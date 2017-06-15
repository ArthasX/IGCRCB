package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;
import com.deliverik.infogovernor.sym.model.dao.SMSLogDAO;

public interface SMSLogBL extends BaseBL{

	public abstract SMSLogDAO getSmslogDAO();

	public abstract void setSmslogDAO(SMSLogDAO smslogDAO);

	/**
	 * 持久化处理
	 * @param SMSLog 实体
	 */
	public abstract SMSLog saveSMSLog(SMSLog smsLog) throws BLException;

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public abstract List<SMSLog> findAllSMSLog() throws BLException;

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public abstract int getSearchCount(SMSLogSearchCond cond)
			throws BLException;

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public abstract List<SMSLog> findByCond(SMSLogSearchCond cond, int start,
			int count) ;

	/**
     * 删除处理
	 * @param 删除列表
     */
	public void delSMSLog(List<SMSLog> smsLogList);
}