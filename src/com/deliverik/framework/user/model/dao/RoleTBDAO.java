package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * ��ɫ��ϢDAO�ӿ�
 * 
 */
public interface RoleTBDAO extends BaseHibernateDAO<Role> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Role> findAll();

	/**
	 * ������������
	 * @param roleid ����
	 * @return �������
	 */
	public Role findByPK(Serializable roleid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RoleSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Role> findByCond(final RoleSearchCond cond, final int start, final int count);
	
	/**
	 * ����������¼��
	 * @return ����������¼��
	 */
	public int searchRoleCountForSelfDef(final RoleSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Role> searchRoleForSelfDef(final RoleSearchCond cond, final int start, final int count);
}
