/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0101Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0101SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0101TB;

/**
  * ����: ����ʲ����Ա�ҵ���߼��ӿ�
  * ��������: ����ʲ����Ա�ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0101BL extends BaseBL {

	/**
	 * ����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return ����ʲ����Ա�ʵ��
	 */
	public SOC0101TB getSOC0101Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0101Info> searchSOC0101();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0101Info searchSOC0101ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0101SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0101Info registSOC0101(SOC0101Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0101Info updateSOC0101(SOC0101Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0101ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0101(SOC0101Info instance)
		throws BLException;

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101ForAucmptype(Integer eiid);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0101();

}