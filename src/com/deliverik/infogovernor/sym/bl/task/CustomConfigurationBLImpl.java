/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;
import com.deliverik.infogovernor.sym.model.dao.CustomConfigurationDAO;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;

/**
  * ����: �Զ����������ñ�ҵ���߼�ʵ��
  * ��������: �Զ����������ñ�ҵ���߼�ʵ��
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
public class CustomConfigurationBLImpl extends BaseBLImpl implements
		CustomConfigurationBL {

	/** �Զ����������ñ�DAO�ӿ� */
	protected CustomConfigurationDAO customConfigurationDAO;
	
	/**
	 * �Զ����������ñ�DAO�ӿ��趨
	 *
	 * @param customConfigurationDAO �Զ����������ñ�DAO�ӿ�
	 */
	public void setCustomConfigurationDAO(CustomConfigurationDAO customConfigurationDAO) {
		this.customConfigurationDAO = customConfigurationDAO;
	}

	/**
	 * �Զ����������ñ�ʵ��ȡ��
	 *
	 * @return �Զ����������ñ�ʵ��
	 */
	public CustomConfigurationTB getCustomConfigurationTBInstance() {
		return new CustomConfigurationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration() {
		return customConfigurationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CustomConfigurationInfo searchCustomConfigurationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CustomConfigurationSearchCond cond) {
		return customConfigurationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration(
			CustomConfigurationSearchCond cond) {
		return customConfigurationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration(
			CustomConfigurationSearchCond cond, int start,
			int count) {
		return customConfigurationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CustomConfigurationInfo registCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		return customConfigurationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CustomConfigurationInfo updateCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		checkExistInstance(instance.getRfdid());
		return customConfigurationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCustomConfigurationByPK(Integer pk)
		throws BLException {
		customConfigurationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException {
		customConfigurationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CustomConfigurationInfo checkExistInstance(Integer pk)
		throws BLException {
		CustomConfigurationInfo instance = customConfigurationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}