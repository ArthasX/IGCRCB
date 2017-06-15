/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0209VW;

/**
  * ����: ������Դ��ͼҵ���߼��ӿ�
  * ��������: ������Դ��ͼҵ���߼��ӿ�
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWBL������ΪSOC0209BL
  */
public interface SOC0209BL extends BaseBL {

	/**
	 * ������Դ��ͼʵ��ȡ��
	 *
	 * @return ������Դ��ͼʵ��
	 */
	public SOC0209VW getSOC0209Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0209Info> searchSOC0209();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0209Info searchSOC0209ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0209SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0209Info registSOC0209(SOC0209Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0209Info updateSOC0209(SOC0209Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0209ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0209(SOC0209Info instance)
		throws BLException;

}