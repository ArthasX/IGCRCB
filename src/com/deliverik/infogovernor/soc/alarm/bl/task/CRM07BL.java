/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * ����: CRM07ҵ���߼��ӿ�
  * ��������: CRM07ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM07BL extends BaseBL {

	/**
	 * CRM07ʵ��ȡ��
	 *
	 * @return CRM07ʵ��
	 */
	public CRM07TB getCRM07TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM07Info> searchCRM07();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM07Info searchCRM07ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM07Info registCRM07(CRM07Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM07Info updateCRM07(CRM07Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM07ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM07(CRM07Info instance)
		throws BLException;

}