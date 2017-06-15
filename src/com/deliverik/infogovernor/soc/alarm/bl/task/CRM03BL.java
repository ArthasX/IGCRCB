/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM03SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM03TB;

/**
  * ����: CRM03ҵ���߼��ӿ�
  * ��������: CRM03ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM03BL extends BaseBL {

	/**
	 * CRM03ʵ��ȡ��
	 *
	 * @return CRM03ʵ��
	 */
	public CRM03TB getCRM03TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM03Info> searchCRM03();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM03Info registCRM03(CRM03Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM03Info updateCRM03(CRM03Info instance)
		throws BLException;


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM03(CRM03Info instance)
		throws BLException;

}