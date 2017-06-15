/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;

/**
  * ����: �ʲ�����ϸ��ҵ���߼��ӿ�
  * ��������: �ʲ�����ϸ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0112BL extends BaseBL {

	/**
	 * �ʲ�����ϸ��ʵ��ȡ��
	 *
	 * @return �ʲ�����ϸ��ʵ��
	 */
	public SOC0112TB getEiDomainDetailTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0112Info> searchEiDomainDetail();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0112Info searchEiDomainDetailByPK(SOC0112PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0112SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0112Info registEiDomainDetail(SOC0112Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0112Info updateEiDomainDetail(SOC0112Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDetailByPK(SOC0112PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDetail(SOC0112Info instance)
		throws BLException;

}