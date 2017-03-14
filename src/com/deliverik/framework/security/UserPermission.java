/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.user.model.Action;

/**
 * UserPermission bean to be set in user's session. It represents a specified
 * user's access rights to system operations, including menus and buttons
 * according to the user's roles.
 * 菜单权限对象
 */

public class UserPermission implements Serializable {

	public static final long serialVersionUID = 1L;
	
	/** 用户ID */
	protected String userId = null;
	
	/** 用户菜单权限集合*/
	protected Map<String,String> actionMap = new HashMap<String,String>();
	
	/** 用户菜单权限集合,页面head引用*/
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList = null;

	/**
	 * 无参构造函数
	 */
	public UserPermission() {
		
	}
	
	/**
	 * 有参构造函数
	 * @param userId 用户ID
	 */
	public UserPermission(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 判断用户是否对指定菜单可见
	 * @param actname 菜单ID
	 * @return true：可见，false：不可见
	 */
	public boolean checkPermission(String actname) {
		if (userId != null){
			return actionMap.containsKey(actname);
		}
		return false;
	}
	
	/**
	 * 指定菜单ACTSORTID取得
	 * @param actname 菜单ID
	 * @return ACTSORTID
	 */
	public String getActsortid(String actname) {
		if (checkPermission(actname)){
			return actionMap.get(actname);
		} else {
			return "";
		}
	}
	
	/**
	 * 添加菜单
	 * @param actname 菜单ID
	 */
	public void addAction(String actname, String actsortid) {
		actionMap.put(actname,actsortid);
	}
	
	/**
	 * 菜单集合大小取得
	 * @return 菜单集合大小
	 */
	public int getActionSize(){
		if (actionMap != null ) {
			return actionMap.size();
		} else {
			return 0;
		}
	}
	
	/**
	 * 用户菜单权限集合取得
	 * @return 用户菜单权限集合
	 */
	public Map<String, String> getActionMap() {
		return actionMap;
	}
	
	/**
	 * 用户菜单权限集合设定
	 * @param actionMap 用户菜单权限集合
	 */
	public void setActionMap(Map<String, String> actionMap) {
		this.actionMap = actionMap;
	}

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 用户ID设定
	 * @param userId 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户菜单权限集合取得
	 * @return 用户菜单权限集合
	 */
	public List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> getActionList() {
		return actionList;
	}

	/**
	 * 用户菜单权限集合设定
	 * @param actionList 用户菜单权限集合
	 */
	public void setActionList(
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}

}
