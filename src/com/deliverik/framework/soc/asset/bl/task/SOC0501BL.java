/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0501SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0501TB;

/**
  * ����: SOC0501ҵ���߼��ӿ�
  * ��������: SOC0501ҵ���߼��ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0501BL extends BaseBL {

	/**
	 * SOC0501ʵ��ȡ��
	 *
	 * @return SOC0501ʵ��
	 */
	public SOC0501TB getSoc0501Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0501Info> searchSoc0501();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0501Info searchSoc0501ByPK(Integer id)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0501SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0501Info> searchSoc0501(
			SOC0501SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0501Info> searchSoc0501(
			SOC0501SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0501Info registSoc0501(SOC0501Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0501Info updateSoc0501(SOC0501Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSoc0501ByPK(Integer id)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSoc0501(SOC0501Info instance)
		throws BLException;

	
	public int getVWSearchCount(SOC0501SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0501Info> searchSOC0501(
			SOC0501SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}