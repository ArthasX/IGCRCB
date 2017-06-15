/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;


/**
 * @Description: 通知管理BL
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */

public interface UserNotRoleBL extends BaseBL {
	
	/**
	 * 获取通知记录
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 */
	
	public List<UserNotRole> searchUserNotRole(UserNotRoleVWSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * <p>
	 * Description: 查询记录总数
	 * </p>
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @return int
	 * @author   
	 * @update
	 */
	
	public int getSearchCount(UserNotRoleVWSearchCond cond) throws BLException;
	
	
	/**
	 * 获取同步记录
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 */
	public List<UserNotRole> searchUserNotRoleSyn(UserNotRoleVWSearchCond cond, int start, int count) throws BLException;
	
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
	public int getSearchCountSyn(UserNotRoleVWSearchCond cond) throws BLException;
}
