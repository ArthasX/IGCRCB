/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * ���̹�ϵҵ���߼��ӿ�
 * 
 */
public interface EmergencyRelationBL extends BaseBL{
	
	/**
	 * ��ȡ���̹�ϵʵ��
	 * @return EmergencyRelationTB
	 */
	public EmergencyRelationTB getEmergencyRelationTBInstance();
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EmergencyRelationSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pprid ���̹�ϵID
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo searchEmergencyRelationInfoByKey(Integer erid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̹�ϵ��Ϣ
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyRelationInfo> searchEmergencyRelationInfo(EmergencyRelationSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param EmergencyRelationInfo ��¼����
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo registEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pprid ���̹�ϵID
	 * @return
	 */
	public void deleteEmergencyRelationInfo(Integer pprid) throws BLException;

	/**
	 * �������
	 * 
	 * @param EmergencyRelationInfo �������
	 * @return ���̹�ϵ
	 */
	public EmergencyRelationInfo updateEmergencyRelationInfo(EmergencyRelationInfo emergencyRelationInfo) throws BLException;
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param EmergencyRelationInfoList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<EmergencyRelationInfo> emergencyRelationInfoList);
	
}
