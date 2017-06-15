/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0424TB;

/**
  * ����: �������ͱ�ҵ���߼��ӿ�
  * ��������: �������ͱ�ҵ���߼��ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeBL�����޸�ΪSOC0424BL
  */
public interface SOC0424BL extends BaseBL {

	/**
	 * �������ͱ�ʵ��ȡ��
	 *
	 * @return �������ͱ�ʵ��
	 */
	public SOC0424TB getSOC0424Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0424Info> searchSOC0424();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0424SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0424Info> searchSOC0424(
			SOC0424SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0424Info registSOC0424(SOC0424Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0424Info updateSOC0424(SOC0424Info instance)
		throws BLException;


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0424(SOC0424Info instance)
		throws BLException;

}