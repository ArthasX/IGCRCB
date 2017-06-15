/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;

/**
  * ����: oracle���ܲɼ�DAO�ӿ�
  * ��������: oracle���ܲɼ�DAO�ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface EmDAO extends BaseHibernateDAO<EmInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmInfo> findByCond(
			final EmSearchCond cond, final int start,
			final int count);

}