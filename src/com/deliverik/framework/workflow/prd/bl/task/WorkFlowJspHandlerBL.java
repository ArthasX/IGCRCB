/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * 流程JSP跳转HandlerBL
 * </p>
 */
public interface WorkFlowJspHandlerBL extends BaseBL {

	/**
	 * 流程跳转JSP取得
	 * 
	 * @param pdid流程定义ID
	 * @param prid流程ID
	 * @param pjdtype页面类型
	 * @param user登录用户信息
	 * @return JSP路径
	 */
	public String forwardExecute(String pdid, Integer prid, String pjdtype, User user) throws BLException;

}
