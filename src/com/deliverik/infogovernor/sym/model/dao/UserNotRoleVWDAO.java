/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;

/**
 * @Description: 角色授权用户接口
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
public interface UserNotRoleVWDAO extends BaseHibernateDAO<UserNotRole> {

	/**
	 *
	 * @return 
	 */
	public List<UserNotRole> findByCond(final UserNotRoleVWSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final UserNotRoleVWSearchCond cond);
	
	/** 新增只查同步的 */
	public List<UserNotRole> findByCondSyn(final UserNotRoleVWSearchCond cond, final int start, final int count);
	
	public int getSearchCountSyn(final UserNotRoleVWSearchCond cond);
}
