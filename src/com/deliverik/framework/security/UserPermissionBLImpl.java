/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.dao.RoleActionVWDAO;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;

/**
 * Implementation of UserPermissionBL interface. It represents a specified
 * user's access rights to system operations, including menus and buttons
 * according to the user's roles.
 * 
 * @author: Jian Chen
 */

public class UserPermissionBLImpl extends BaseBLImpl implements UserPermissionBL {

	static Log log = LogFactory.getLog(UserPermissionBLImpl.class);
	
	/** 用户角色DAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** 角色菜单授权DAO */
	protected RoleActionVWDAO roleActionVWDAO;
	
	/** 菜单BL */
	protected ActionBL actionBL;
	
	/**
	 * 无参构造函数
	 */
	public UserPermissionBLImpl(){
		
	}
	
	/**
	 * 有参构造函数
	 * @param userId 用户ID
	 */
	public UserPermissionBLImpl(String userId) throws BLException{
		initUserPermission(userId);
	}
	
	/**
	 * 用户角色DAO设定
	 * @param userRoleVWDAO 用户角色DAO
	 */
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	/**
	 * 角色菜单授权DAO设定
	 * @param roleActionVWDAO 角色菜单授权DAO 
	 */
	public void setRoleActionVWDAO(RoleActionVWDAO roleActionVWDAO) {
		this.roleActionVWDAO = roleActionVWDAO;
	}
	
	/**
	 * 菜单BL设定
	 * @param actionBL 菜单BL
	 */
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}
	
	/**
	 * 用户菜单权限初始化
	 * @param userid 用户ID
	 * @return 用户菜单权限
	 * @throws BLException
	 */
	public UserPermission initUserPermission(String userid) throws BLException {
		
		//构造用户菜单权限对象
		UserPermission perm = new UserPermission();
		perm.setUserId(userid);//设定登录用户
		//获取用户被授权菜单集合
		List<Action> raiList = this.actionBL.searchUserAction(userid);
		//一级菜单集合
		Action firstAction = null;
		//二级菜单集合
		Action secondAction = null;
		//三级菜单集合
		Action thirdAction = null;
		//用户菜单权限集合
		List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList 
		= new ArrayList<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>();
		//一级菜单集合
		Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>> firstMap = null;
		//二级菜单集合
		Map<Action,List<Map<Action,List<Action>>>> secondMap = null;
		//三级菜单集合
		Map<Action,List<Action>> thirdMap = null;
		for(int i=0;i<raiList.size();i++){
			Action action = raiList.get(i);
			perm.addAction(action.getActname(),action.getActsortid());
			//构造一级菜单
			if("M1".equals(action.getActtype())){
				firstAction = action;
				firstMap = new LinkedHashMap<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>();
				firstMap.put(firstAction, new ArrayList<Map<Action,List<Map<Action,List<Action>>>>>());
				actionList.add(firstMap);
			}
			//构造二级菜单
			if("M2".equals(action.getActtype())){
				secondAction = action;
				secondMap = new LinkedHashMap<Action,List<Map<Action,List<Action>>>>();
				secondMap.put(secondAction, new ArrayList<Map<Action,List<Action>>>());
				if(firstMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关一级菜单");
				}
				firstMap.get(firstAction).add(secondMap);
			}
			//构造三级菜单
			if("M3".equals(action.getActtype())){
				thirdAction = action;
				thirdMap = new LinkedHashMap<Action,List<Action>>();
				thirdMap.put(thirdAction, new ArrayList<Action>());
				if(secondMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关二级菜单");
				}
				secondMap.get(secondAction).add(thirdMap);
			}
			//构造按钮，暂时不用
			if("M4".equals(action.getActtype())){
				if(thirdMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "相关三级菜单");
				}
				thirdMap.get(thirdAction).add(action);
			}
		}
		perm.setActionList(actionList);
		return perm;
	}
	
	
	
}
