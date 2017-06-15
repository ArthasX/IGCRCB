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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.entity.RoleTB;

/**
 * ��ɫ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class RoleTBDAOImpl extends BaseHibernateDAOImpl<Role> implements RoleTBDAO {
	
	/**
	 * ���캯��
	 */
	public RoleTBDAOImpl(){
		super(RoleTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Role> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roletype"));
		c.addOrder(Order.asc("rolename"));
		List<Role> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param roleid ����
	 * @return �������
	 */
	public Role findByPK(Serializable roleid) {

		Role role = super.findByPK(roleid);
		if(role == null) return null;

		return role;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RoleSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Role> findByCond(final RoleSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roletype"));
		c.addOrder(Order.asc("rolename"));
		List<Role> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	
	
	/**
	 * ����������¼��
	 * @return ����������¼��
	 */
	public int searchRoleCountForSelfDef(final RoleSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RoleTBDAO.RoleCountForSelfDef").getQueryString());

				getSQLForSelfDef(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				
				session.clear();

				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
		//return Integer.valueOf(String.valueOf(execute(action)));
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Role> searchRoleForSelfDef(final RoleSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RoleTBDAO.RoleForSelfDef").getQueryString());
				
				getSQLForSelfDef(cond, query);
				
				query.append(" ORDER BY r.roleid desc ");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("role",RoleTB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, start, count);

				List<Role> list = q.list();
				
				session.clear();

				return list;
			}
		};
		return (List<Role>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQLForSelfDef(RoleSearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getPdid())){
			query.append(" AND p.pdid = :pdid");
		}
		if( StringUtils.isNotEmpty(cond.getRolename_q())){
			query.append(" AND r.rolename like '%'||:rolename_q||'%'");
		}
		
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RoleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��ɫ����
		if( !StringUtils.isEmpty(cond.getRolename())){
			c.add(Expression.eq("rolename", cond.getRolename()));
		}
		//��ɫ���ƣ�ǰ��һ��ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getRolename_q())){
			c.add(Expression.like("rolename", "%"+cond.getRolename_q()+"%"));
		}
		//��roletypeEqual����2ʱ
		if( cond.getRoletypeEqual()==2){
			//��ɫ���ͣ���ƥ�䣩
			c.add(Expression.ne("roletype",cond.getRoletype()));
			//roles_Like��Ϊ��
			if(!StringUtils.isEmpty(cond.getRoles_Like())){
				if(cond.getRoles_BP_EX() != null){
					//��ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩�� roles_BP_EX��չ��ɫ���ͼ��ϣ�����ƥ�䣩��ȡ����
					c.add(Expression.or(Expression.like("roletype", cond.getRoles_Like()+"%"), Expression.in("roletype", cond.getRoles_BP_EX())));
				}else{
					//��ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩
					c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
				}
			}
		}
		if(cond.getRoles_BP_EX() != null){
			//��ɫ���ͣ�ǰ��һ��ģ��ƥ�䣩�� roles_BP_EX��չ��ɫ���ͼ��ϣ�����ƥ�䣩��ȡ����
			c.add(Expression.in("roletype", cond.getRoles_BP_EX()));
		}
		//��ɫ���ͣ���roletypeEqual������2ʱ����ȫƥ�䣩
		if( cond.getRoletypeEqual()!=2&&!StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//��ɫ��������Χ
		if( !StringUtils.isEmpty(cond.getRoledomain())){
			c.add(Expression.eq("roledomain", cond.getRoledomain()));
		}
		//��ɫ��������Χ��ǰ��һ��ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getRoledomain_Like())){
			c.add(Expression.like("roledomain", cond.getRoledomain_Like()+"%"));
		}
		//��ɫ���ͣ���roletypeEqual������2ʱ��ǰ��һ��ģ��ƥ�䣩
		if( cond.getRoletypeEqual()!=2&&!StringUtils.isEmpty(cond.getRoles_Like())){
			c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
		}
		//��ɫ�ʲ�����Χ
		if( !StringUtils.isEmpty(cond.getAssetdomain())){
			c.add(Expression.eq("assetdomain", cond.getAssetdomain()));
		}
		//��ɫ�ʲ�����Χ��ǰ��һ��ģ��ƥ�䣩
		if( !StringUtils.isEmpty(cond.getAssetdomain_q())){
			c.add(Expression.like("assetdomain", cond.getAssetdomain_q()+"%"));
		}
		
		//��ɫ���Ͳ�ѯ��������ɫ���ʹ��ڣ�
		if( !StringUtils.isEmpty(cond.getRoletype_gt())){
			c.add(Expression.gt("roletype", cond.getRoletype_gt()));
		}
		
		if(cond.getRoleid_in() != null && cond.getRoleid_in().size() > 0){
			c.add(Expression.in("roleid", cond.getRoleid_in()));
		}
		
		//���˽�ɫid
		if(StringUtils.isNotEmpty(cond.getRoleid_not_in())){
			c.add(Expression.sql(" this_.roleid not in ( " + cond.getRoleid_not_in() + ") "));
		}
		
		return c;
	}
	
}
