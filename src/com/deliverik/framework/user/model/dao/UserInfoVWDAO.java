package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;

/**
 * �û���ϢDAO�ӿ�
 * 
 */
public interface UserInfoVWDAO extends BaseHibernateDAO<UserInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserInfo> findAll();

	/**
	 * ������������
	 * @param userInfoVWPK ����
	 * @return �������
	 */
	public UserInfo findByPK(Serializable userInfoVWPK);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserInfoSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserInfo> findByCond(final UserInfoSearchCond cond, final int start, final int count);
	
	/**
	 * ��ѯָ����ɫ�����µ������û�����
	 * @param cond ��������
	 * @return �����������
	 */
	public int getUserCountByRoleType(final UserInfoSearchCond cond);
	
	/**
	 * ��ѯָ����ɫ�����µ������û�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<User> findUserByRoleType(final UserInfoSearchCond cond, final int start, final int count);
	
}
