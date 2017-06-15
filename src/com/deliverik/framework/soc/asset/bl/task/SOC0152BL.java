/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * ����: �ʲ���ϵ��ҵ���߼��ӿ�
  * ��������: �ʲ���ϵ��ҵ���߼��ӿ�
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public interface SOC0152BL extends BaseBL {

	/**
	 * �ʲ���ϵ��ʵ��ȡ��
	 *
	 * @return �ʲ���ϵ��ʵ��
	 */
	public SOC0152TB getSOC0152TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0152Info> searchSOC0152();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0152Info searchSOC0152ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0152SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0152Info registSOC0152(SOC0152Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0152Info updateSOC0152(SOC0152Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0152ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0152(SOC0152Info instance)
		throws BLException;

}