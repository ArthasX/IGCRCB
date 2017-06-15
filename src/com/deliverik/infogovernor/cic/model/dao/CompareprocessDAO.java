/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;

/**
  * ����: �Աȼ�¼DAO�ӿ�
  * ��������: �Աȼ�¼DAO�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareprocessDAO extends BaseHibernateDAO<CompareprocessInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareprocessInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareprocessInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareprocessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareprocessInfo> findByCond(
			final CompareprocessSearchCond cond, final int start,
			final int count);

}