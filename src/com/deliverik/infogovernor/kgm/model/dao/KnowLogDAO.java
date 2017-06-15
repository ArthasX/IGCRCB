/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;

/**
  * ����: knowLogDAO�ӿ�
  * ��������: knowLogDAO�ӿ�
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
public interface KnowLogDAO extends BaseHibernateDAO<KnowLogInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<KnowLogInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public KnowLogInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLogInfo> findByCond(
			final KnowLogSearchCond cond, final int start,
			final int count);

}