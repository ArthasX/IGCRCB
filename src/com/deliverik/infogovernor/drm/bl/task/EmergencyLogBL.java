/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * ������Ӧ����־��Ϣ��ҵ���߼��ӿ�
 * ����������Ӧ����־��Ϣ��ҵ���߼��ӿ�
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public interface EmergencyLogBL extends BaseBL {
	/**
	 * Ӧ����Ա��λ��ʵ��ȡ��
	 * 
	 * @return Ӧ����Ա��λ��ʵ��
	 */
	public EmergencyLogTB getEmergencyLogTBInstance();
	
	/**
	 * ȫ����������
	 * 
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLog() throws BLException;
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException
	 */
	public int getSearchCount(EmergencyLogSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCond(EmergencyLogSearchCond cond) throws BLException;

	/**
	 * ������������(��ҳ��ѯ)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCondForPage(EmergencyLogSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * ����Ӧ����Ա��λ��Ϣ����
	 * 
	 * @param Ӧ����Ա��λ��Ϣ
	 * @return Ӧ����Ա��λ��Ϣ
	 * @throws BLException
	 */
	public EmergencyLogInfo registEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;

	/**
	 * ɾ��Ӧ����Ա��λ��Ϣ����
	 * 
	 * @param entityItem Ӧ����Ա��λ��Ϣ
	 * @throws BLException
	 */
	public void deleteEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;
	
	/**
	 * ����Ӧ����Ա��λ��Ϣ����ɾ��Ӧ����Ա��λ��Ϣ����
	 * 
	 * @param ecid ɾ��Ӧ����Ա��λ��Ϣ������
	 * @throws BLException
	 */
	public void deleteEmergencyLogByPK(Integer ecid) throws BLException;

	/**
	 * ���Ӧ����Ա��λ��Ϣ����
	 * 
	 * @param entityItem Ӧ����Ա��λ��Ϣ
	 * @return Ӧ����Ա��λ��Ϣ
	 * @throws BLException
	 */
	public EmergencyLogInfo updateEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException;
	
	/**
	 * Ӧ����Ա��λ��Ϣ���ڼ��
	 * 
	 * @param ecid Ӧ����Ա��λ��Ϣ������
	 * @throws BLException 
	 */
	public EmergencyLogInfo checkExistEmergencyLog(Integer ecid) throws BLException;
	
	/**
	 * ��ֹ���̲�ѯ��������ʱ��
	 * 
	 * @param prid Ӧ����Ա��λ��Ϣ������
	 * @throws BLException 
	 */
	public EmergencyLogInfo findMaxTimeEmergencyLog(String prid) throws BLException;
}