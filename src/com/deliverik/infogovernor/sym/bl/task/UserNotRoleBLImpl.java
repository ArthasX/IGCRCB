/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;
import com.deliverik.infogovernor.sym.model.dao.UserNotRoleVWDAO;

/**
 * @Description: ֪ͨ����BLʵ��
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
public class UserNotRoleBLImpl extends BaseBLImpl implements UserNotRoleBL {
	
	/**
	 * ֪ͨ��ز���DAO
	 */
	
	protected UserNotRoleVWDAO userNotRoleVWDAO;

	
	public UserNotRoleVWDAO getUserNotRoleVWDAO() {
		return userNotRoleVWDAO;
	}

	public void setUserNotRoleVWDAO(UserNotRoleVWDAO userNotRoleVWDAO) {
		this.userNotRoleVWDAO = userNotRoleVWDAO;
	}

	/**
	 * <p>
	 * Description: ��ѯ��¼����
	 * </p>
	 * 
	 * @param cond NoticeSearchCond
	 * @return int
	 */
	
	public int getSearchCount(UserNotRoleVWSearchCond cond){

		return userNotRoleVWDAO.getSearchCount(cond);
		
	}
	
	/**
	 * <p>
	 * Description: ֪ͨ��ѯ
	 * </p>
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 * @author   
	 * @update
	 */
	
	public List<UserNotRole> searchUserNotRole(UserNotRoleVWSearchCond cond, int start, int count){

		List<UserNotRole> ret = userNotRoleVWDAO.findByCond(cond , start , count);
		
		return ret;
		
	}
	
	/**
	 * ��ȡͬ����¼
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 */
	public int getSearchCountSyn(UserNotRoleVWSearchCond cond){
		return userNotRoleVWDAO.getSearchCountSyn(cond);
	}
	
	/**
	 * <p>
	 * Description: ��ѯͬ����¼����
	 * </p>
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @return int
	 * @author   
	 * @update
	 */
	public List<UserNotRole> searchUserNotRoleSyn(UserNotRoleVWSearchCond cond,int start, int count){
		List<UserNotRole> ret = userNotRoleVWDAO.findByCondSyn(cond , start , count);
		return ret;
	}

}
