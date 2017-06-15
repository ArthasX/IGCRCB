/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0409TB;

/**
  * ����: ����pvʵʱ��ҵ���߼��ӿ�
  * ��������: ����pvʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeBL������ΪSOC0409BL
  */
public interface SOC0409BL extends BaseBL {

	/**
	 * ����pvʵʱ��ʵ��ȡ��
	 *
	 * @return ����pvʵʱ��ʵ��
	 */
	public SOC0409TB getSOC0409Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0409Info> searchSOC0409();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0409Info searchSOC0409ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0409SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0409Info registSOC0409(SOC0409Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0409Info updateSOC0409(SOC0409Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0409ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0409(SOC0409Info instance)
		throws BLException;

}