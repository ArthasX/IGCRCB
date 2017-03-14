package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.framework.user.model.dao.UserInfoVWDAO;
import com.deliverik.framework.user.model.dao.UserTBDAO;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.StringEncrypt;

/**
 * <p>
 * 用户信息业务逻辑实现
 * </p>
 */
public class UserBLImpl extends BaseBLImpl implements UserBL {
	
	/** 用户信息相关操作DAO */
	
	protected UserTBDAO userTBDAO;
	
	/** 用户信息相关操作DAO */
	
	protected UserInfoVWDAO userInfoVWDAO;

	/**
	 * 用户信息相关操作DAO设定
	 * @param userTBDAO 用户信息相关操作DAO
	 */
	
	public void setUserTBDAO(UserTBDAO userTBDAO) {
		this.userTBDAO = userTBDAO;
	}
	
	/**
	 * 用户信息相关操作DAO设定
	 * @param userInfoVWDAO 用户信息相关操作DAO
	 */
	
	public void setUserInfoVWDAO(UserInfoVWDAO userInfoVWDAO) {
		this.userInfoVWDAO = userInfoVWDAO;
	}
	
	/**
	 * 根据检索条件取得用户信息结果条数
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息结果条数
	 */
	public int getUserSearchCount(UserSearchCond cond){

		return userTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据用户信息主键取得用户信息
	 * 
	 * @param userid 用户信息主键
	 * @return 用户信息
	 * @throws BLException 
	 */
	public User searchUserByKey(String userid) throws BLException{

		return checkExistUser(userid);
	}
	
	/**
	 * 根据检索条件取得用户信息列表
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息检索结果列表
	 */

	public List<User> searchUser(UserSearchCond cond){

		List<User> ret = userTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得用户信息列表
	 * 
	 * @param cond 用户信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户信息检索结果列表
	 */
	public List<User> searchUser(UserSearchCond cond, int start, int count){

		List<User> ret = userTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存用户信息处理
	 * 
	 * @param user 保存的用户信息数据
	 * @return 用户信息
	 * @throws BLException
	 */
	public User registUser(User user) throws BLException{
		UserTB userTB = new UserTB();
		this.copyProperties(userTB, user);
		userTB.setPassword(StringEncrypt.charToAscii(user.getPassword()));
		return userTBDAO.save(userTB);
	}
	
	/**
	 * 变更用户信息处理
	 * 
	 * @param user 变更的用户信息数据
	 * @return 用户信息
	 * @throws BLException
	 */
	public User updateUser(User user) throws BLException{
		checkExistUser(user.getUserid());
		UserTB userTB = new UserTB();
		this.copyProperties(userTB, user);
		userTB.setPassword(StringEncrypt.charToAscii(user.getPassword()));
		return userTBDAO.save(userTB);
	}

	/**
	 * 逻辑删除用户信息处理
	 * 
	 * @param user 逻辑删除的用户信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteUser(User user) throws BLException{
		checkExistUser(user.getUserid());
		userTBDAO.delete(user);
	}
	
	/**
	 * 根据用户信息主键删除用户信息处理
	 * 
	 * @param userid 删除用户信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteUserByKey(String userid) throws BLException {
		User user = checkExistUser(userid);
		userTBDAO.delete(user);
	}
	
	/**
	 * 用户信息存在检查
	 * 
	 * @param userid 用户信息ID
	 * @return 用户信息
	 * @throws BLException 
	 */
	protected User checkExistUser(String userid) throws BLException{
		User info = userTBDAO.findByPK(userid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","用户");
		}
		
		return info;
	}
	
	/**
	 * 根据检索条件取得用户信息结果条数
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息结果条数
	 */
	public int getUserInfoSearchCount(UserInfoSearchCond cond){

		return userInfoVWDAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得用户信息列表
	 * 
	 * @param cond 用户信息检索条件
	 * @return 用户信息检索结果列表
	 */

	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond){

		List<UserInfo> ret = userInfoVWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得用户信息列表
	 * 
	 * @param cond 用户信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 用户信息检索结果列表
	 */
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond, int start, int count){

		List<UserInfo> ret = userInfoVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 查询指定角色类型下的所有用户个数
	 * @param cond 检索条件
	 * @return 检索结果个数
	 */
	public int getUserCountByRoleType(UserInfoSearchCond cond){
		return userInfoVWDAO.getUserCountByRoleType(cond);
	}
	
	/**
	 * 查询指定角色类型下的所有用户
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<User> searchUserByRoleType(UserInfoSearchCond cond, int start, int count){
		return userInfoVWDAO.findUserByRoleType(cond, start, count);
	}
	/**
	 * 根据角色ID查询用户
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(Integer roleid){
		return userTBDAO.searchUserByRoleId(roleid);
	}
}
