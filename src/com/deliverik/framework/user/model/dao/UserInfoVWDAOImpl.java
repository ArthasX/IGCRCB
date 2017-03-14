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
 * 用户信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class UserInfoVWDAOImpl extends BaseHibernateDAOImpl<UserInfo> implements UserInfoVWDAO {

	/**
	 * 构造函数
	 */
	public UserInfoVWDAOImpl(){
		super(UserInfoVW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<UserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userida"));
		c.addOrder(Order.asc("roleida"));
		List<UserInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param roleid 主键
	 * @return 检索结果
	 */
	public UserInfo findByPK(Serializable userInfoVWPK) {

		UserInfo userInfo = super.findByPK(userInfoVWPK);
		if(userInfo == null) return null;

		return userInfo;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserInfoSearchCond cond){

		return (Integer) findByCond(cond, 0, 0).size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<UserInfo> findByCond(final UserInfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userida"));
		c.addOrder(Order.asc("roleida"));
		List<UserInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 查询指定角色类型下的所有用户个数
	 * @param cond 检索条件
	 * @return 检索结果个数
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
	 * 查询指定角色类型下的所有用户
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(UserInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//用户ID
		if( !StringUtils.isEmpty(cond.getUserida())){
			c.add(Expression.eq("userida", cond.getUserida()));
		}	
		//用户姓名（模糊匹配）
		if( !StringUtils.isEmpty(cond.getUsername())){
			c.add(Expression.like("username", "%"+cond.getUsername()+"%"));
		}
		//用户角色名称
		if( !StringUtils.isEmpty(cond.getRolename())){
			c.add(Expression.eq("rolename", cond.getRolename()));
		}
		//用户角色类型
		if( !StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//用户机构名称
		if( !StringUtils.isEmpty(cond.getOrgname())){
			c.add(Expression.eq("orgname", cond.getOrgname()));
		}
		//用户角色ID
		if( cond.getRoleida() != null && cond.getRoleida() > 0){
			c.add(Expression.eq("roleida", cond.getRoleida()));
		}
		//用户机构层次码（前方一致模糊匹配
		if( !StringUtils.isEmpty(cond.getOrgida())){
			c.add(Expression.like("orgida", cond.getOrgida()+"%"));
		}
		//工号
		if(!StringUtils.isEmpty(cond.getUserinfo())){
			c.add(Expression.eq("userinfo", cond.getUserinfo()));
		}	
		//工号
		if(!StringUtils.isEmpty(cond.getUserinfo_like())){
			c.add(Expression.like("userinfo", cond.getUserinfo_like()+"%"));
		}	
		
		//用户名  完全匹配 PMS系统专用
		if(!StringUtils.isEmpty(cond.getUsername_forPms())){
			c.add(Expression.like("username", cond.getUsername_forPms()));
		}
		
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(UserInfoSearchCond cond, StringBuffer query){
		//角色类型
		if( StringUtils.isNotEmpty(cond.getRoletype()) ){
			query.append(" AND role.roletype = :roletype");
		}	
		
		//用户名称
		if( StringUtils.isNotEmpty(cond.getUsername()) ){
			query.append(" AND a.username like ('%'||:username||'%') ");
		}	
		//机构
		if( StringUtils.isNotEmpty(cond.getOrgida()) ){
			query.append(" AND a.orgid = :orgida");
		}
		//工单
		if( StringUtils.isNotEmpty(cond.getUserinfo()) ){
			query.append(" AND a.userinfo = :userinfo");
		}	
		//工单
		if( StringUtils.isNotEmpty(cond.getUserinfo_like()) ){
			query.append(" AND a.userinfo like ('%'||:userinfo_like||'%') ");
		}	
	}

}
