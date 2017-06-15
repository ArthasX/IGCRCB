package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;

/**
 * ��ɫ�˵���Ȩ��ϢDAO�ӿ�
 * 
 */
public interface RoleActionTBDAO extends BaseHibernateDAO<RoleAction> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RoleAction> findAll();

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RoleAction findByPK(Serializable raid);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RoleActionSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RoleAction> findByCond(final RoleActionSearchCond cond, final int start, final int count);
}
