/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0102TB;

/**
  * ����: ����ʲ���ҵ���߼��ӿ�
  * ��������: ����ʲ���ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0102BL extends BaseBL {

	/**
	 * ����ʲ���ʵ��ȡ��
	 *
	 * @return ����ʲ���ʵ��
	 */
	public SOC0102TB getSOC0102Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0102Info> searchSOC0102();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0102Info searchSOC0102ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0102SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0102Info registSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0102Info updateSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0102ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0102(SOC0102Info instance)
		throws BLException;

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0102();

}