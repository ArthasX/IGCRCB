/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;

/**
  * ����: ���ù�����DAO�ӿ�
  * ��������: ���ù�����DAO�ӿ�
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
public interface InternalauditJobDAO extends BaseHibernateDAO<InternalauditJobInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditJobInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditJobInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InternalauditJobSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditJobInfo> findByCond(
			final InternalauditJobSearchCond cond, final int start,
			final int count);

}