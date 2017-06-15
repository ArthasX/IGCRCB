/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;
import com.deliverik.infogovernor.sym.model.dao.SMSLogDAO;
/**
 * 概述:短信记录BL实现类
 *功能描述：1.持久化处理
 * 			2.全件检索
 * 			3.条件检索结果件数取得
 * 			4.条件检索处理
 * 创建记录：zhaojun@deliverik.com    2010/12/20
 */
public class SMSLogBLImpl extends BaseBLImpl implements SMSLogBL {
	private SMSLogDAO smslogDAO;
	public SMSLogDAO getSmslogDAO() {
		return smslogDAO;
	}

	public void setSmslogDAO(SMSLogDAO smslogDAO) {
		this.smslogDAO = smslogDAO;
	}
	
	/**
     * 持久化处理
     * @param SMSLog 实体
     */
	public SMSLog saveSMSLog(SMSLog smsLog) throws BLException{
		return smslogDAO.save(smsLog);
	}
	
	/**
     * 全件检索
     * @return 检索结果集
     */
	public List<SMSLog> findAllSMSLog() throws BLException{
		return smslogDAO.findAll();
	}
	
	/**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
	public int getSearchCount(SMSLogSearchCond cond) throws BLException{
		return smslogDAO.getSearchCount(cond);
	}
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	public List<SMSLog> findByCond(SMSLogSearchCond cond, int start, int count) {
		return smslogDAO.findByCond(cond, start, count);
	}

	/**
     * 删除处理
	 * @param 删除列表
     */
	public void delSMSLog(List<SMSLog> smsLogList){
		smslogDAO.delete(smsLogList);
	}
}
