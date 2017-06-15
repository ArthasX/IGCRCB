/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;

/**
  * ����: ��ҳ��תURL����DAO�ӿ�
  * ��������: ��ҳ��תURL����DAO�ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
public interface IG622DAO extends BaseHibernateDAO<IG622Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG622Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG622Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG622SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG622Info> findByCond(
			final IG622SearchCond cond, final int start,
			final int count);

}