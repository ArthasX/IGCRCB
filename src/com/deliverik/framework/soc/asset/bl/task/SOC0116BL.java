/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * ����: EiWaitTaskTempҵ���߼��ӿ�
  * ��������: EiWaitTaskTempҵ���߼��ӿ�
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
public interface SOC0116BL extends BaseBL {

	/**
	 * EiWaitTaskTempʵ��ȡ��
	 *
	 * @return EiWaitTaskTempʵ��
	 */
	public SOC0116TB getEiWaitTaskTempTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0116Info searchEiWaitTaskTempByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0116SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0116Info registEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0116Info updateEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiWaitTaskTempByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiWaitTaskTemp(SOC0116Info instance)
		throws BLException;

}