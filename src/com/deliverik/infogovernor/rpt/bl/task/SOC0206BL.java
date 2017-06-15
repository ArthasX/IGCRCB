/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;

/**
  * ����: ģ��ӳ���ҵ���߼��ӿ�
  * ��������: ģ��ӳ���ҵ���߼��ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateMappingBL�����޸�ΪSOC0206BL
  */
public interface SOC0206BL extends BaseBL {

	/**
	 * ģ��ӳ���ʵ��ȡ��
	 *
	 * @return ģ��ӳ���ʵ��
	 */
	public SOC0206TB getSOC0206Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0206Info> searchSOC0206();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0206Info searchSOC0206ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0206SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0206Info registSOC0206(SOC0206Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0206Info updateSOC0206(SOC0206Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0206ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0206(SOC0206Info instance)
		throws BLException;
	/**����IDɾ��*/
	public Integer deleteByRtId(Integer rtId);
}