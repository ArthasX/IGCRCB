/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import org.hyperic.hq.hqapi1.types.Group;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_资源组授权授权查询VO
 * </p>
 * 
 * @author lujiayun 2012/11/19
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04221VO extends BaseVO implements Serializable {

	/**
	 * 已授权资源组对象List
	 */
	protected List<Group> groupList;
	/**
	 * 未授权资源组对象List
	 */
	protected List<Group> groupUnList;
	
	public IGSYM04221VO(List<Group> grantList,List<Group> ungrantList){
		this.groupList = grantList;
		this.groupUnList = ungrantList;
	}

	/**
	 * 已授权资源组对象List取得
	 *
	 * @return groupList 已授权资源组对象List
	 */
	public List<Group> getGroupList() {
		return groupList;
	}

	/**
	 * 未授权资源组对象List取得
	 *
	 * @return groupUnList 未授权资源组对象List
	 */
	public List<Group> getGroupUnList() {
		return groupUnList;
	}
}