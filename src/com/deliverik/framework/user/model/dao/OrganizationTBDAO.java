package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

/**
 * ������ϢDAO�ӿ�
 * 
 */
public interface OrganizationTBDAO extends BaseHibernateDAO<Organization> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Organization> findAll();

	/**
	 * ������������
	 * @param orgid ����
	 * @return �������
	 */
	public Organization findByPK(Serializable orgid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final OrganizationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond, final int start, final int count);
	
	/**
	 * ������������ҳ��������ʾ������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond);
	
	/**
	 * ���������������������¼���
	 * @param cond ��������
	 * @param orgsyscoding ���������
	 * @return ��������б�
	 */
	public List<Organization> findByCond(final OrganizationSearchCond cond,final String orgsyscoding);
	
}
