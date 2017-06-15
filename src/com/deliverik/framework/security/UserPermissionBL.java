/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
	 * �û��˵�Ȩ�޳�ʼ��
	 * @param userid �û�ID
	 * @return �û��˵�Ȩ��
	 * @throws BLException
	 */
	public UserPermission initUserPermission(String userid) throws BLException;

}