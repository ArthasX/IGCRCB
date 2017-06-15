/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM02011VO extends BaseVO implements Serializable {

	/**
	 * 用户对象List
	 */
	
	protected List<User> userList;

	/**
	 * 构造方法
	 * @param userList List<User>
	 */
	
	public IGSYM02011VO(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * 获取用户对象List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}
}
