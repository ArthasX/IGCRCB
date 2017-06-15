/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.EmergencyLogDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;

/**
 * ������Ӧ����־��Ϣ��ҵ���߼�ʵ��
 * ����������Ӧ����־��Ϣ��ҵ���߼�ʵ��
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public class EmergencyLogBLImpl extends BaseBLImpl implements EmergencyLogBL {
	/**Ӧ����־��Ϣ��DAO�ӿ�*/
	protected EmergencyLogDAO emergencyLogDAO;
	
	/**
	 * Ӧ����־��Ϣ��DAO�趨
	 * @param emergencyLogDAO
	 */
	public void setEmergencyLogDAO(EmergencyLogDAO emergencyLogDAO) {
		this.emergencyLogDAO = emergencyLogDAO;
	}
	
	/**
	 * Ӧ����־��Ϣ�����ʵ��ȡ�� 
	 * @return Ӧ����־��Ϣ�����ʵ��ȡ��
	 */
	public EmergencyLogTB getEmergencyLogTBInstance() {
		return new EmergencyLogTB();
	}
	
	/**
	 * ȫ����������
	 * 
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLog() throws BLException {
		return emergencyLogDAO.findAll();
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException
	 */
	public int getSearchCount(EmergencyLogSearchCond cond) throws BLException {
		return emergencyLogDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCond(EmergencyLogSearchCond cond) throws BLException {
		return emergencyLogDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������(��ҳ��ѯ)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<EmergencyLogInfo> searchEmergencyLogByCondForPage(EmergencyLogSearchCond cond, int start, int count) throws BLException {
		return emergencyLogDAO.findByCond(cond, start, count);
	}
	
	/**
	 * ����Ӧ����־��Ϣ��Ϣ����
	 * 
	 * @param Ӧ����־��Ϣ��Ϣ
	 * @return Ӧ����־��Ϣ��Ϣ
	 * @throws BLException
	 */
	public EmergencyLogInfo registEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException {
		EmergencyLogInfo result = emergencyLogDAO.save(emergencyLog);
		return result;
	}
	
	/**
	 * ɾ��Ӧ����־��Ϣ��Ϣ����
	 * 
	 * @param emergencyLog Ӧ����־��Ϣ��Ϣ
	 * @throws BLException
	 */
	public void deleteEmergencyLog(EmergencyLogInfo emergencyLog)throws BLException {
		checkExistEmergencyLog(emergencyLog.getElid());
		emergencyLogDAO.delete(emergencyLog);
	}
	
	/**
	 * ����Ӧ����־��Ϣ��Ϣ����ɾ��Ӧ����Ա��λ��Ϣ����
	 * 
	 * @param elid ɾ��Ӧ����־��Ϣ��Ϣ������
	 * @throws BLException
	 */
	public void deleteEmergencyLogByPK(Integer elid) throws BLException {
		EmergencyLogInfo emergencyLogInfo = checkExistEmergencyLog(elid);
		emergencyLogDAO.delete(emergencyLogInfo);
	}
	
	/**
	 * ���Ӧ����־��Ϣ��Ϣ����
	 * 
	 * @param emergencyLog Ӧ����־��Ϣ
	 * @return Ӧ����־��Ϣ
	 * @throws BLException
	 */
	public EmergencyLogInfo updateEmergencyLog(EmergencyLogInfo emergencyLog) throws BLException {
		checkExistEmergencyLog(emergencyLog.getElid());
		EmergencyLogInfo result = emergencyLogDAO.save(emergencyLog);
		return result;
	}
	
	/**
	 *Ӧ����־��Ϣ��Ϣ���ڼ��
	 * 
	 * @param elid Ӧ����־��Ϣ��Ϣ������
	 * @throws BLException 
	 */
	public EmergencyLogInfo checkExistEmergencyLog(Integer elid) throws BLException {
		EmergencyLogInfo info = emergencyLogDAO.findByPK(elid);
		if(info == null) {
			throw new BLException("IGCO10000.E004","Ӧ����־��Ϣ");
		}
		return info;
	}
	/**
	 * ��ֹ���̲�ѯ��������ʱ��
	 * 
	 * @param elprid������ʵ��ID
	 * @throws BLException 
	 */
	public EmergencyLogInfo findMaxTimeEmergencyLog(String elprid)
			throws BLException {
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		//ͨ���¼����������в鴦����
		String[] desc = {"ellidtime"};
		elCond.setDesc(desc);
		elCond.setElprid_eq(elprid);
		List<EmergencyLogInfo> elList = emergencyLogDAO.findByCond(elCond, 0, 0);
		if(elList!= null&&elList.size()>0){
			//ȡ���ʱ���ʵ��
			EmergencyLogInfo elInfo = elList.get(0);	
			return elInfo;
		}
		return null;
	}
}