/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;

/**
 * @Description: ֪ͨ����
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
public interface DateWorkVWDAO extends BaseHibernateDAO<DateWorkVWInfo> {

	/**
	 *
	 * @param noticeid
	 * @return 
	 */
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond);
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond, final List<UserRoleInfo> list);
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond, final List<UserRoleInfo> list, final String temp);
}
