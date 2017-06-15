/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EmergencyResourceDAO;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;

/**
  * ����: EmergencyResourceҵ���߼�ʵ��
  * ��������: EmergencyResourceҵ���߼�ʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class EmergencyResourceBLImpl extends BaseBLImpl implements
		EmergencyResourceBL {

	/** EmergencyResourceDAO�ӿ� */
	protected EmergencyResourceDAO emergencyResourceDAO;
	
	/**
	 * EmergencyResourceDAO�ӿ��趨
	 *
	 * @param emergencyResourceDAO EmergencyResourceDAO�ӿ�
	 */
	public void setEmergencyResourceDAO(EmergencyResourceDAO emergencyResourceDAO) {
		this.emergencyResourceDAO = emergencyResourceDAO;
	}

	/**
	 * EmergencyResourceʵ��ȡ��
	 *
	 * @return EmergencyResourceʵ��
	 */
	public EmergencyResourceTB getEmergencyResourceTBInstance() {
		return new EmergencyResourceTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource() {
		return emergencyResourceDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmergencyResourceInfo searchEmergencyResourceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EmergencyResourceSearchCond cond) {
		return emergencyResourceDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EmergencyResourceInfo> searchEmergencyResource(
			EmergencyResourceSearchCond cond) {
		return emergencyResourceDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return emergencyResourceDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EmergencyResourceInfo registEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		return emergencyResourceDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EmergencyResourceInfo updateEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		checkExistInstance(instance.getErid());
		return emergencyResourceDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEmergencyResourceByPK(Integer pk)
		throws BLException {
		emergencyResourceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEmergencyResource(EmergencyResourceInfo instance)
		throws BLException {
		emergencyResourceDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EmergencyResourceInfo checkExistInstance(Integer pk)
		throws BLException {
		EmergencyResourceInfo instance = emergencyResourceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}