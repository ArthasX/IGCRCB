/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;

/**
  * ����: ��Ч����DAO�ӿ�
  * ��������: ��Ч����DAO�ӿ�
  * ������¼: 2015/01/05
  * �޸ļ�¼: 
  */
public interface InstitutionDAO extends BaseHibernateDAO<InstitutionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InstitutionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InstitutionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InstitutionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InstitutionInfo> findByCond(
			final InstitutionSearchCond cond, final int start,
			final int count);

}