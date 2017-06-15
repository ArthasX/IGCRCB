/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;

/**
  * ����: ���������ҵ���߼��ӿ�
  * ��������: ���������ҵ���߼��ӿ�
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListBL������ΪSOC0423BL
  */
public interface SOC0423BL extends BaseBL {

	/**
	 * ���������ʵ��ȡ��
	 *
	 * @return ���������ʵ��
	 */
	public SOC0423TB getSOC0423Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0423Info> searchSOC0423();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0423Info searchSOC0423ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0423SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0423Info registSOC0423(SOC0423Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0423Info updateSOC0423(SOC0423Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0423ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0423(SOC0423Info instance)
		throws BLException;

}