/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM02SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM02TB;

/**
  * ����: CRM02ҵ���߼��ӿ�
  * ��������: CRM02ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM02BL extends BaseBL {

	/**
	 * CRM02ʵ��ȡ��
	 *
	 * @return CRM02ʵ��
	 */
	public CRM02TB getCRM02TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM02Info> searchCRM02();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM02Info searchCRM02ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM02Info registCRM02(CRM02Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM02Info updateCRM02(CRM02Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM02ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM02(CRM02Info instance)
		throws BLException;

}