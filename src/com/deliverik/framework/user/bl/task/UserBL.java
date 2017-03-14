package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * <p>
 * 用户信息业务逻辑
 * </p>
 */
public interface UserBL extends BaseBL {
	
	/**
	 * 根据检索条件取得用户信息条数
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息条数
	 */
	
	public int getUserSearchCount(UserSearchCond cond);

	/**
	 * 根据用户信息主键取得用户信息
	 * 
	 * @param userid 用户信息主键
	 * @return 用户信息
	 * @throws BLException 
	 */
	public User searchUserByKey(String userid) throws BLException;
	
	/**
	 * 根据检索条件取得用户信息列表
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息列表
	 */
	
	public List<User> searchUser(UserSearchCond cond);
	
	/**
	 * 根据检索条件取得用户信息列表(分页查询用)
	 * 
	 * @param cond 用户信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户信息列表
	 */
	
	public List<User> searchUser(UserSearchCond cond, int start, int count);
	
	/**
	 * 保存用户信息处理
	 * 
	 * @param user 保存的用户信息
	 * @return 保存后用户信息
	 * @throws BLException
	 */
	public User registUser(User user) throws BLException;
	
	/**
	 * 删除用户信息处理
	 * 
	 * @param user 删除的用户信息
	 * @return
	 * @throws BLException
	 */
	public void deleteUser(User user) throws BLException;
	
	/**
	 * 根据用户信息主逻辑键删除用户信息处理
	 * 
	 * @param userid 逻辑删除用户信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteUserByKey(String userid) throws BLException;


	/**
	 * 变更用户信息处理
	 * 
	 * @param user 变更的用户信息
	 * @return 变更后用户信息
	 * @throws BLException
	 */
	public User updateUser(User user) throws BLException;
	
	/**
	 * 根据检索条件取得用户角色机构信息条数
	 * 
	 * @param cond 用户角色机构信息检索条件
	 * @return 用户角色机构信息条数
	 */
	
	public int getUserInfoSearchCount(UserInfoSearchCond cond);

	/**
	 * 根据检索条件取得用户角色机构信息列表
	 * 
	 * @param cond 用户角色机构信息检索条件
	 * @return 用户角色机构信息列表
	 */
	
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond);
	
	/**
	 * 根据检索条件取得用户角色机构信息列表(分页查询用)
	 * 
	 * @param cond 用户角色机构信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户角色机构信息列表
	 */
	
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond, int start, int count);
	
	/**
	 * 查询指定角色类型下的所有用户个数
	 * @param cond 检索条件
	 * @return 检索结果个数
	 */
	public int getUserCountByRoleType(UserInfoSearchCond cond);
	
	/**
	 * 查询指定角色类型下的所有用户
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<User> searchUserByRoleType(UserInfoSearchCond cond, int start, int count);

	/**
	 * 根据角色ID查询用户
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(Integer roleid);
}
