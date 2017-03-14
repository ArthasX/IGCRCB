/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;

/**
 * @Description: 流程OA执行人VO
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01091VO extends BaseVO implements Serializable {

	/** 用户列表 */
	protected List<UserInfo> userInfoList;
	
	/**
	 * 构造方法
	 * @param userInfoList用户列表
	 */
	public IGPRR01091VO(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	/**
	 * 用户列表取得
	 * @return 用户列表
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	
}
