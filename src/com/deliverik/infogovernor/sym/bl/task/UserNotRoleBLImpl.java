/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;
import com.deliverik.infogovernor.sym.model.dao.UserNotRoleVWDAO;

/**
 * @Description: 通知管理BL实现
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public class UserNotRoleBLImpl extends BaseBLImpl implements UserNotRoleBL {
	
	/**
	 * 通知相关操作DAO
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
	 * Description: 查询记录总数
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
	 * Description: 通知查询
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
	 * 获取同步记录
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
	 * Description: 查询同步记录总数
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
