/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;

/**
  * ����: �ȶԽ��DAO�ӿ�
  * ��������: �ȶԽ��DAO�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareresultDAO extends BaseHibernateDAO<CompareresultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareresultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareresultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareresultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareresultInfo> findByCond(
			final CompareresultSearchCond cond, final int start,
			final int count);
	/**
     * ���ݶ���ȶԽ������List
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond);
    
	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareresultVWInfo> searchCompareresultVW(final CompareresultSearchCond cond);
}