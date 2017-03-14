/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;

/**
 * @Description: ��ɫ��Ȩ�û��ӿ�
 * @Author  masai
 * @History 2010-6-22     �½� 
 * @Version V2.0
 */
public interface UserNotRoleVWDAO extends BaseHibernateDAO<UserNotRole> {

	/**
	 *
	 * @return 
	 */
	public List<UserNotRole> findByCond(final UserNotRoleVWSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final UserNotRoleVWSearchCond cond);
	
	/** ����ֻ��ͬ���� */
	public List<UserNotRole> findByCondSyn(final UserNotRoleVWSearchCond cond, final int start, final int count);
	
	public int getSearchCountSyn(final UserNotRoleVWSearchCond cond);
}
