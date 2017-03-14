package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;

/**
 * �û���ɫ��Ȩ��ϢDAO�ӿ�
 * 
 */
public interface UserRoleTBDAO extends BaseHibernateDAO<UserRole> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserRole> findAll();

	/**
	 * ������������
	 * @param urid ����
	 * @return �������
	 */
	public UserRole findByPK(Serializable urid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRoleSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRole> findByCond(final UserRoleSearchCond cond, final int start, final int count);
}
