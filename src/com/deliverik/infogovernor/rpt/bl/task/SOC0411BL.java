/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0411SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0411TB;

/**
  * ����: �洢����ʵʱ��ҵ���߼��ӿ�
  * ��������: �洢����ʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeBL������ΪSOC0411BL
  */
public interface SOC0411BL extends BaseBL {

	/**
	 * �洢����ʵʱ��ʵ��ȡ��
	 *
	 * @return �洢����ʵʱ��ʵ��
	 */
	public SOC0411TB getSOC0411Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0411Info> searchSOC0411();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0411Info searchSOC0411ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0411SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0411Info> searchSOC0411(
			SOC0411SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0411Info registSOC0411(SOC0411Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0411Info updateSOC0411(SOC0411Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0411ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0411(SOC0411Info instance)
		throws BLException;

}