/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;

/**
  * ����: CRM06ҵ���߼��ӿ�
  * ��������: CRM06ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM06BL extends BaseBL {

	/**
	 * CRM06ʵ��ȡ��
	 *
	 * @return CRM06ʵ��
	 */
	public CRM06TB getCRM06TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM06Info> searchCRM06();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM06Info searchCRM06ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM06SearchCond cond);
	
	/**
	 * ��ͼ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchVWCount(CRM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM06Info registCRM06(CRM06Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM06Info updateCRM06(CRM06Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM06ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM06(CRM06Info instance)
		throws BLException;
	
	/**
	 * ��ͼ������������
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CRM06VWInfo> searchCRM06VW(final CRM06SearchCond cond, final int start, final int count);

	public List<String> getSearchVWByInstance(final CRM06SearchCond cond);
}