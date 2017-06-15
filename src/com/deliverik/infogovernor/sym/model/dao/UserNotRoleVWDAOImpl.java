/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;

/**
 * @Description: 角色授权用户接口实现
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
@SuppressWarnings("deprecation")
public class UserNotRoleVWDAOImpl extends BaseHibernateDAOImpl<UserNotRole> implements UserNotRoleVWDAO {

	/**
	 * 
	 */
	public UserNotRoleVWDAOImpl(){
		super(UserNotRole.class);
	}

	public List<UserNotRole> findByCond(final UserNotRoleVWSearchCond cond, final int start, final int count) {

		DetachedCriteria c = getCriteria(cond);

		List<UserNotRole> ret = findByCriteria(c, start, count);
		
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(UserNotRoleVWSearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();

		if( !StringUtils.isEmpty(cond.getUserid_q())){
			c.add(Expression.like("userid", "%"+cond.getUserid_q()+"%"));
		}	
		if( !StringUtils.isEmpty(cond.getUsername_q())){
			c.add(Expression.like("username", "%"+cond.getUsername_q()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getOrgidstr())){
			c.add(Expression.like("orgid", cond.getOrgidstr()+"%"));
		}
		if( !StringUtils.isEmpty(String.valueOf(cond.getRoleid()))){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		return c;
	}
	
	public int getSearchCount(final UserNotRoleVWSearchCond cond){

		DetachedCriteria c = getCriteria(cond);

		return getCount(c);
		
	}

	public List<UserNotRole> findByCondSyn(UserNotRoleVWSearchCond cond,int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		c.add(Expression.isNotNull("userstatus"));
		List<UserNotRole> ret = findByCriteria(c, start, count);
		return ret;
	}

	public int getSearchCountSyn(UserNotRoleVWSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		c.add(Expression.isNotNull("userstatus"));
		return getCount(c);
	}
}
