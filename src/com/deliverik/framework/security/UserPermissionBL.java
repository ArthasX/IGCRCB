/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.security;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * An interface providing method to check a specified user's access rights to system operations,
 * including menus and buttons according to the user's roles.
 * 
 * @author: Jian Chen
 */

public interface UserPermissionBL extends BaseBL{

	/**
	 * 用户菜单权限初始化
	 * @param userid 用户ID
	 * @return 用户菜单权限
	 * @throws BLException
	 */
	public UserPermission initUserPermission(String userid) throws BLException;

}