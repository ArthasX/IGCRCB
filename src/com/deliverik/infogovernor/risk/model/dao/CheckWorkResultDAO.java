/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCond;

/**
  * ����: �������DAO�ӿ�
  * ��������: �������DAO�ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckWorkResultDAO extends BaseHibernateDAO<CheckWorkResultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkResultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkResultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckWorkResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkResultInfo> findByCond(
			final CheckWorkResultSearchCond cond, final int start,
			final int count);

}