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
	 * �־û�����
	 * @param SMSLog ʵ��
	 */
	public abstract SMSLog saveSMSLog(SMSLog smsLog) throws BLException;

	/**
	 * ȫ������
	 * @return ���������
	 */
	public abstract List<SMSLog> findAllSMSLog() throws BLException;

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(SMSLogSearchCond cond)
			throws BLException;

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public abstract List<SMSLog> findByCond(SMSLogSearchCond cond, int start,
			int count) ;

	/**
     * ɾ������
	 * @param ɾ���б�
     */
	public void delSMSLog(List<SMSLog> smsLogList);
}