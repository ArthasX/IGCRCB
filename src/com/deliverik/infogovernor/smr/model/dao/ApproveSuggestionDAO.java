/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;

/**
  * ����: ���������DAO�ӿ�
  * ��������: ���������DAO�ӿ�
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public interface ApproveSuggestionDAO extends BaseHibernateDAO<ApproveSuggestionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ApproveSuggestionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ApproveSuggestionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ApproveSuggestionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ApproveSuggestionInfo> findByCond(
			final ApproveSuggestionSearchCond cond, final int start,
			final int count);

}