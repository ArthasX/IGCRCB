/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;

/**
  * ����: ������ĿDAO�ӿ�
  * ��������: ������ĿDAO�ӿ�
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public interface InternalauditprjDAO extends BaseHibernateDAO<InternalauditprjInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditprjInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditprjInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InternalauditprjSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditprjInfo> findByCond(
			final InternalauditprjSearchCond cond, final int start,
			final int count);
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(final InternalauditprjSearchCond cond, final int start, final int count);
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond);

}