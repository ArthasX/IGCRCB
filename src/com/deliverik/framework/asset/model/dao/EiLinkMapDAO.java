/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ʵ����·ͼDAO�ӿ�
  * ��������: ʵ����·ͼDAO�ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface EiLinkMapDAO extends BaseHibernateDAO<EiLinkMapInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiLinkMapInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiLinkMapInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiLinkMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> findByCond(
			final EiLinkMapSearchCond cond, final int start,
			final int count);
	
	/**
	 * ����ͼ��·��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> queryEiLinkMapList(EiLinkMapSearchCond cond);
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond);
	
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(EiLinkMapSearchCondImpl emCond);

}