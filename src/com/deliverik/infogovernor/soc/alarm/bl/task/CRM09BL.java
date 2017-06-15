/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;

/**
  * ����: CRM09ҵ���߼��ӿ�
  * ��������: CRM09ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM09BL extends BaseBL {

	/**
	 * CRM09ʵ��ȡ��
	 *
	 * @return CRM09ʵ��
	 */
	public CRM09TB getCRM09TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM09Info> searchCRM09();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM09Info searchCRM09ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM09SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM09Info registCRM09(CRM09Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM09Info updateCRM09(CRM09Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM09ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM09(CRM09Info instance)
		throws BLException;

}