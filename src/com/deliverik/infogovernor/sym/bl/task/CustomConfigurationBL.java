/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;

/**
  * ����: �Զ����������ñ�ҵ���߼��ӿ�
  * ��������: �Զ����������ñ�ҵ���߼��ӿ�
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
public interface CustomConfigurationBL extends BaseBL {

	/**
	 * �Զ����������ñ�ʵ��ȡ��
	 *
	 * @return �Զ����������ñ�ʵ��
	 */
	public CustomConfigurationTB getCustomConfigurationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CustomConfigurationInfo searchCustomConfigurationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CustomConfigurationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CustomConfigurationInfo> searchCustomConfiguration(
			CustomConfigurationSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CustomConfigurationInfo registCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CustomConfigurationInfo updateCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCustomConfigurationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCustomConfiguration(CustomConfigurationInfo instance)
		throws BLException;

}