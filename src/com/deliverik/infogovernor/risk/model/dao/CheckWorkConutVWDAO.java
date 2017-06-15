/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;

/**
  * ����: ��鹤��ͳ�Ʊ���DAO�ӿ�
  * ��������: ��鹤��ͳ�Ʊ���DAO�ӿ�
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public interface CheckWorkConutVWDAO extends BaseHibernateDAO<CheckWorkConutVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkConutVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkConutVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckWorkConutVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkConutVWInfo> findByCond(
			final CheckWorkConutVWSearchCond cond, final int start,
			final int count);

}