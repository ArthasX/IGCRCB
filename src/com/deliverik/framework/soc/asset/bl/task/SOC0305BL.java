/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
  * ����: SOC0305ҵ���߼��ӿ�
  * ��������: SOC0305ҵ���߼��ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0305BL extends BaseBL {

	/**
	 * SOC0305ʵ��ȡ��
	 *
	 * @return SOC0305ʵ��
	 */
	public SOC0305TB getSoc0305Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0305Info> searchSoc0305();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0305Info searchSoc0305ByPK(Integer id)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0305SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0305Info registSoc0305(SOC0305Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0305Info updateSoc0305(SOC0305Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSoc0305ByPK(Integer id)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSoc0305(SOC0305Info instance)
		throws BLException;

	
	public int getVWSearchCount(SOC0305SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0307Info> searchSOC0307(
			SOC0305SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}