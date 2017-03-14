/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0114PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0114TB;

/**
  * ����: ʵ����·ͼҵ���߼��ӿ�
  * ��������: ʵ����·ͼҵ���߼��ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface SOC0114BL extends BaseBL {

	/**
	 * ʵ����·ͼʵ��ȡ��
	 *
	 * @return ʵ����·ͼʵ��
	 */
	public SOC0114TB getEiLinkMapTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0114Info> searchEiLinkMap();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0114Info searchEiLinkMapByPK(SOC0114PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0114SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0114Info registEiLinkMap(SOC0114Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0114Info updateEiLinkMap(SOC0114Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiLinkMapByPK(SOC0114PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiLinkMap(SOC0114Info instance)
		throws BLException;
	
	/**
	 * ����ͼ��·��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0114Info> queryEiLinkMapList(SOC0114SearchCond cond);
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> queryImpactCI(final SOC0114SearchCond cond);
	
	public List<SOC0114Info> searchEiLinkMapByOtherEiid(EiLinkMapSearchCondImpl emCond);

	/**
	 * ����eiid ɾ����·
	 * @param eiid
	 */
	public void delByEiid (Integer eiid)throws BLException;
	/**
	 * ����eiid��ѯ������ص�ҵ��ϵͳeiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid)throws BLException;
}