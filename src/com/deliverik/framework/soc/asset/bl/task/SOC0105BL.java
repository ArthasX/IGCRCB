/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;

/**
  * ����: ��ƴ���������ҵ���߼��ӿ�
  * ��������: ��ƴ���������ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0105BL extends BaseBL {

	/**
	 * ��ƴ���������ʵ��ȡ��
	 *
	 * @return ��ƴ���������ʵ��
	 */
	public SOC0105TB getSOC0105Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0105Info> searchSOC0105();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0105Info searchSOC0105ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0105SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0105Info registSOC0105(SOC0105Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0105Info updateSOC0105(SOC0105Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0105ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0105(SOC0105Info instance)
		throws BLException;

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0105All() throws BLException;
}