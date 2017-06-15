/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;

/**
  * ����: ʵ����·ͼDAO�ӿ�
  * ��������: ʵ����·ͼDAO�ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface SOC0114DAO extends BaseHibernateDAO<SOC0114Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0114Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0114Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0114SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0114Info> findByCond(
			final SOC0114SearchCond cond, final int start,
			final int count);
	
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
	public void delByEiid (Integer eiid );

	/**
	 * ����eiid��ѯ������ص�ҵ��ϵͳeiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid);
}