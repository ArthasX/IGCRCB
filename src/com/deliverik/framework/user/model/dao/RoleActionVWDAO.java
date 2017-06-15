package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.RoleActionInfo;
import com.deliverik.framework.user.model.condition.RoleActionVWSearchCond;

/**
 * ��ɫ�˵���Ȩ��ϢDAO�ӿ�
 * 
 */
public interface RoleActionVWDAO extends BaseHibernateDAO<RoleActionInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RoleActionInfo> findAll();

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RoleActionInfo findByPK(Serializable raid);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RoleActionInfo> findByCond(final RoleActionVWSearchCond cond, final int start, final int count);
}
