/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.asset.model.condition.CompareTemplateSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: compareTemplateDAO�ӿ�
  * ��������: compareTemplateDAO�ӿ�
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public interface CompareTemplateDAO extends BaseHibernateDAO<CompareTemplateInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareTemplateInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareTemplateInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareTemplateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareTemplateInfo> findByCond(
			final CompareTemplateSearchCond cond, final int start,
			final int count);

}