package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * �û���ɫ��Ȩ��ϢDAO�ӿ�
 * 
 */
public interface UserRoleVWDAO extends BaseHibernateDAO<UserRoleInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserRoleInfo> findAll();

	/**
	 * ������������
	 * @param urid ����
	 * @return �������
	 */
	public UserRoleInfo findByPK(Serializable urid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRoleVWSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRoleInfo> findByCond(final UserRoleVWSearchCond cond, final int start, final int count);
	
	/**
	 * ��ѯ���̶���������Ҫ����Ա�ͽ�ɫ��Ϣ
	 * @param pdid
	 * @return
	 */
	public List<UserRoleInfo> findByPdid(String pdid);
}
