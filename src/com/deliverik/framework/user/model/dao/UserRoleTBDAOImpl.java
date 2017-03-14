package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.entity.UserRoleTB;

/**
 * �û���ɫ��Ȩ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class UserRoleTBDAOImpl extends BaseHibernateDAOImpl<UserRole> implements UserRoleTBDAO {

	/**
	 * ���캯��
	 */
	public UserRoleTBDAOImpl(){
		super(UserRoleTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserRole> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userid"));
		List<UserRole> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param urid ����
	 * @return �������
	 */
	public UserRole findByPK(Serializable urid) {

		UserRole userrole = super.findByPK(urid);
		if(userrole == null) return null;

		return userrole;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRoleSearchCond cond){

		return (int) findByCond(cond, 0, 0).size();
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRole> findByCond(final UserRoleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userid"));
		List<UserRole> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(UserRoleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�û�ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//��ɫID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		return c;
	}

}
