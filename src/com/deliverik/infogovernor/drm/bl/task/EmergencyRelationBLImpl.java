/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EmergencyRelationDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * ���̹�ϵҵ���߼�ʵ��
 * 
 */
public class EmergencyRelationBLImpl extends BaseBLImpl implements EmergencyRelationBL{
	
	/** �Ƚ�����������ʱ��*/
	protected static final ProcessRecordRelationComparator processRecordRelationComparator = new ProcessRecordRelationComparator();
	
	
	/** EmergencyRelation DAO */
	protected EmergencyRelationDAO emergencyRelationDao;
	
	public void setEmergencyRelationDao(
			EmergencyRelationDAO EmergencyRelationDao) {
		this.emergencyRelationDao = EmergencyRelationDao;
	}
	
	/**
	 * ��ȡ���̹�ϵʵ��
	 * @return EmergencyRelationTB
	 */
	public EmergencyRelationTB getEmergencyRelationTBInstance(){
		return new EmergencyRelationTB();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EmergencyRelationSearchCond cond){
		
		return emergencyRelationDao.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param erid ���̹�ϵID
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo searchEmergencyRelationInfoByKey(Integer erid) throws BLException{
		
		return checkExistProcessRecordRelation(erid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̹�ϵ��Ϣ
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfoAll(){
		
		return emergencyRelationDao.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfo(EmergencyRelationSearchCond cond, int start, int count){
		
		return emergencyRelationDao.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param EmergencyRelationInfo ��¼����
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo registEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException{
		
		return emergencyRelationDao.save(emergencyRelationInfo);
	}

	/**
	 * ɾ������
	 * 
	 * @param erid ���̹�ϵID
	 * @return
	 */
	public void deleteEmergencyRelationInfo(Integer erid) throws BLException{
		
		EmergencyRelationInfo processRecordRelation = checkExistProcessRecordRelation(erid);
		
		emergencyRelationDao.delete(processRecordRelation);
	}

	/**
	 * �������
	 * 
	 * @param EmergencyRelationInfo �������
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo updateEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException{
		
		checkExistProcessRecordRelation(emergencyRelationInfo.getErid());
		return emergencyRelationDao.save(emergencyRelationInfo);
	}

	/**
	 * ���̹�ϵ���ڼ��
	 * 
	 * @param erid ���̹�ϵID
	 * @return ���̹�ϵ
	 * @throws BLException 
	 */
	protected EmergencyRelationInfo checkExistProcessRecordRelation(Integer erid) throws BLException{
		EmergencyRelationInfo info = emergencyRelationDao.findByPK(erid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̹�ϵ����");
		}
		return info;
	}
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param emergencyRelationInfoList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<EmergencyRelationInfo> emergencyRelationInfoList) {
		if(emergencyRelationInfoList != null && emergencyRelationInfoList.size() > 0) {
			Collections.sort(emergencyRelationInfoList, processRecordRelationComparator);
		}
	}
	
}

	/**
	 * �Ƚ�����������ʱ�䣨����
	 * 
	 * */
	class ProcessRecordRelationComparator implements Comparator<EmergencyRelationInfo> {
	
		public int compare(EmergencyRelationInfo arg0, EmergencyRelationInfo arg1) {
			int flag = arg0.getErid().compareTo(arg1.getErid());
			return flag;
		}
	
	}
