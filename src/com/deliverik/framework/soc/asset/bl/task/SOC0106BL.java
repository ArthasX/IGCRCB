/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0106Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0106SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0106TB;

/**
  * ����: SOC0106ҵ���߼��ӿ�
  * ��������: SOC0106ҵ���߼��ӿ�
  * ������¼: 2012/07/31
  * �޸ļ�¼: 
  */
public interface SOC0106BL extends BaseBL {

	/**
	 * SOC0106ʵ��ȡ��
	 *
	 * @return SOC0106ʵ��
	 */
	public SOC0106TB getSOC0106Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0106Info> searchSOC0106();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0106Info searchSOC0106ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0106SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0106Info registSOC0106(SOC0106Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0106Info updateSOC0106(SOC0106Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0106ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0106(SOC0106Info instance)
		throws BLException;

}