/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Action;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_菜单授权VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04041VO extends BaseVO implements Serializable {

	/**
	 * 菜单对象List
	 */
	
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList;
	
	/**
	 * 构造方法
	 * @param actionList List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public IGSYM04041VO(List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}
	
	/**
	 * 获取菜单对象List
	 * @return List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> getActionList() {
		return actionList;
	}
	
}
