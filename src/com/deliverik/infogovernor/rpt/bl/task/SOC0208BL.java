/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208PK;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;

/**
  * ����: �¼��������Ч��ҵ���߼��ӿ�
  * ��������: �¼��������Ч��ҵ���߼��ӿ�
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/10 ��ServeEfficiencyBL�����޸�ΪSOC0208BL
  */
public interface SOC0208BL extends BaseBL {

	/**
	 * �¼��������Ч��ʵ��ȡ��
	 *
	 * @return �¼��������Ч��ʵ��
	 */
	public SOC0208TB getSOC0208Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0208Info> searchSOC0208();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0208Info searchSOC0208ByPK(SOC0208PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0208SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0208Info> searchSOC0208(
			SOC0208SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0208Info registSOC0208(SOC0208Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0208Info updateSOC0208(SOC0208Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0208ByPK(SOC0208PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0208(SOC0208Info instance)
		throws BLException;

}