/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0202SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0202TB;

/**
  * ����: ���ӱ���ҵ���߼��ӿ�
  * ��������: ���ӱ���ҵ���߼��ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportAnnexationBL������ΪSOC0202BL
  */
public interface SOC0202BL extends BaseBL {

	/**
	 * ���ӱ���ʵ��ȡ��
	 *
	 * @return ���ӱ���ʵ��
	 */
	public SOC0202TB getSOC0202Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0202Info> searchSOC0202();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0202Info searchSOC0202ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0202SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0202Info> searchSOC0202(
			SOC0202SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0202Info> searchSOC0202(
			SOC0202SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0202Info registSOC0202(SOC0202Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0202Info updateSOC0202(SOC0202Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0202ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0202(SOC0202Info instance)
		throws BLException;

}