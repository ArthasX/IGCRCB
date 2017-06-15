/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.zwj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询人员信息VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGZWJ01011VO extends BaseVO{
	/**	 * 用户对象List */	
	protected List<User> userList;

	/**
	 * 用户对象List取得
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * 用户对象List设置
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
