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
 * 用户角色授权信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class UserRoleVWDAOImpl extends BaseHibernateDAOImpl<UserRoleInfo> implements UserRoleVWDAO {

	/**
	 * 构造函数
	 */
	public UserRoleVWDAOImpl(){
		super(UserRoleVW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<UserRoleInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("orgid"));
		c.addOrder(Order.asc("userid"));
		List<UserRoleInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param urid 主键
	 * @return 检索结果
	 */
	public UserRoleInfo findByPK(Serializable urid) {

		UserRoleInfo userroleinfo = super.findByPK(urid);
		if(userroleinfo == null) return null;

		return userroleinfo;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserRoleVWSearchCond cond){

		return  findByCond(cond, 0, 0).size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(UserRoleVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//用户ID
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		//角色ID
		if( cond.getRoleid()!=null && cond.getRoleid()!= 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		
		//角色类型
		if(!StringUtils.isEmpty(cond.getRoletype())){
			c.add(Expression.eq("roletype", cond.getRoletype()));
		}
		//用户角色类型（前方一致模糊匹配）
		if(!StringUtils.isEmpty(cond.getRoles_Like())){
			if(cond.getRoles_BP_EX() != null){
				//用户角色类型（前方一致模糊匹配）， roles_BP_EX扩展角色类型集合（区间匹配），取并集
				c.add(Expression.or(Expression.like("roletype", cond.getRoles_Like()+"%"), Expression.in("roletype", cond.getRoles_BP_EX())));
			}else{
				//用户角色类型（前方一致模糊匹配）
				c.add(Expression.like("roletype", cond.getRoles_Like()+"%"));
			}
		}
		//角色负责人
		if(BooleanUtils.isTrue(cond.isRolemanager())){
			c.add(Expression.eq("rolemanager", "1"));
		}
		//角色值班人
		if(BooleanUtils.isTrue(cond.isDutyflag())){
			c.add(Expression.eq("dutyflag", "1"));
		}
		
		//角色管理内容
		if(!StringUtils.isEmpty(cond.getAssetdomain())){
			c.add(Expression.eq("assetdomain", cond.getAssetdomain()));
		}
		
		//角色机构管理范围
		if(!StringUtils.isEmpty(cond.getRoledomain_like())){
			c.add(Expression.like("roledomain", cond.getRoledomain_like() + "%"));
		}
		
		//角色机构管理范围
		if(!StringUtils.isEmpty(cond.getRoledomain())){
			c.add(Expression.eq("roledomain", cond.getRoledomain()));
		}
		// 机构syscoding左侧模糊查询
		if(!StringUtils.isEmpty(cond.getOrgid_like())){
			c.add(Expression.like("orgid", cond.getOrgid_like() + "%"));
		}
		if(cond.getRoleid_in() != null && cond.getRoleid_in().size() > 0){
			c.add(Restrictions.in("roleid", cond.getRoleid_in()));
		}
		return c;
	}

	

	/**
	 * 查询流程定义中所需要的人员和角色信息
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
