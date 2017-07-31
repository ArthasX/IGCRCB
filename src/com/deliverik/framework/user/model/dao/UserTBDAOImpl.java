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
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.StringEncrypt;

/**
 * 用户信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class UserTBDAOImpl extends BaseHibernateDAOImpl<User> implements UserTBDAO {

	/**
	 * 构造函数
	 */
	public UserTBDAOImpl(){
		super(UserTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<User> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userid"));
		List<User> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param urid 主键
	 * @return 检索结果
	 */
	public User findByPK(Serializable userid) {

		User user = super.findByPK(userid);
		if(user == null) return null;

		return user;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserSearchCond cond){

		return (Integer) findByCond(cond, 0, 0).size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<User> findByCond(final UserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userid"));
		List<User> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(UserSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//用户ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}	
		//用户ID（模糊匹配）
		if( !StringUtils.isEmpty(cond.getUserid_q())){
			c.add(Expression.like("userid", "%"+cond.getUserid_q()+"%"));
		}	
		//用户姓名
		if( !StringUtils.isEmpty(cond.getUsername())){
			c.add(Expression.eq("username", cond.getUsername()));
		}	
		//用户名称（模糊匹配）
		if( !StringUtils.isEmpty(cond.getUsername_q())){
			c.add(Expression.like("username", "%"+cond.getUsername_q()+"%"));
		}	
		//用户机构层次码（前方一致模糊匹配）
		if(!StringUtils.isEmpty(cond.getOrgid_like())){
			c.add(Expression.like("orgid", cond.getOrgid_like()+"%"));
		}	
		//用户手机
		if(!StringUtils.isEmpty(cond.getUsermobile())){
			c.add(Expression.eq("usermobile", cond.getUsermobile()));
		}	
		//用户口令
		if(!StringUtils.isEmpty(cond.getPassword())){
			c.add(Expression.eq("password", StringEncrypt.charToAscii(cond.getPassword())));
		}
		//逻辑删除标志状态
		if(!StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//机构层次码
		if(!StringUtils.isEmpty(cond.getOrgid())){
			c.add(Expression.eq("orgid", cond.getOrgid()));
		}
		//机构层次码like
		if(!StringUtils.isEmpty(cond.getOrgid_like())){
			c.add(Expression.like("orgid", cond.getOrgid_like()+"%"));
		}
		//工号
		if(!StringUtils.isEmpty(cond.getUserinfo())){
			c.add(Expression.eq("userinfo", cond.getUserinfo()));
		}	
		//工号
		if(!StringUtils.isEmpty(cond.getUserinfo_like())){
			c.add(Expression.like("userinfo", cond.getUserinfo_like()+"%"));
		}
		
		//用户范围
		if(cond.getUserid_in() != null && cond.getUserid_in().size() > 0){
		    c.add(Expression.in("userid", cond.getUserid_in()));
		}
		return c;
	}

	/**
	 * 根据角色ID查询用户
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(final Integer roleid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("UserTBDAO.findUserByRoleId").getQueryString());
				query.append(" and userid in (select userid from userrole where roleid = '"+roleid+"')");
				query.append(" ORDER BY userid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("user",UserTB.class);
				List<User> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<UserInfo>) execute(action);
	}
}
