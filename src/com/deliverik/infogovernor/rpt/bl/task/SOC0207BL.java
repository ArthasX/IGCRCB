/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * ����: ����ģ��ҵ���߼��ӿ�
  * ��������: ����ģ��ҵ���߼��ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateBL�����޸�ΪSOC0207BL
  */
public interface SOC0207BL extends BaseBL {

	/**
	 * ����ģ��ʵ��ȡ��
	 *
	 * @return ����ģ��ʵ��
	 */
	public SOC0207TB getSOC0207Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0207Info> searchSOC0207();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0207Info searchSOC0207ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0207SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0207Info registSOC0207(SOC0207Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0207Info updateSOC0207(SOC0207Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0207ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0207(SOC0207Info instance)
		throws BLException;

}