/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;

/**
  * ����: ����֪ͨ����DAO�ӿ�
  * ��������: ����֪ͨ����DAO�ӿ�
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public interface IG212DAO extends BaseHibernateDAO<IG212Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG212Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG212Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG212SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG212Info> findByCond(
			final IG212SearchCond cond, final int start,
			final int count);
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	public List<IG238Info> searchIG238Info(final String pdid);

}