/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;
import com.deliverik.infogovernor.sym.model.dao.SMSLogDAO;
/**
 * ����:���ż�¼BLʵ����
 *����������1.�־û�����
 * 			2.ȫ������
 * 			3.���������������ȡ��
 * 			4.������������
 * ������¼��zhaojun@deliverik.com    2010/12/20
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
     * �־û�����
     * @param SMSLog ʵ��
     */
	public SMSLog saveSMSLog(SMSLog smsLog) throws BLException{
		return smslogDAO.save(smsLog);
	}
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<SMSLog> findAllSMSLog() throws BLException{
		return smslogDAO.findAll();
	}
	
	/**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(SMSLogSearchCond cond) throws BLException{
		return smslogDAO.getSearchCount(cond);
	}
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<SMSLog> findByCond(SMSLogSearchCond cond, int start, int count) {
		return smslogDAO.findByCond(cond, start, count);
	}

	/**
     * ɾ������
	 * @param ɾ���б�
     */
	public void delSMSLog(List<SMSLog> smsLogList){
		smslogDAO.delete(smsLogList);
	}
}
