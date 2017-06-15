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
 * �û���ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class UserTBDAOImpl extends BaseHibernateDAOImpl<User> implements UserTBDAO {

	/**
	 * ���캯��
	 */
	public UserTBDAOImpl(){
		super(UserTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<User> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("userid"));
		List<User> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param urid ����
	 * @return �������
	 */
	public User findByPK(Serializable userid) {

		User user = super.findByPK(userid);
		if(user == null) return null;

		return user;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserSearchCond cond){

		return (Integer) findByCond(cond, 0, 0).size();
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<User> findByCond(final UserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("userid"));
		List<User> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(UserSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�û�ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}	
		//�û�ID��ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getUserid_q())){
			c.add(Expression.like("userid", "%"+cond.getUserid_q()+"%"));
		}	
		//�û�����
		if( !StringUtils.isEmpty(cond.getUsername())){
			c.add(Expression.eq("username", cond.getUsername()));
		}	
		//�û����ƣ�ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getUsername_q())){
			c.add(Expression.like("username", "%"+cond.getUsername_q()+"%"));
		}	
		//�û���������루ǰ��һ��ģ��ƥ�䣩
		if(!StringUtils.isEmpty(cond.getOrgid_like())){
			c.add(Expression.like("orgid", cond.getOrgid_like()+"%"));
		}	
		//�û��ֻ�
		if(!StringUtils.isEmpty(cond.getUsermobile())){
			c.add(Expression.eq("usermobile", cond.getUsermobile()));
		}	
		//�û�����
		if(!StringUtils.isEmpty(cond.getPassword())){
			c.add(Expression.eq("password", StringEncrypt.charToAscii(cond.getPassword())));
		}
		//�߼�ɾ����־״̬
		if(!StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//���������
		if(!StringUtils.isEmpty(cond.getOrgid())){
			c.add(Expression.eq("orgid", cond.getOrgid()));
		}
		//����
		if(!StringUtils.isEmpty(cond.getUserinfo())){
			c.add(Expression.eq("userinfo", cond.getUserinfo()));
		}	
		//����
		if(!StringUtils.isEmpty(cond.getUserinfo_like())){
			c.add(Expression.like("userinfo", cond.getUserinfo_like()+"%"));
		}
		
		//�û���Χ
		if(cond.getUserid_in() != null && cond.getUserid_in().size() > 0){
		    c.add(Expression.in("userid", cond.getUserid_in()));
		}
		return c;
	}

	/**
	 * ���ݽ�ɫID��ѯ�û�
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
