package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;

/**
 * �û���ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class UserInfoVWDAOImpl extends BaseHibernateDAOImpl<UserInfo> implements UserInfoVWDAO {

	/**
	 * ���캯��
	 */
	public UserInfoVWDAOImpl(){
		super(UserInfoVW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userida"));
		c.addOrder(Order.asc("roleida"));
		List<UserInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param roleid ����
	 * @return �������
	 */
	public UserInfo findByPK(Serializable userInfoVWPK) {

		UserInfo userInfo = super.findByPK(userInfoVWPK);
		if(userInfo == null) return null;

		return userInfo;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserInfoSearchCond cond){

		return (Integer) findByCond(cond, 0, 0).size();
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserInfo> findByCond(final UserInfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userida"));
		c.addOrder(Order.asc("roleida"));
		List<UserInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ��ѯָ����ɫ�����µ������û�����
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getUserCountByRoleType(final UserInfoSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("UserInfoVWDAO.findUserByRoleType").getQueryString());
				getSQL(cond, query);			
				query.append(" ORDER BY a.userid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("user",UserTB.class);
				setFetchPoint(q, 0, 0);
				List<User> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ��ѯָ����ɫ�����µ������û�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserByRoleType(final UserInfoSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("UserInfoVWDAO.findUserByRoleType").getQueryString());
				getSQL(cond, query);			
				query.append(" ORDER BY a.userid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("user",UserTB.class);
				setFetchPoint(q, start, count);
				List<User> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<User>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(UserInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�û�ID
		if( !StringUtils.isEmpty(cond.getUserida())){
			c.add(Expression.eq("userida", cond.getUserida()));
		}	
		//�û�������ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getUsername())){
			c.add(Expression.like("username", "%"+cond.getUsername()+"%"));
		}
		//�û���ɫ����
		if( !StringUtils.isEmpty(cond.getRolename())){
			c.add(Expression.eq("rolename", cond.getRolename()));
		}
		//�û���ɫ����
		if( !StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//�û���������
		if( !StringUtils.isEmpty(cond.getOrgname())){
			c.add(Expression.eq("orgname", cond.getOrgname()));
		}
		//�û���ɫID
		if( cond.getRoleida() != null && cond.getRoleida() > 0){
			c.add(Expression.eq("roleida", cond.getRoleida()));
		}
		//�û���������루ǰ��һ��ģ��ƥ��
		if( !StringUtils.isEmpty(cond.getOrgida())){
			c.add(Expression.like("orgida", cond.getOrgida()+"%"));
		}
		//����
		if(!StringUtils.isEmpty(cond.getUserinfo())){
			c.add(Expression.eq("userinfo", cond.getUserinfo()));
		}	
		//����
		if(!StringUtils.isEmpty(cond.getUserinfo_like())){
			c.add(Expression.like("userinfo", cond.getUserinfo_like()+"%"));
		}	
		
		//�û���  ��ȫƥ�� PMSϵͳר��
		if(!StringUtils.isEmpty(cond.getUsername_forPms())){
			c.add(Expression.like("username", cond.getUsername_forPms()));
		}
		
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(UserInfoSearchCond cond, StringBuffer query){
		//��ɫ����
		if( StringUtils.isNotEmpty(cond.getRoletype()) ){
			query.append(" AND role.roletype = :roletype");
		}	
		
		//�û�����
		if( StringUtils.isNotEmpty(cond.getUsername()) ){
			query.append(" AND a.username like ('%'||:username||'%') ");
		}	
		//����
		if( StringUtils.isNotEmpty(cond.getOrgida()) ){
			query.append(" AND a.orgid = :orgida");
		}
		//����
		if( StringUtils.isNotEmpty(cond.getUserinfo()) ){
			query.append(" AND a.userinfo = :userinfo");
		}	
		//����
		if( StringUtils.isNotEmpty(cond.getUserinfo_like()) ){
			query.append(" AND a.userinfo like ('%'||:userinfo_like||'%') ");
		}	
	}

}
