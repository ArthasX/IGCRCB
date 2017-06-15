/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: �ʲ�ģ����ͼDAO�ӿ�
  * ��������: �ʲ�ģ����ͼDAO�ӿ�
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface IG749DAO extends BaseHibernateDAO<IG749Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG749Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG749Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG749SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG749Info> findByCond(
			final IG749SearchCond cond, final int start,
			final int count);

}