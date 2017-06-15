/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.UserNotRole;
import com.deliverik.infogovernor.sym.model.condition.UserNotRoleVWSearchCond;


/**
 * @Description: ֪ͨ����BL
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */

public interface UserNotRoleBL extends BaseBL {
	
	/**
	 * ��ȡ֪ͨ��¼
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 */
	
	public List<UserNotRole> searchUserNotRole(UserNotRoleVWSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * <p>
	 * Description: ��ѯ��¼����
	 * </p>
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @return int
	 * @author   
	 * @update
	 */
	
	public int getSearchCount(UserNotRoleVWSearchCond cond) throws BLException;
	
	
	/**
	 * ��ȡͬ����¼
	 * 
	 * @param cond UserNotRoleVWSearchCond
	 * @param start int
	 * @param count int
	 * @return List<UserNotRole>
	 */
	public List<UserNotRole> searchUserNotRoleSyn(UserNotRoleVWSearchCond cond, int start, int count) throws BLException;
	
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
	public int getSearchCountSyn(UserNotRoleVWSearchCond cond) throws BLException;
}
