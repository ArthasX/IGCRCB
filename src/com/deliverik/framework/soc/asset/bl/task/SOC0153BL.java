/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0153TB;

/**
  * ����: SOC0153ҵ���߼��ӿ�
  * ��������: SOC0153ҵ���߼��ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0153BL extends BaseBL {

	/**
	 * SOC0153ʵ��ȡ��
	 *
	 * @return SOC0153ʵ��
	 */
	public SOC0153TB getSoc0153Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0153Info> searchSoc0153();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0153Info searchSoc0153ByPK(Integer id)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0153SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0153Info> searchSoc0153(
			SOC0153SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0153Info> searchSoc0153(
			SOC0153SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0153Info registSoc0153(SOC0153Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0153Info updateSoc0153(SOC0153Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSoc0153ByPK(Integer id)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSoc0153(SOC0153Info instance)
		throws BLException;

	
	public int getVWSearchCount(SOC0153SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0153Info> searchSOC0153(
			SOC0153SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}