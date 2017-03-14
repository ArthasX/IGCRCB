/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;

/**
  * ����: CRM04ҵ���߼��ӿ�
  * ��������: CRM04ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM04BL extends BaseBL {

	/**
	 * CRM04ʵ��ȡ��
	 *
	 * @return CRM04ʵ��
	 */
	public CRM04TB getCRM04TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM04Info> searchCRM04();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM04Info searchCRM04ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM04Info registCRM04(CRM04Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM04Info updateCRM04(CRM04Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM04ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM04(CRM04Info instance)
		throws BLException;

}