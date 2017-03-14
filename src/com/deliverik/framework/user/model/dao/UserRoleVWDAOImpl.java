package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;
import com.deliverik.framework.user.model.entity.UserRoleVW;

/**
 * �û���ɫ��Ȩ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class UserRoleVWDAOImpl extends BaseHibernateDAOImpl<UserRoleInfo> implements UserRoleVWDAO {

	/**
	 * ���캯��
	 */
	public UserRoleVWDAOImpl(){
		super(UserRoleVW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<UserRoleInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("orgid"));
		c.addOrder(Order.asc("userid"));
		List<UserRoleInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param urid ����
	 * @return �������
	 */
	public UserRoleInfo findByPK(Serializable urid) {

		UserRoleInfo userroleinfo = super.findByPK(urid);
		if(userroleinfo == null) return null;

		return userroleinfo;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRoleVWSearchCond cond){

		return  findByCond(cond, 0, 0).size();
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRoleInfo> findByCond(final UserRoleVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getRoletype())){
			c.addOrder(Order.asc("roledomain"));
		}else{
			c.addOrder(Order.asc("orgid"));
			c.addOrder(Order.asc("userid"));
		}
		
		List<UserRoleInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(UserRoleVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�û�ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//��ɫID
		if( cond.getRoleid()!=null && cond.getRoleid()!= 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		
		//��ɫ����
		if(!StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//�û���ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩
		if(!StringUtils.isEmpty(cond.getRoles_Like())){
			if(cond.getRoles_BP_EX() != null){
				//�û���ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩�� roles_BP_EX��չ��ɫ���ͼ��ϣ�����ƥ�䣩��ȡ����
				c.add(Expression.or(Expression.like("roletype", cond.getRoles_Like()+"%"), Expression.in("roletype", cond.getRoles_BP_EX())));
			}else{
				//�û���ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩
				c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
			}
		}
		//��ɫ������
		if(BooleanUtils.isTrue(cond.isRolemanager())){
			c.add(Expression.eq("rolemanager", "1"));
		}
		//��ɫֵ����
		if(BooleanUtils.isTrue(cond.isDutyflag())){
			c.add(Expression.eq("dutyflag", "1"));
		}
		
		//��ɫ��������
		if(!StringUtils.isEmpty(cond.getAssetdomain())){
			c.add(Expression.eq("assetdomain", cond.getAssetdomain()));
		}
		
		//��ɫ��������Χ
		if(!StringUtils.isEmpty(cond.getRoledomain_like())){
			c.add(Expression.like("roledomain", cond.getRoledomain_like() + "%"));
		}
		
		//��ɫ��������Χ
		if(!StringUtils.isEmpty(cond.getRoledomain())){
			c.add(Expression.eq("roledomain", cond.getRoledomain()));
		}
		// ����syscoding���ģ����ѯ
		if(!StringUtils.isEmpty(cond.getOrgid_like())){
			c.add(Expression.like("orgid", cond.getOrgid_like() + "%"));
		}
		if(cond.getRoleid_in() != null && cond.getRoleid_in().size() > 0){
			c.add(Restrictions.in("roleid", cond.getRoleid_in()));
		}
		return c;
	}

	

	/**
	 * ��ѯ���̶���������Ҫ����Ա�ͽ�ɫ��Ϣ
	 * @param pdid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserRoleInfo> findByPdid(String pdid){
		
		List<UserRoleInfo> list = null;
		StringBuffer query = new StringBuffer();	
		Session session = getSession();
		query.append(session.getNamedQuery("UserRoleVWDAO.searchProcessDefinedUserRoleVWByPdid").getQueryString());
		SQLQuery q = session.createSQLQuery(query.toString());
		q.setParameter("pdid", pdid);
		q.addEntity(UserRoleVW.class);
		list = q.list();
		return list;
	}


}
