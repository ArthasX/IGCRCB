/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * ����: �����Զ�����ҵ���߼��ӿ�
  * ��������: �����Զ�����ҵ���߼��ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkBL�����޸�ΪSOC0204BL
  */
public interface SOC0204BL extends BaseBL {

	/**
	 * �����Զ�����ʵ��ȡ��
	 *
	 * @return �����Զ�����ʵ��
	 */
	public SOC0204TB getSOC0204Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0204Info> searchSOC0204();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0204Info searchSOC0204ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0204SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0204Info> searchSOC0204(
			SOC0204SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0204Info registSOC0204(SOC0204Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0204Info updateSOC0204(SOC0204Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0204ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0204(SOC0204Info instance)
		throws BLException;

}