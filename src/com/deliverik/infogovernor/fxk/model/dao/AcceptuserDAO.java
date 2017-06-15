/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;

/**
  * ����: ���չ�����ʾ���������ݱ�DAO�ӿ�
  * ��������: ���չ�����ʾ���������ݱ�DAO�ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface AcceptuserDAO extends BaseHibernateDAO<AcceptuserInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AcceptuserInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AcceptuserInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AcceptuserSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AcceptuserInfo> findByCond(
			final AcceptuserSearchCond cond, final int start,
			final int count);

}