/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;

/**
  * ����: �����Ա�DAO�ӿ�
  * ��������: �����Ա�DAO�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG335DAO extends BaseHibernateDAO<IG335Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG335Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG335Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG335SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG335Info> findByCond(
			final IG335SearchCond cond, final int start,
			final int count);
	
	/**
	 * ��ʱ֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @param psdid ״̬����ID
	 * @param pidid ������ID
	 * @return  ��ʱ֪ͨ�����б�
	 */
	public List<IG335Info> searchIG335Info(final String pdid, final  String psdid, final String pidid, final String psdconfirm);

}