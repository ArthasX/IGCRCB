/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;

/**
  * ����: ״̬�ɷ��ɻ��������DAO�ӿ�
  * ��������: ״̬�ɷ��ɻ��������DAO�ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG299DAO extends BaseHibernateDAO<IG299Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG299Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG299Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG299SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG299Info> findByCond(
			final IG299SearchCond cond, final int start,
			final int count);

	/**
	 * PSODID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSODID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Organization> searchToBeAssignOrg(final String pdid, final int levellen, final String psdid);
}