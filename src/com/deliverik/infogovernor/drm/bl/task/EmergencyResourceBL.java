/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;

/**
  * ����: EmergencyResourceҵ���߼��ӿ�
  * ��������: EmergencyResourceҵ���߼��ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface EmergencyResourceBL extends BaseBL {

	/**
	 * EmergencyResourceʵ��ȡ��
	 *
	 * @return EmergencyResourceʵ��
	 */
	public EmergencyResourceTB getEmergencyResourceTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmergencyResourceInfo searchEmergencyResourceByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EmergencyResourceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource(
			EmergencyResourceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource(
			EmergencyResourceSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EmergencyResourceInfo registEmergencyResource(EmergencyResourceInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EmergencyResourceInfo updateEmergencyResource(EmergencyResourceInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEmergencyResourceByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEmergencyResource(EmergencyResourceInfo instance)
		throws BLException;

}