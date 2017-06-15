/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;

/**
  * ����: �Աȹ���DAO�ӿ�
  * ��������: �Աȹ���DAO�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareroleDAO extends BaseHibernateDAO<CompareroleInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareroleInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareroleInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareroleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareroleInfo> findByCond(
			final CompareroleSearchCond cond, final int start,
			final int count);

	/**
     * ���ݹ�ϵ���ѯ���򼰶���
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareroleInfo> searchCompareroleByRelation(final CompareroleSearchCond cond);
}