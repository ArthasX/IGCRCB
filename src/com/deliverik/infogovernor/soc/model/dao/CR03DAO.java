/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;

/**
  * ����: ����ԭ������������ϵ��DAO�ӿ�
  * ��������: ����ԭ������������ϵ��DAO�ӿ�
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public interface CR03DAO extends BaseHibernateDAO<CR03Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CR03Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CR03Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CR03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03Info> findByCond(
			final CR03SearchCond cond, final int start,
			final int count);
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03Info> findByCondMax(
			final CR03SearchCond cond, final int start, 
			final int count);
	
	/**
	 * ������������[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond);
	
	/**
	 * ��ȡ���òɼ��İ汾��Ϣ
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count);

}