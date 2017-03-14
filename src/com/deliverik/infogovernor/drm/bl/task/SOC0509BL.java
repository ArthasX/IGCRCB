/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
  * ����: Ԥ���½���Ϣҵ���߼��ӿ�
  * ��������: Ԥ���½���Ϣҵ���߼��ӿ�
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public interface SOC0509BL extends BaseBL {

	/**
	 * Ԥ���½���Ϣʵ��ȡ��
	 *
	 * @return Ԥ���½���Ϣʵ��
	 */
	public SOC0509TB getSOC0509TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0509Info> searchSOC0509();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0509Info searchSOC0509ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0509SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0509Info registSOC0509(SOC0509Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0509Info updateSOC0509(SOC0509Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0509ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0509(SOC0509Info instance)
		throws BLException;

	public Integer getNextCorder();

}