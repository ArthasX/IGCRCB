package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * �û���ϢDAO�ӿ�
 * 
 */
public interface UserTBDAO extends BaseHibernateDAO<User> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<User> findAll();

	/**
	 * ������������
	 * @param userid ����
	 * @return �������
	 */
	public User findByPK(Serializable userid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<User> findByCond(final UserSearchCond cond, final int start, final int count);
	
	/**
	 * ���ݽ�ɫID��ѯ�û�
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(final Integer roleid);
}
