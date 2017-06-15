/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程处理_按机构查询执行人VO
 * @Author  
 * @History 2013-02-28     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01211VO extends BaseVO implements Serializable {

	/** 参与人集合 */
	protected List<UserRoleInfo> lst_UserRoleInfo;

	/**
	 * 参与人集合取得
	 *
	 * @return lst_UserRoleInfo 参与人集合
	 */
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

	/**
	 * 参与人集合设定
	 *
	 * @param lst_UserRoleInfo 参与人集合
	 */
	public void setLst_UserRoleInfo(List<UserRoleInfo> lst_UserRoleInfo) {
		this.lst_UserRoleInfo = lst_UserRoleInfo;
	}
	
}
