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
 * 角色信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class RoleTBDAOImpl extends BaseHibernateDAOImpl<Role> implements RoleTBDAO {
	
	/**
	 * 构造函数
	 */
	public RoleTBDAOImpl(){
		super(RoleTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Role> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roletype"));
		c.addOrder(Order.asc("rolename"));
		List<Role> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param roleid 主键
	 * @return 检索结果
	 */
	public Role findByPK(Serializable roleid) {

		Role role = super.findByPK(roleid);
		if(role == null) return null;

		return role;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RoleSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Role> findByCond(final RoleSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roletype"));
		c.addOrder(Order.asc("rolename"));
		List<Role> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	
	
	/**
	 * 条件检索记录数
	 * @return 条件检索记录数
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
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RoleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//角色名称
		if( !StringUtils.isEmpty(cond.getRolename())){
			c.add(Expression.eq("rolename", cond.getRolename()));
		}
		//角色名称（前方一致模糊匹配）
		if( !StringUtils.isEmpty(cond.getRolename_q())){
			c.add(Expression.like("rolename", "%"+cond.getRolename_q()+"%"));
		}
		//当roletypeEqual等于2时
		if( cond.getRoletypeEqual()==2){
			//角色类型（不匹配）
			c.add(Expression.ne("roletype",cond.getRoletype()));
			//roles_Like不为空
			if(!StringUtils.isEmpty(cond.getRoles_Like())){
				if(cond.getRoles_BP_EX() != null){
					//角色类型（前方一致模糊匹配）， roles_BP_EX扩展角色类型集合（区间匹配），取并集
					c.add(Expression.or(Expression.like("roletype", cond.getRoles_Like()+"%"), Expression.in("roletype", cond.getRoles_BP_EX())));
				}else{
					//角色类型（前方一致模糊匹配）
					c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
				}
			}
		}
		if(cond.getRoles_BP_EX() != null){
			//角色类型（前方一致模糊匹配）， roles_BP_EX扩展角色类型集合（区间匹配），取并集
			c.add(Expression.in("roletype", cond.getRoles_BP_EX()));
		}
		//角色类型（当roletypeEqual不等于2时，完全匹配）
		if( cond.getRoletypeEqual()!=2&&!StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//角色机构管理范围
		if( !StringUtils.isEmpty(cond.getRoledomain())){
			c.add(Expression.eq("roledomain", cond.getRoledomain()));
		}
		//角色机构管理范围（前方一致模糊匹配）
		if( !StringUtils.isEmpty(cond.getRoledomain_Like())){
			c.add(Expression.like("roledomain", cond.getRoledomain_Like()+"%"));
		}
		//角色类型（当roletypeEqual不等于2时，前方一致模糊匹配）
		if( cond.getRoletypeEqual()!=2&&!StringUtils.isEmpty(cond.getRoles_Like())){
			c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
		}
		//角色资产管理范围
		if( !StringUtils.isEmpty(cond.getAssetdomain())){
			c.add(Expression.eq("assetdomain", cond.getAssetdomain()));
		}
		//角色资产管理范围（前方一致模糊匹配）
		if( !StringUtils.isEmpty(cond.getAssetdomain_q())){
			c.add(Expression.like("assetdomain", cond.getAssetdomain_q()+"%"));
		}
		
		//角色类型查询条件（角色类型大于）
		if( !StringUtils.isEmpty(cond.getRoletype_gt())){
			c.add(Expression.gt("roletype", cond.getRoletype_gt()));
		}
		
		if(cond.getRoleid_in() != null && cond.getRoleid_in().size() > 0){
			c.add(Expression.in("roleid", cond.getRoleid_in()));
		}
		
		//过滤角色id
		if(StringUtils.isNotEmpty(cond.getRoleid_not_in())){
			c.add(Expression.sql(" this_.roleid not in ( " + cond.getRoleid_not_in() + ") "));
		}
		
		return c;
	}
	
}
