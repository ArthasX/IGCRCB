/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;

/**
  * ����: ��������ҵ���߼��ӿ�
  * ��������: ��������ҵ���߼��ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageBL�����޸�ΪSOC0205BL
  */
public interface SOC0205BL extends BaseBL {

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public SOC0205TB getSOC0205Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0205Info> searchSOC0205();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0205Info searchSOC0205ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0205SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0205Info> searchSOC0205(
			SOC0205SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0205Info registSOC0205(SOC0205Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0205Info updateSOC0205(SOC0205Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0205ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0205(SOC0205Info instance)
		throws BLException;

}