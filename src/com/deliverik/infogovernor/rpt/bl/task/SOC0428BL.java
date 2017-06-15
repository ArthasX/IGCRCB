/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;

/**
  * ����: ҵ��ϵͳ��ͼҵ���߼��ӿ�
  * ��������: ҵ��ϵͳ��ͼҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ������BusinessCapacityRealTimeVWBL������ΪSOC0428BL
  * 					����������BusinessCapacityRealTimeVW��ΪSOC0428
  */
public interface SOC0428BL extends BaseBL {


	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0428Info> searchSOC0428();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0428SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond, int start,
			int count);
	/**
	 * ��������
	 */
	public SOC0428Info searchSOC0428ByPK(Integer pk);

}