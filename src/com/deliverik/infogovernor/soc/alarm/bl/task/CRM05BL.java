/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;

/**
  * ����: CRM05ҵ���߼��ӿ�
  * ��������: CRM05ҵ���߼��ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM05BL extends BaseBL {

	/**
	 * CRM05ʵ��ȡ��
	 *
	 * @return CRM05ʵ��
	 */
	public CRM05TB getCRM05TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM05Info> searchCRM05();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM05Info searchCRM05ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM05Info registCRM05(CRM05Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM05Info updateCRM05(CRM05Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM05ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM05(CRM05Info instance)
		throws BLException;

}