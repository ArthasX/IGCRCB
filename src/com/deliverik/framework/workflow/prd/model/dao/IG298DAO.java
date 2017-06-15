/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������ϢDAO�ӿ�
  * ��������: ����״̬�ɷ��ɽ�ɫ������ϢDAO�ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface IG298DAO extends BaseHibernateDAO<IG298Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG298Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG298Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG298SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG298Info> findByCond(
			final IG298SearchCond cond, final int start,
			final int count);
	
	/**
	 * PSRDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSRDID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ���̶���ID
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Role> searchToBeAssignRole(final String pdid, final String psdid);

}