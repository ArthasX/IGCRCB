/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0502TB;

/**
  * ����: SOC0502ҵ���߼��ӿ�
  * ��������: SOC0502ҵ���߼��ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0502BL extends BaseBL {

	/**
	 * SOC0502ʵ��ȡ��
	 *
	 * @return SOC0502ʵ��
	 */
	public SOC0502TB getSoc0502Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0502Info> searchSoc0502();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0502Info searchSoc0502ByPK(Integer id)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0502SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0502Info> searchSoc0502(
			SOC0502SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0502Info> searchSoc0502(
			SOC0502SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0502Info registSoc0502(SOC0502Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0502Info updateSoc0502(SOC0502Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSoc0502ByPK(Integer id)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSoc0502(Integer[] rids)
		throws BLException;

	
	public int getVWSearchCount(SOC0502SearchCond storageEventSearchCond) throws BLException;

	public List<SOC0502Info> searchSOC0502(
			SOC0502SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException;


}